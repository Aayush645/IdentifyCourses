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



public class MainTest 
{
	WebDriver driver;
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
	public void driverSetup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Aayush\\eclipse-workspace\\IdentifyCourses3\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.edx.org/");
		driver.manage().window().maximize();
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
	public void validateSearchButton() throws InterruptedException, IOException
	{
		test=report.createTest("validateSearchButton");
		driver.findElement(By.xpath("//button[@id='nav-search-desktop-search-submit']")).click();
		//Thread.sleep(2000);
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
		    driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/button")).click();
		    //Thread.sleep(2000);
		    captureScreenShot("validateLevelDropdownMenu");
	}
	
	@Test(dependsOnMethods="validateSearchButton")
	public void validateLanguagesDropdownMenu() throws IOException, InterruptedException
	{
		test=report.createTest("validateLanguagesDropdownMenu");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/button")).click();
		driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div/div/div[1]/ul/li[1]/label/input")).click();
		driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/button")).click();
		captureScreenShot("validateLanguagesDropdownMenu");
	}
	
	@Test(dependsOnMethods={"validateLanguagesDropdownMenu","validateLevelDropdownMenu"})
	public void validateCourseDetailPage() throws InterruptedException, IOException
	{
		test=report.createTest("validateCourseDetailPage");
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)","");
		driver.findElement(By.xpath("//div[@class='pgn__data-table-wrapper']/div[2]/div/div[1]/div/a")).click();
		//Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Introduction to Cloud Development with HTML5, CSS3')]")).getText());
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Estimated 4 weeks')]")).getText());
		captureScreenShot("validateCourseDetailPage");
	}
	
	@Test(dependsOnMethods="validateCourseDetailPage")
	public void validateHomePageButton() throws IOException
	{
		test=report.createTest("validateHomePageButton");
		driver.findElement(By.xpath("//img[@class='site-logo image-style-none']")).click();
		captureScreenShot("validateHomePageButton");
	}
	
	@Test(dependsOnMethods="validateHomePageButton")
	public void validateEdxBussinessLink() throws InterruptedException, IOException
	{
		test=report.createTest("validateEdxBussinessLink");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-tertiary menu-item']")).click();
		//Thread.sleep(2000);
		captureScreenShot("validateEdxBussinessLink");
	}
	
	@Test(dependsOnMethods="validateEdxBussinessLink")
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
