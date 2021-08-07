package seleniumPack;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunctionality {

	WebDriver driver;

	// logs
	// custom asserts

	@Test // test case
	public void verifyLoginForInvalidCredentials() throws IOException {
		String un = "neeraja";
		String pwd = "neeraja";

		LoginPage loginPage = new LoginPage(driver);
		String errorText = loginPage.login(un, pwd).login(un, pwd).login(un, pwd).getLoginErrorMsg();
		Assert.assertEquals(errorText, "Incorrect login, please try again.");

		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screen, new File(
				"C:\\Users\\p7165950\\Documents\\automation\\LTJul17WE\\automation.web.selenium\\MyContactScreen.png"));

	}
	
	@Test(dataProvider="getLoginData")
	public void verifyLoginForDifferentRoles(String un, String pwd) {
		LoginPage loginPage = new LoginPage(driver);
		String errorText = loginPage.login(un, pwd).getLoginErrorMsg();
		Assert.assertEquals(errorText, "Incorrect login, please try again.");
	}
	
	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data = {{"admin", "adminpassword"}, {"operator", "operatorpassword"}, {"user", "userpassword"}};
		return data;
	}

	@Parameters("browser")
	@BeforeMethod // pre-condition to each test case
	public void setup(String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/samples.php");
	}

	@AfterMethod // post-condition to each test case
	public void cleanup() {
		driver.close();
	}

}
