package seleniumPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunctionality {

	WebDriver driver;
	
	// data-driven
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

	@BeforeMethod // pre-condition to each test case
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/samples.php");
	}

	@AfterMethod // post-condition to each test case
	public void cleanup() {
		driver.close();
	}

}
