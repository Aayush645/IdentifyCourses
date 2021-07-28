package Hackathon.IdentifyCourses3;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	public static WebDriver driver;

	public static WebDriver open() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of your Preferred Browser");
		String brwsr = input.next();
		if (brwsr.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Aayush\\eclipse-workspace\\IdentifyCourses\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.edx.org/");
			driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		} else if (brwsr.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Aayush\\eclipse-workspace\\IdentifyCourses\\drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.edx.org/");
			driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		} else {
			System.out.println("Invalid Choice");
		}
		return driver;
	}
}

