package week5.day2.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		 // 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		 // 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		 // 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		  //5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		 // 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		  //7. Click on Widget of From Contact
		Thread.sleep(3000);
		 driver.findElement(By.xpath("//img[@width='15']")).click();
		  //8. Click on First Resulting Contact
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> listHandles = new ArrayList <String>(windowHandles);
		 String string = listHandles.get(1);
		 driver.switchTo().window(listHandles.get(1));
		 driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		 // 9. Click on Widget of To Contact
		 driver.switchTo().window(listHandles.get(0));
		 driver.findElement(By.xpath("(//img[@width='15'])[2]")).click();
		  //10. Click on Second Resulting Contact
		 Set<String> windowHandles2 = driver.getWindowHandles();
		 List<String> listHandles1 = new ArrayList<String>(windowHandles2);
		 driver.switchTo().window(listHandles1.get(1));
		 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		 // 11. Click on Merge button using X-path Locator
		 driver.switchTo().window(listHandles1.get(0));
		 driver.findElement(By.xpath("//a[text()='Merge']")).click();
		  //12. Accept the Alert
		  Alert alert = driver.switchTo().alert();
		  alert.accept();
		  //13. Verify the title of the page
		  System.out.println(driver.getTitle());

	}

}