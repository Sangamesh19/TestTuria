package Test.com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class TC_TB extends Generic
{
	
	
	@Test(priority =1)
	public void validLogin() throws InterruptedException  
	{
		
		// to Check the Login successfully or not
		Thread.sleep(5000);
	//	Assert.assertEquals(d.getTitle(), "Turia");
		
		ExtentTest l = extent.createTest("to_Check_Check_Box_isSelected_First_Item");
		l.log(Status.INFO, "Verified...");
		l.log(Status.PASS, "Passedd...");
		extent.flush();
	} 
 			
	@Test(priority =2,dependsOnMethods={"validLogin"})
	public void check_Navigating_to_Book_Item_Page()  
	{
		// Navigating to https://app.turia.in/books/items 
		d.navigate().to("https://app.turia.in/books/items?sortOrder=desc&sortColumn=createdAt&ApplyFil=ac");//  Navigate to https://app.turia.in/books/items
// OR Use Below one
//	    d.findElement(By.xpath("//span[contains(.,'Products & Services')]")).click(); // Navigate to https://app.turia.in/books/items  
	   Assert.assertEquals(d.getCurrentUrl(), "https://app.turia.in/books/items?sortOrder=desc&sortColumn=createdAt&ApplyFil=ac");
//	   extent.attachReporter(reporter);
//		extent.createTest("to_Check_Check_Box_isSelected_First_Item").log(Status.INFO, "Verified...");
//		extent.flush();
	} 		
	
	@Test(priority =3,dependsOnMethods={"check_Navigating_to_Book_Item_Page"})
	public void isList_isEmpty()  
	{
		// to Check the list is not Empty and to find the First Element
		Assert.assertTrue(d.findElement(By.xpath("//*[@id='email-app']/div/div[3]/ul/li[1]/section/div/div/div[3]")).isDisplayed());
//		extent.attachReporter(reporter);
//		extent.createTest("to_Check_Check_Box_isSelected_First_Item").log(Status.INFO, "Verified...");
//		extent.flush();		
	}
	
	@Test(priority=4,dependsOnMethods ={"isList_isEmpty"})
	void to_Check_Check_Box_isSelected_First_Item () 
	{
		// to check default the check should not be checked
		Assert.assertFalse(d.findElement(By.xpath("//*[@id='email-app']/div/div[3]/ul/li[1]/section/div/div/div[1]/div/input")).isSelected()); 
//		extent.attachReporter(reporter);
//		extent.createTest("to_Check_Check_Box_isSelected_First_Item").log(Status.INFO, "Verified...");
//		extent.flush();
	}
		
	@Test(priority=5,dependsOnMethods ={"isList_isEmpty"})
	void to_Check_Check_Box_isEnabled_First_Item () 
	{
		// to check  the check box is Enabled
		Assert.assertTrue(d.findElement(By.xpath("//*[@id='email-app']/div/div[3]/ul/li[1]/section/div/div/div[1]/div/input")).isEnabled()); 
//		extent.attachReporter(reporter);
//		extent.createTest("to_Check_Check_Box_isSelected_First_Item").log(Status.INFO, "Verified...");
//		extent.flush();
	}
	
	
	@Test(priority=6,dependsOnMethods ={"isList_isEmpty"})
	void to_Check_Check_Box_isClickable_First_Item () 
	{
		WebElement checkBoxFirstItem = d.findElement(By.xpath("//*[@id='email-app']/div/div[3]/ul/li[1]/section/div/div/div[1]/div/input")); // to click on the check box
		checkBoxFirstItem.click();
		Assert.assertTrue(checkBoxFirstItem.isSelected());
//		extent.attachReporter(reporter);
//		extent.createTest("to_Check_Check_Box_isSelected_First_Item").log(Status.INFO, "Verified...");
//		extent.flush();	
	}
	
	@Test(priority=7,dependsOnMethods ={"isList_isEmpty"})
	void to_More_Option_isDisplayed_First_Item () 
	{
		
		Assert.assertTrue(d.findElement(By.xpath("//*[@id='email-app']/div/div[3]/ul/li[1]/section/div/div/div[8]/div/div[3]/div/button")).isDisplayed());
//		extent.attachReporter(reporter);
//		extent.createTest("to_Check_Check_Box_isSelected_First_Item").log(Status.INFO, "Verified...");
//		extent.flush();		
	}
	@Test(priority=8,dependsOnMethods ={"isList_isEmpty"})
	void to_Check_More_Option_isEnabled_First_Item() 
	{
		
		Assert.assertTrue(d.findElement(By.xpath("//*[@id='email-app']/div/div[3]/ul/li[1]/section/div/div/div[8]/div/div[3]/div/button")).isEnabled());
//		extent.attachReporter(reporter);
//		extent.createTest("to_Check_Check_Box_isSelected_First_Item").log(Status.INFO, "Verified...");
//		extent.flush();		
	}
	
	@Test(priority=9,dependsOnMethods ={"isList_isEmpty"})
	void to_Check_Mark_as_Inactive_isDisplyed_First_Item () 
	{
		d.findElement(By.xpath("//*[@id='email-app']/div/div[3]/ul/li[1]/section/div/div/div[8]/div/div[3]/div/button")).click();
		Assert.assertTrue(d.findElement(By.xpath("//a[@class='vs-dropdown--item-link']")).isDisplayed());
//		extent.attachReporter(reporter);
//		extent.createTest("to_Check_Check_Box_isSelected_First_Item").log(Status.INFO, "Verified...");
//		extent.flush();		
	}
	
	// Please Uncomment below piece of code to add item into Inactive list
	
//	@Test(priority=10,dependsOnMethods ={"isList_isEmpty"})
//	void to_Check_Add_Item_Mark_Inactive () 
//	{
//		d.findElement(By.xpath("//*[@id='email-app']/div/div[3]/ul/li[1]/section/div/div/div[8]/div/div[3]/div/button")).click();
// 		d.findElement(By.xpath("//a[@class='vs-dropdown--item-link']")).click();
//		d.switchTo().alert().accept();
//	}

	@Test(priority=11,dependsOnMethods ={"isList_isEmpty"})
	void to_Check_in_Inactive_Services () 
	{
		d.findElement(By.xpath("//*[@id='email-app']/div/div[1]/div[1]/button")).click();
		d.findElement(By.xpath("//span[text()='Inactive Services']")).click();	
		Assert.assertTrue(d.findElement(By.xpath("//*[@id='email-app']/div/div[3]/ul/li[1]/section/div/div/div[3]")).isDisplayed());
//		extent.attachReporter(reporter);
//		extent.createTest("to_Check_Check_Box_isSelected_First_Item").log(Status.INFO, "Verified...");
//		extent.flush();		
	}
//BJBBH
//BJBBHljgkgkv

// Below Test Case is added on 12-05-2021 at 12:51 PM by Mr. XXX
//To check so and so functionality..

   @Test
  public void testqq()
  {
  }



//added
}
