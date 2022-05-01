package week5.day1.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTC {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	    driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		String new_Window = listHandles.get(1);
		driver.switchTo().window(listHandles.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(listHandles.get(0));
		System.out.println(driver.getTitle());
	}
}

	    