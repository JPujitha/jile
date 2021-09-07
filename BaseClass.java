package jile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class BaseClass {
	public ChromeDriver driver;
@Parameters({"URL","Mail","Password"})
	@BeforeClass
	public void login(String url,String mail,String pswd) throws InterruptedException {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Application Launched Successfully");
		driver.findElement(By.id("mainEmailId")).sendKeys(mail);
		driver.findElementById("mainPasswordId").sendKeys(pswd);
		driver.findElementById("main-login-btn").click();
		Thread.sleep(10000);
	}
	
	/*
	 * @AfterClass public void close() { driver.close(); }
	 */  }
