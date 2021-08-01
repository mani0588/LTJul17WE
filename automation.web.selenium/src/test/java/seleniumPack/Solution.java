package seleniumPack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Solution {

	WebDriver webDriver;

	@FindBy(id = "email-input")
	WebElement txtEmail;
	@FindBy(id = "password-input")
	WebElement txtPassword;
	@FindBy(id = "login-button")
	WebElement btnLogin;

	@FindBy(xpath = "//div[@class='message success']")
	WebElement msgSuccess;

	@Test
	public void testEmailAndPasswordFieldsPresent() {

		Assert.assertTrue("Email testbox field is not present",
				webDriver.findElement(By.id("email-input")).isDisplayed());
		Assert.assertTrue("Password textbox field is not present",
				webDriver.findElement(By.id("password-input")).isDisplayed());
		Assert.assertTrue("Login button field is not present",
				webDriver.findElement(By.id("login-button")).isDisplayed());
	}

	@Test
	public void testLoginIsWorkingForValidCredentials() {
		webDriver.findElement(By.id("email-input")).sendKeys("login@codility.com");
		webDriver.findElement(By.id("password-input")).sendKeys("password");
		webDriver.findElement(By.id("login-button")).click();
		String successMsg = webDriver.findElement(By.xpath("//div[@class='message success']")).getText();

		Assert.assertTrue("Login is not success for valid credentials", successMsg.equals("Welcome to Codility"));
	}

	@Test
	public void testLoginFailsForInvalidCredentials() {
		webDriver.findElement(By.id("email-input")).sendKeys("unknown@codility.com");
		webDriver.findElement(By.id("password-input")).sendKeys("password");
		webDriver.findElement(By.id("login-button")).click();
		String errMsg = webDriver.findElement(By.xpath("//div[@class='message error']")).getText();

		Assert.assertTrue("Login error is not matching for invalid credentials",
				errMsg.equals("You shall not pass! Arr!"));
	}

	@Test
	public void testErrorForInvalidEmailFormat() {
		webDriver.findElement(By.id("email-input")).sendKeys("unknowncodility.com");
		webDriver.findElement(By.id("password-input")).sendKeys("password");
		webDriver.findElement(By.id("login-button")).click();
		String validationErr = webDriver.findElement(By.xpath("//div[@class='validation error']")).getText();

		Assert.assertTrue("Incorrect error message for invalid email format",
				validationErr.equals("Enter a valid email"));
	}

	@Test
	public void testErrorForEmptyCredentials() {
		webDriver.findElement(By.id("email-input")).clear();
		webDriver.findElement(By.id("password-input")).clear();
		webDriver.findElement(By.id("login-button")).click();
		String validationErrs = webDriver.findElement(By.id("messages")).getText();

		Assert.assertTrue("Incorrect error message for empty email", validationErrs.contains("Email is required"));
		Assert.assertTrue("Incorrect error message for empty password",
				validationErrs.contains("Password is required"));
	}

}
