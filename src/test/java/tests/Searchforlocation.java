/*The aim of this TC is to check that
 * the user is able to search for any location*/

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
public class Searchforlocation extends TestBase{
	HomePage homeObject;
	String location = "Paris";

	@Test(priority=1,alwaysRun=true)
	public void userCanSearchForAnyLocation () throws InterruptedException {
		homeObject= new HomePage(driver);
		//homeObject.HandleCookie();
		homeObject.clickOnSearchIcon();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.search-icon")));
		homeObject.searchforlocation(location);


		//Wait until success message is displayed 
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.search-results")));
		org.testng.Assert.assertTrue(homeObject.results.isDisplayed());

		homeObject.exitSearch();
	}
} 
