package seleniumPack;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunctionality { // test scenario

	WebDriver driver;

	@Test(enabled = false) // test case
	public void verifyLoginForInvalidCredentials() throws IOException {
		String un = "neeraja";
		String pwd = "neeraja";

		LoginPage loginPage = new LoginPage(driver);
		String errorText = loginPage.login(un, pwd).login(un, pwd).login(un, pwd).getLoginErrorMsg();
//		Assert.assertEquals(errorText, "Incorrect login, please try again.");

		assertThat(errorText).startsWith("Incorrect").endsWith("again.");

	}

	@Test(dataProvider = "getLoginData", enabled = true)
	public void verifyLoginForDifferentRoles(String un, String pwd) {
		LoginPage loginPage = new LoginPage(driver);
		String errorText = loginPage.login(un, pwd).getLoginErrorMsg();
		Assert.assertEquals(errorText, "Incorrect login, please try again.");
	}

	@Test
	public void verifyMultipleWindow() {

		driver.findElement(By.linkText("Simple Web Feedback")).sendKeys(Keys.CONTROL, Keys.ENTER);

		Set<String> windIDs = driver.getWindowHandles();
		String firstID = windIDs.toArray()[0].toString();
		String secondID = windIDs.toArray()[1].toString();

		driver.switchTo().window(firstID);
		assertThat(driver.getTitle()).startsWith("Sample Email Forms").endsWith("- myContactForm.com");

		driver.switchTo().window(secondID);
		assertThat(driver.getTitle()).startsWith("Simple Web Feedback Form").endsWith("- myContactForm.com");

	}

	@DataProvider
	public Object[][] getLoginData() throws InvalidFormatException, IOException {
		File excel = new File(
				"C:\\Users\\p7165950\\Documents\\automation\\LTJul17WE\\automation.web.selenium\\resources\\TestData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(excel);
		XSSFSheet sh1 = book.getSheet("Sheet1");

		int rows = sh1.getLastRowNum() + 1;
		int colms = sh1.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][colms];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colms; j++) {
				data[i][j] = sh1.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;

//		Object[][] data = new Object[3][2];
//		data[0][0] = "admin";
//		data[0][1] = "admin";
//		
//		data[1][0] = "admin";
//		data[1][1] = "admin";
//		
//		data[2][0] = "admin";
//		data[2][1] = "admin";

//			{ 
//				{ "admin", "adminpassword" }, 
//				{ "operator", "operatorpassword" },
//				{ "user", "userpassword" } };
	}

	@Parameters("browser")
	@BeforeMethod // pre-condition to each test case
	public void setup(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		MyListener.driver = driver;

		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/samples.php");
	}

	@AfterMethod // post-condition to each test case
	public void cleanup() {
//		driver.close();
	}

}
