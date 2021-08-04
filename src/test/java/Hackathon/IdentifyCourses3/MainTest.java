package Hackathon.IdentifyCourses3;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Hackathon.IdentifyCourses3.DriverSetup;
import Hackathon.IdentifyCourses3.Extent_ReportTest;
import Hackathon.IdentifyCourses3.OutputExcel;



public class MainTest 
{
	static WebDriver driver;
	OutputExcel output;
	ExtentReports report;    //Variable to create ExtentReport
	ExtentTest test; 
	 
	@BeforeSuite
	public void ExtentReportSetup()   //Create Extent Report
	{
		Extent_ReportTest er=new Extent_ReportTest();
		report=er.create(report);
	}
	 
	@BeforeTest
	public void Setup() throws IOException
	{
		driver=DriverSetup.getDriver();
		output=new OutputExcel();
	}
	
	@Test
	public void validateSearchBox() throws IOException
	{
		test=report.createTest("validateSearchBox");
		driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']")).sendKeys("Web Development");
		captureScreenShot("validateSearchBox");
	}
	
	@Test
	public void validateSearchButton() throws IOException 
	{
		test=report.createTest("validateSearchButton");
		driver.findElement(By.xpath("//button[@id='nav-search-desktop-search-submit']")).click();
		captureScreenShot("validateSearchButton");
	}
	
	@Test(dependsOnMethods="validateSearchButton")
	public void validateCourseTab() throws IOException
	{
		test=report.createTest("validateCourseTab");
		driver.findElement(By.xpath("//div[@class='tab-wrapper pt-md-5 ']/div/div/div[2]/a")).click();
		captureScreenShot("validateCourseTab");
	}
	
	@Test(dependsOnMethods="validateSearchButton")
	public void validateLevelDropdownMenu() throws IOException, InterruptedException
	{
			test=report.createTest("validateLevelDropdownMenu");
		    driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/button")).click();
		    driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div/div/div[1]/ul/li[1]/label/input")).click();
		    
		    String l1=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div/div/div[1]/ul[1]/li[1]/label/span[1]")).getText();
		    String n1=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div/div/div[1]/ul[1]/li[1]/label/span[2]")).getText();
		    output.writeLevels(1, l1, n1);
		    
		    String l2=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div/div/div[1]/ul[1]/li[2]/label/span[1]")).getText();
		    String n2=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div/div/div[1]/ul[1]/li[2]/label/span[2]")).getText();
		    output.writeLevels(2, l2, n2);
		    
		    String l3=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div/div/div[1]/ul[1]/li[3]/label/span[1]")).getText();
		    String n3=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div/div/div[1]/ul[1]/li[3]/label/span[2]")).getText();
		    output.writeLevels(3, l3, n3);
		    
		    driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/button")).click();
		    captureScreenShot("validateLevelDropdownMenu");
	}
	
	@Test(dependsOnMethods="validateSearchButton")
	public void validateLanguagesDropdownMenu() throws IOException, InterruptedException
	{
		test=report.createTest("validateLanguagesDropdownMenu");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/button")).click();
		driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul/li[1]/label/input")).click();
		
		String l1=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul[1]/li[1]/label/span[1]")).getText();
		String n4=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul[1]/li[1]/label/span[2]")).getText();
		output.writeLanguage(1, l1, n4);
		
		String l2=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul[1]/li[2]/label/span[1]")).getText();
		String n5=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul[1]/li[2]/label/span[2]")).getText();
		output.writeLanguage(2, l2, n5);
		
		String l3=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul[1]/li[3]/label/span[1]")).getText();
		String n6=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul[1]/li[3]/label/span[2]")).getText();
		output.writeLanguage(3, l3, n6);
		
		String l4=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul[1]/li[3]/label/span[1]")).getText();
		String n7=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul[1]/li[3]/label/span[2]")).getText();
		output.writeLanguage(4, l4, n7);
		
		driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/button")).click();
		captureScreenShot("validateLanguagesDropdownMenu");
	}
	
	@Test(dependsOnMethods={"validateLanguagesDropdownMenu","validateLevelDropdownMenu"})
	public void validateCourseDetail1Page() throws InterruptedException, IOException
	{
		test=report.createTest("validateCourseDetail1Page");
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)","");
		driver.findElement(By.xpath("//div[@class='pgn__data-table-wrapper']/div[2]/div/div[1]/div/a")).click();
		String cn1=driver.findElement(By.xpath("//div[@class='row no-gutters']/div[1]/h1")).getText();
		String cd1=driver.findElement(By.xpath("//div[@class='row pl-1 pl-sm-0 my-1']/div[1]/div[1]/div[1]/span")).getText();
		output.writeCoursesDetail(1, cn1, cd1);
		captureScreenShot("validateCourseDetailPage");
	}
	
	@Test(dependsOnMethods={"validateLanguagesDropdownMenu","validateLevelDropdownMenu"})
	public void validateCourseDetail2Page() throws InterruptedException, IOException
	{
		test=report.createTest("validateCourseDetail2Page");
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='pgn__data-table-wrapper']/div[2]/div/div[2]/div/a")).click();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)","");
		String cn2=driver.findElement(By.xpath("//div[@class=\"row no-gutters\"]/div[1]/h1")).getText();
		String cd2=driver.findElement(By.xpath("//div[@class=\"row pl-1 pl-sm-0 my-1\"]/div[1]/div[1]/div[1]/span")).getText();
		output.writeCoursesDetail(2, cn2, cd2);
		captureScreenShot("validateCourseDetail2Page");
	}
	
	@Test(dependsOnMethods="validateCourseDetail2Page")
	public void validateHomePageButton() throws IOException
	{
		test=report.createTest("validateHomePageButton");
		driver.findElement(By.xpath("//img[@class='site-logo image-style-none']")).click();
		captureScreenShot("validateHomePageButton");
	}
	
	@Test(dependsOnMethods="validateHomePageButton",groups="regression")
	public void validateEdxBussinessLink() throws InterruptedException, IOException
	{
		test=report.createTest("validateEdxBussinessLink");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-tertiary menu-item']")).click();
		//Thread.sleep(2000);
		captureScreenShot("validateEdxBussinessLink");
	}
	
	@Test(dependsOnMethods="validateEdxBussinessLink",groups="regression")
	public void validateInvalidEmail() throws InterruptedException, IOException
	{
		test=report.createTest("validateInvalidEmail");
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)","");
		driver.findElement(By.xpath("//div[@class='form_main-box col-sm-12 col-md-6 col-lg-6']/div[1]/span[1]/div/form"
				                     +"/fieldset[1]/div[1]/div[1]/input")).sendKeys("Techno");
		driver.findElement(By.xpath("//div[@class='form_main-box col-sm-12 col-md-6 col-lg-6']/div[1]/span[1]/div/form"
				                     +"/fieldset[1]/div[2]/div[1]/input")).sendKeys("Crates");
		driver.findElement(By.xpath("//div[@class='form_main-box col-sm-12 col-md-6 col-lg-6']/div[1]/span[1]/div/form"
				                     +"/fieldset[2]/div[1]/div[1]/input")).sendKeys("abcd");
		driver.findElement(By.xpath("//div[@class='form_main-box col-sm-12 col-md-6 col-lg-6']/div[1]/span[1]/div/form"
				                     +"/fieldset[3]/div[1]/div[1]/div[1]/input[1]")).sendKeys("7278363739");
		Select select=new Select(driver.findElement(By.xpath("//div[@class='form_main-box col-sm-12 col-md-6 col-lg-6']/div[1]/span[1]/div/form/fieldset[4]/div[1]/div[1]/div[1]/select")));
		select.selectByVisibleText("Joining the edX Reseller Program");
		
		Select select1=new Select(driver.findElement(By.xpath("//div[@class='form_main-box col-sm-12 col-md-6 col-lg-6']/div[1]/span[1]/div/form/fieldset[4]/div[1]/div[2]/div[1]/select")));
		select1.selectByVisibleText("50 - 99 Learners");
		
		driver.findElement(By.xpath("//input[@type='submit' ]")).click();
		//Thread.sleep(2000);
		captureScreenShot("validateInvalidEmail");
		
	}
	
	@AfterMethod   
	public void testStatus(ITestResult result) throws IOException //Update extent report
	{
		String screenshot=captureScreenShot(result.getName());
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail(result.getName()+" Test got failed");
			test.fail(result.getThrowable());
			test.fail("ScreenShot: "+test.addScreenCaptureFromPath(screenshot));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass(result.getName()+" Test got Passed");
			test.pass("ScreenShot: "+test.addScreenCaptureFromPath(screenshot));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.skip(result.getName()+" Test got skipped");
			test.skip("ScreenShot: "+test.addScreenCaptureFromPath(screenshot));
		}
		report.flush();
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	public String captureScreenShot(String testName) throws IOException  //To capture screenshot
	{
		File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String desc=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		File target=new File(desc);
		FileUtils.copyFile(f1,target);
		return desc;
	}
}
