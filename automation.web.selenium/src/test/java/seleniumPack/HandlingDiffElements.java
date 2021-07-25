package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDiffElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/");

		// locators - 8
		// id, name, linktext, partiallinktext
		// tagname, classname, xpath, cssselector

		// plain text, para, label, etc
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);

		// links
//		driver.findElement(By.linkText("Sample Forms")).click();
		driver.findElement(By.partialLinkText("Sample ")).click();

		// checkbox
		driver.findElement(By.name("email_to[]")).click();

		// textbox
		driver.findElement(By.name("subject")).sendKeys("Selenium Webdriver");

		// dropdown
		WebElement dd = driver.findElement(By.name("q3"));
		Select sel = new Select(dd);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		sel.selectByVisibleText("Second Option");
		Thread.sleep(2000);
		sel.selectByValue("Fourth Option");

		// radio
		driver.findElement(By.id("q4")).click();

		// file upload
		driver.findElement(By.name("attach4589"))
				.sendKeys("E:\\Java Selenium\\LTWEJul17\\automation.web.selenium\\pom.xml");

		// captcha - not possible / stable. If you still want to check, go with OCR lib

		// button
		driver.findElement(By.name("submit")).click();

	}

}
