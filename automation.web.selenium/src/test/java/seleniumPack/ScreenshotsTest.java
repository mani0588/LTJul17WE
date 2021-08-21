package seleniumPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotsTest {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/samples.php");
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS, 1000).withName("Page title - Test")
				.save("Screenshots");

	}
}
