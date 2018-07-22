/*Test Base class to start the driver 
 *close it and take screenshots in case of failure */

package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import utilities.Helper;

public class TestBase   {
	
	public static WebDriver driver;

	//actions will be taken after each test case 
	@BeforeClass
	// use Chrome browser
	public void startDriver() {
		
			//userDir is the directory of the project 
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
			//maximize your window before getting URL 
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
			driver.navigate().to("http://room5.trivago.com/");
		
	}
	
    //actions will be taken after each test case 
	@AfterClass
	public void stopDriver() {
		//will close the driver 
		driver.quit();
	}
	
	//take screenshot when test case failed and add it to screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE){
			System.out.println("Failed!");
			System.out.println("Taking screenshots...");
			Helper.captureScreenShot(driver, result.getName());
		}
	}
}
