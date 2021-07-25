package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingGroupOfElements {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/samples.php");

		// Select all check boxes
		// Xpath syntax - //tagname[@attName='attValu']
		List<WebElement> chks = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int numOfChks = chks.size();
		for (int i = 0; i < numOfChks; i++) {
			chks.get(i).click();
		}
		
		// Print all link text
		

	}

}
