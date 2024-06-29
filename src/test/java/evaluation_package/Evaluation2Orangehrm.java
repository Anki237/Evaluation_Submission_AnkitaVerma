package evaluation_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Evaluation2Orangehrm {
	WebDriver driver;
	@BeforeTest
	public void bt() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	@Test(enabled = true)
	public void t1() throws InterruptedException {
//login
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
//admin module		
		driver.findElement(By.cssSelector("[href=\"/web/index.php/admin/viewAdminModule\"]")).click();
		driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]")).sendKeys("Ankita");
		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
		WebElement check1=  driver.findElement(By.xpath("//div[@class=\"oxd-select-option\" and .=\"ESS\"]"));
		check1.click();
		 driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("r");
		 driver.findElement(By.xpath("//div[@class=\"oxd-autocomplete-option\" and .=\"Ranga  Akunuri\"]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
		 WebElement check2=  driver.findElement(By.xpath("(//div[@class='oxd-select-option'])[2]"));
	     check2.click();
//webtable
	     List<WebElement> list = driver.findElements(By.xpath("(//div[@role=\"row\"])/div[4]/div"));
	     List<WebElement> list2 = driver.findElements(By.xpath("(//div[@role=\"row\"])/div[5]/div"));
	     for(int i=1;i<list.size();i++) {
	    	 
	    	 if(list.get(i).getText().trim().equals("'James Butler")&& list2.get(i).getText().trim().equals("enabled")){
	    		 Assert.assertTrue(false, "THAT employee is  in the list");
	    	 }
	    	 else {
	    		 Assert.assertTrue(false, "THAT employee is not in the list");
	    	 }
	  //logout
	     }
	       
	     driver.findElement(By.cssSelector("i[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		 driver.findElement(By.xpath("(//a[@role=\"menuitem\"])[4]")).click();
		
		
		
}
	@AfterTest
	public void end() {
		driver.close();
	}
	
}