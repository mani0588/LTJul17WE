package seleniumPack;

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
import seleniumPack.LoginPage;

public class LoginFunctionality {

	WebDriver driver;
	
	// Test types - Regression, etc
	// Browser compatability
	// testng xml
	// paramters
	// screenshots
	// logs
	// custom asserts

	@Test // test case
	public void verifyLoginForInvalidCredentials() {
		String un = "neeraja";
		String pwd = "neeraja";
		
		LoginPage loginPage = new LoginPage(driver);
		String errorText = loginPage.login(un, pwd).login(un, pwd).login(un, pwd)
				.getLoginErrorMsg();
		Assert.assertEquals(errorText, "Incorrect login, please try again.");
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
