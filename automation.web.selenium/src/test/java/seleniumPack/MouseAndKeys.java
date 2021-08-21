package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseAndKeys {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/samples.php");
		
		// Keys
		driver.findElement(By.id("user")).sendKeys("manikandan", Keys.TAB, "passwordddjkvdakjv", Keys.ENTER);
		
		// Mouse / Actions
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.click(driver.findElement(By.name("email_to[]"))).build().perform();
		Thread.sleep(5000);
		act.doubleClick(driver.findElement(By.name("email_to[]"))).build().perform();
		Thread.sleep(5000);
		act.contextClick(driver.findElement(By.name("email_to[]"))).build().perform();
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By.linkText("Testimonials"))).build().perform();
		Thread.sleep(5000);
		

	}

}
