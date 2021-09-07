package jile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Constraints extends BaseClass {

	@Test
	public void addApp() throws InterruptedException {
		WebElement mouse = driver.findElementById("kt_aside_toggler");
		Actions builder = new Actions(driver);
		builder.moveToElement(mouse).perform();
		Thread.sleep(20000);
		// to click configure menu
		driver.findElement(By.id("configureMenu")).click();
		// to click second app group
		driver.findElement(By.xpath("((//a[@class='kt-menu__link kt-menu__toggle'])[2]//span)[1]")).click();
		// click +App to go to app browser
		driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
		Thread.sleep(10000);
		// click product in app browser
		driver.findElement(By.xpath("(//span[text()='Product'])[32]")).click();
		// click constraints
		driver.findElement(By.xpath("(//span[text()='Constraints'])[2]")).click();
		// click on add button
		driver.findElement(By.xpath("(//button[text()='Add'])[11]")).click();
		// click X
		Thread.sleep(500);
		driver.findElement(By.xpath("(//i[@class='fa fa-close text-white'])[18]")).click();
		// click done to close app configuration
		driver.findElement(By.id("exitConfiguration")).click();
		Thread.sleep(5000);
		// mouse hover on apps menu
		builder.moveToElement(mouse).perform();
		Thread.sleep(8000);
		// click the group where app is added
		driver.findElement(By.xpath("((//a[@class='kt-menu__link kt-menu__toggle'])[2]//span)[1]")).click();
		Thread.sleep(9000);
		// click on added app(constraints)
		driver.findElement(By.xpath("(//span[text()='Constraints'])[1]")).click();
		// click new constraint
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='constraints_business_grid']")).click();
		Thread.sleep(9000);
		// enter title
		driver.findElement(By.xpath("(//input[@id='folderName'])[2]")).sendKeys("Automate constarints 1");
		// select Type
		WebElement Type = driver.findElement(By.xpath("(//select[@formcontrolname='categoryId'])[2]"));
		Select type = new Select(Type);
		type.selectByVisibleText("Rules");
		// enter description
		driver.findElement(By.xpath("//div[@data-placeholder='Enter the description']")).sendKeys("Constraint added thruogh automation 1");
		// click submit
		driver.findElement(By.xpath("(//button[@type='submit'])[12]")).click();
		// get added entity details
		WebElement newtable = driver.findElement(By.id("businessTable"));
		List<WebElement> rows = newtable.findElements(By.tagName("tr"));
		int newdata = rows.size();
		for (int i =(newdata-2); i <newdata ; i++) {
			WebElement rowdata = rows.get(i);
			System.out.println("Details of new constraint : " + rowdata.getText());

		}
	}

	/*
	 * @DataProvider public String[][] addData() { String[][] data1 = new
	 * String[2][2]; data1[0][0] = ""; data1[0][1] =
	 * "Constraint added thruogh automation 1";
	 * 
	 * data1[1][0] = "Automate constarints 2"; data1[1][1] =
	 * "Constraint added thruogh automation 2"; return data1; }
	 * 
	 */	@Test(enabled=false)
	public void edit() throws InterruptedException {
		// click on second entity quick edit
		Thread.sleep(8000);
		driver.findElement(By.xpath("//table[@id='businessTable']//tr[2]/td[6]//i")).click();
		// edit description(clear existing and add new)
		Thread.sleep(500);
		WebElement description = driver.findElement(By.xpath("//div[@id='initDescId']"));
		description.clear();
		description.sendKeys("edit thruogh automation");
		// edit title(append text)
		driver.findElement(By.xpath("(//input[@id='folderName'])[2]")).sendKeys(" Added and edited");
		// click submit to save changes
		driver.findElement(By.xpath("(//button[@type='submit'])[12]")).click();
	}

	@Test(enabled=false)
	public void delete() throws InterruptedException {
		// delete first constraint in page
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//table[@id='businessTable']//tr[2]/td[6]//i)[2]")).click();
		// yes to confirm
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
	}

	@Test(enabled=false)
	public void filters() throws InterruptedException {
		// click filters
		Thread.sleep(7000);
		driver.findElement(By.xpath("(//a[@class='btn btn-icon-only btn-default']/i)[2]")).click();
		// click type field
		Thread.sleep(7000);
		driver.findElement(By.xpath("(//a[@class='accordion-toggle '])[10]")).click();
		// choose type
		driver.findElement(By.xpath("(//input[@class='icheck'])[10]")).click();
		// click apply
		driver.findElement(By.xpath("(//button[text()='Apply'])[2]")).click();
		Thread.sleep(5000);
		// check result
		WebElement table1 = driver.findElement(By.id("businessTable"));
		List<WebElement> row1 = table1.findElements(By.tagName("tr"));
		for (WebElement result : row1) {
			String filterResult = result.getText();
			System.out.println("Filtered results are : " + filterResult);
		}
		Thread.sleep(800);
	}

	@Test(enabled=false)
	public void negative() throws InterruptedException {
		// click new constraint
		driver.findElement(By.id("constraints_business_grid")).click();
		Thread.sleep(9000);
		// click submit
		driver.findElement(By.xpath("(//button[@type='submit'])[12]")).click();
		// verify error message and click ok
		String errorMessage = driver.findElement(By.xpath("//div[@class=' modal-alert-body-msg ']/div")).getText();
		System.out.println("Constraint Quick Add Error: " + errorMessage);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		// close quick add screen
		Thread.sleep(500);
		driver.findElement(By.id("constraints-modal-cancel-btn")).click();
		// quick edit
		driver.findElement(By.xpath("//i[@class='fa fa-pencil text-green']")).click();
		Thread.sleep(500);
		// remove title
		WebElement title = driver.findElement(By.xpath("(//input[@id='folderName'])[2]"));
		title.clear();
		Thread.sleep(600);
		// click submit
		driver.findElement(By.xpath("(//button[@type='submit'])[12]")).click();
		// verify error
		String editerror = driver.findElement(By.xpath("//div[@class=' modal-alert-body-msg ']/div")).getText();
		System.out.println("Quick edit error: " + editerror);
		driver.findElement(By.xpath("(//button[text()='OK'])[1]")).click();
		// close quick edit screen
		driver.findElement(By.id("constraints-modal-cancel-btn")).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();

	}
}
