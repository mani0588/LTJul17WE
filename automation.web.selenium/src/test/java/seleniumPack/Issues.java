package seleniumPack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Issues {

	public static void main(String[] args) throws InterruptedException, IOException {

//		Interface - signatures / method outline only - public void sum();

//		WebDriver, WebElement, Actions, etc - Selenium
//		List, Set, Map, etc - Java

		List<Integer> list = new ArrayList<>();
		list.add(10);
		System.out.println(list);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=hello");

//		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS, 2000).save();
		Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(s.getImage(), "PNG", new File(".\\GoogleHelloFullPage.png"));

	}

}
