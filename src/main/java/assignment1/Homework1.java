package assignment1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {

	WebDriver driver;
	
	@Before 
	public void init() {	
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		 driver=new ChromeDriver();
		
		driver.get("https://techfios.com/billing/?ng=admin/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test

	public  void loginTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Bank & Cash')]")).click();
		
		driver.findElement(By.xpath("//a[@href=\"https://techfios.com/billing/?ng=accounts/add/\"]")).click();
		
		//filling out new account form
	    driver.findElement(By.xpath("//input[@name='account']")).sendKeys("Thazvia12345");
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Account");
		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("10000");
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@name=\'contact_person\']")).sendKeys("Jhon");
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("1111111111");
		driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-primary']")).click();
		
		
		
		
		
		Thread.sleep(3000);
	}
	
	@After 
	public  void tearDown() {
		
		driver.close();
		driver.quit();
	}
}
