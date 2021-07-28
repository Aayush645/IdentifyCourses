package Hackathon.IdentifyCourses3;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest 
{
	WebDriver driver;
	OutputExcel output;
	
	@BeforeTest
	public void driverSetup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Aayush\\eclipse-workspace\\IdentifyCourses3\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.edx.org/");
		driver.manage().window().maximize();
		output=new OutputExcel();
	}
	
	@Test
	public void searchText() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']")).sendKeys("Web Development");
		driver.findElement(By.xpath("//button[@id='nav-search-desktop-search-submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/button")).click();
	
		String level1=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/div/ul/li[1]/label/span[1]")).getText();
		String n1=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/div/ul/li[1]/label/span[2]")).getText();
		output.writeLevels(1, level1, n1);
		
		String level2=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/div/ul/li[2]/label/span[1]")).getText();
		String n2=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/div/ul/li[2]/label/span[2]")).getText();
		output.writeLevels(2, level2, n2);
		
		String level3=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/div/ul/li[3]/label/span[1]")).getText();
		String n3=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[4]/div[1]/div[1]/div/ul/li[3]/label/span[2]")).getText();
		output.writeLevels(3, level3, n3);
		
		// Languages print on Excel
		driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/button")).click();
		String lang1=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/div/ul/li[1]/label/span[1]")).getText();
		String n4=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/div/ul/li[1]/label/span[2]")).getText();
		output.writeLanguage(1, lang1, n4);
		
		String lang2=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/div/ul/li[2]/label/span[1]")).getText();
		String n5=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/div/ul/li[2]/label/span[2]")).getText();
		output.writeLanguage(2, lang2, n5);
		
		String lang3=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/div/ul/li[3]/label/span[1]")).getText();
		String n6=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/div/ul/li[3]/label/span[2]")).getText();
		output.writeLanguage(3, lang3, n6);
		
		String lang4=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/div/ul/li[4]/label/span[1]")).getText();
		String n7=driver.findElement(By.xpath("//div[@class='d-flex bg-primary-700 pt-2 pt-sm-3 mt-sm-1 mb-3 search-refinements']/div[6]/div[1]/div[1]/div/ul/li[4]/label/span[2]")).getText();
		output.writeLanguage(4, lang4, n7);
	}
	
	@Test
	public void testBussiness() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class='btn btn-tertiary menu-item']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='form_main-box col-sm-12 col-md-6 col-lg-6']/div[1]/span[1]/div/form/fieldset[2]/div[1]/div[1]/input")).sendKeys("abc@gmail.com");
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)","");
		driver.findElement(By.xpath("//input[@type='submit' ]")).click();
		
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
