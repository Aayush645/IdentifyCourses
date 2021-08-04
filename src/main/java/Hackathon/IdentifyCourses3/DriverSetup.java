package Hackathon.IdentifyCourses3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {
	public static WebDriver driver;

	public static WebDriver getDriver() throws MalformedURLException 
	{
		DesiredCapabilities d=new DesiredCapabilities();
		d.setBrowserName("chrome");
		d.setPlatform(Platform.WINDOWS);
		driver=new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"), d);
		driver.get("https://www.edx.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
}

