package seleniumPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//	WebElement usertxt = driver.findElement(By.xpath("//input[@name='user']"));

	@FindBy(xpath = "//input[@name='user']")
	WebElement txtUsername;
	@FindBy(xpath = "//input[@name='pass']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@name='btnSubmit']")
	WebElement btnLogin;

	@FindBy(id = "right_col_top_err")
	WebElement errLoginInvalid;

	WebDriver driver;
	
	// POM - Page Object Model
	
	// Eager implementation
	// Lazy implementation
	public LoginPage(WebDriver myDriver) {
		driver = myDriver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage login(String un, String pwd) {
		txtUsername.sendKeys(un);
		txtPassword.sendKeys(pwd);
		btnLogin.click();
		return this;
	}

	public String getLoginErrorMsg() {
		return errLoginInvalid.getText();
	}

}
