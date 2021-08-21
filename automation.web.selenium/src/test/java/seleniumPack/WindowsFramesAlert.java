package seleniumPack;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsFramesAlert {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/met_win_alert.asp");
		driver.findElement(By.linkText("Try it Yourself »")).click();

		// Handling multiple windows
		Set<String> windIDs = driver.getWindowHandles();
		int numOfWinds = windIDs.size();
		System.out.println("There are " + numOfWinds + " windows");

		String secondID = windIDs.toArray()[1].toString();
		System.out.println(driver.getTitle());
		driver.switchTo().window(secondID);
		System.out.println(driver.getTitle());

		// Handling frames
		int numOfFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("There are " + numOfFrames + " frames");

		driver.switchTo().frame("iframeResult"); // going inside frame
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		// Handling alert
		String altMsg = driver.switchTo().alert().getText();
		System.out.println(altMsg);

		driver.switchTo().alert().accept(); // ok, yes, continue, etc
//		driver.switchTo().alert().dismiss(); // no, reject, close, etc

		driver.switchTo().defaultContent(); // come outside the frame or main page

		// close and quit
//		driver.close(); // close current tab / window
		driver.quit(); // close all associated window to driver

	}

}
