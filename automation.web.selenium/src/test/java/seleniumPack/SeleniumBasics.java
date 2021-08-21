package seleniumPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasics {

	public static void main(String[] args) throws InterruptedException {

		// Creating a system variable / OS
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Yasothai\\Downloads\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();

		// Open Browser
		WebDriver driver = new ChromeDriver();

		// Launch app url
		driver.get("https://www.mycontactform.com/samples.php");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS); // min 0, max 7 seconds, condition will be
																		// checked for every 0.5s

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());

		// Boolean methods
		WebElement ch1 = driver.findElement(By.name("email_to[]"));
		System.out.println(ch1.isDisplayed()); // true
		System.out.println(ch1.isEnabled()); // true
		System.out.println(ch1.isSelected()); // false

		// Navigation methods
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		//gettext and getattribute
		String visbleText = driver.findElement(By.linkText("Business Contact Form")).getText();
		System.out.println(visbleText);
		
		String hrefAtt = driver.findElement(By.linkText("Business Contact Form")).getAttribute("href");
		System.out.println(hrefAtt);
		
		
		driver.findElement(By.id("subject")).sendKeys("read test from text box");
		System.out.println(driver.findElement(By.id("subject")).getText());
		System.out.println(driver.findElement(By.id("subject")).getAttribute("value"));
		
		// <a href="https://www.mycontactform.com/samples/businesscontact.php">Business Contact Form</a>
		// <input name="subject" type="text" required="required"></input>
		
		
		
		

		driver.close();
	}

}
