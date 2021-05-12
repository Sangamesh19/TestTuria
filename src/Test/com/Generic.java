package Test.com;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.util.*;  
import java.io.*;  
public class Generic {
	
	public WebDriver d;
	String path="./Soft/Config.properties";
//	public ExtentReports extent;
//	public ExtentHtmlReporter reporter;
	
	@BeforeClass
	public void appLogin() throws IOException, InterruptedException
	{
//		reporter =new ExtentHtmlReporter("./R/testReport.html");
//		extent =new ExtentReports();
//		extent.attachReporter(reporter);
		
		Properties obj= new Properties();
		FileInputStream objFile = new FileInputStream(path);
		obj.load(objFile);
		System.setProperty(obj.getProperty("DriverType"),obj.getProperty("DriverPath"));
		d=new ChromeDriver();
		d.get(obj.getProperty("URL"));
		WebDriverWait w=new WebDriverWait(d, 20);
		w.until(ExpectedConditions.titleContains("Turia"));
	
		
		
		
		
// Code for Login
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.findElement(By.name("email")).sendKeys(obj.getProperty("UserId"));
		d.findElement(By.name("password")).sendKeys(obj.getProperty("PWD"));
		d.findElement(By.xpath("//span[text()='Login']")).click();
		w.until(ExpectedConditions.titleContains("Turia"));
		Thread.sleep(2000);
 }
	
	@AfterClass
	public void appLogOut() throws InterruptedException
	{
// Logout Scrip"t
//		d.findElement(By.xpath("//*[@id='content-area']/div[2]/div[1]/div/header/div[2]/div[8]/div/div[2]/div")).click();
		
	//	d.findElement(By.xpath("//span[text()=' Turia ']")).click();
		d.findElement(By.xpath("(//span[@title='Turia' and @class='vs-avatar--text notranslate'])[2]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//i[text()='logout']")).click();
		Thread.sleep(5000);
		d.close(); 
				
	}

}
