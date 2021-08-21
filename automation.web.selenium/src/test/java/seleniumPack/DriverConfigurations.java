package seleniumPack;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfigurations {

	public static void main(String[] args) {

		// Excel
		// Open issues
		// logs
		// waits

		// Settings / configs
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito", "--start-maximized", "--headless");

		Map<String, Object> configs = new HashMap<>();
		configs.put("download.default_directory",
				"C:\\Users\\p7165950\\Documents\\automation\\LTJul17WE\\automation.web.selenium");
		co.setExperimentalOption("prefs", configs);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co); // temp profile

//		driver.manage().window().maximize();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_a_download");
		driver.switchTo().frame("iframeResult"); // going inside frame
		driver.findElement(By.xpath("//img[@src='/images/myw3schoolsimage.jpg']")).click();

	}

}
