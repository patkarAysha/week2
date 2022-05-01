package week5.day2.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev121343.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//switch into frame
		driver.switchTo().frame(0);
		//Enter username (Check for frame before entering the username)
		driver.findElement(By.id("user_name")).sendKeys("admin");
		//Enter password 
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		//Click Login
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		//Search “incident “ Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident");		
		//Click “All”
		driver.findElement(By.xpath("(//div[text()='All'][@class='sn-widget-list-title'])[2]")).click();
		//Click New button
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='New'][@id='sysverb_new']")).click();
		//Step8: Select a value for Caller and Enter value for short_description
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listHandles = new ArrayList<String>(windowHandles);
		String string = listHandles.get(1);
		driver.switchTo().window(listHandles.get(1));
		driver.findElement(By.xpath("//tbody[@class='list2_body']//tr[5]/td[3]")).click();
		driver.switchTo().window(listHandles.get(0));
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.name("incident.short_description")).sendKeys("Issue with email");
		//Step9: Read the incident number and save it a variable
		WebElement incident = driver.findElement(By.xpath("//input[@id='incident.number']"));
        String attribute = incident.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(2000);
		//Step10: Click on Submit button
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//Step 11: Search the same incident number in the next search screen as below
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(attribute,Keys.ENTER);
		//Step12: Verify the incident is created successful.
		String text = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(text.contains(attribute))
		{
			System.out.println("Incident Creation Successful");
		}
		else
		{
			System.out.println("Incident Creation Failed"); 
		};

		

	}

}
