package week5.day2.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3School {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert3 = driver.switchTo().alert();
		driver.switchTo().frame(0);
		System.out.println(alert3.getText());
		alert3.sendKeys("Preethi");
		alert3.accept();
	}

}