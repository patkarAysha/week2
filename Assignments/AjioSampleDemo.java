package week5.day1.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioSampleDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.ajio.com/");
		driver.findElement(By.name("searchVal")).sendKeys("Bags", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		String noBags = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println(noBags);
		List<WebElement> products = driver.findElements(By.className("brand"));
		System.out.println(products.size());
		for (WebElement webElement1 : products) {
			String text = webElement1.getText();
			System.out.println(text);
		}
		List<WebElement> names = driver.findElements(By.className("nameCls"));

		for (WebElement namesList : names) {
			String name = namesList.getText();
			System.out.println(name);
		}

	}

}