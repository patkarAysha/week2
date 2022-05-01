package week5.day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.switchTo().frame(0);
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		WebElement reSize = driver.findElement(By.xpath("//div[@id ='resizable']"));
		Point location = reSize.getLocation();
		builder.dragAndDropBy(reSize, location.getX(), location.getY()).perform();

	}

}
