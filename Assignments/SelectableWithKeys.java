package week5.day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableWithKeys {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
        WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
        WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
        WebElement item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
        WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
        WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
        WebElement item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).click(item1).click(item3).click(item5).click(item7).keyUp(Keys.CONTROL).perform();
        
	}

}