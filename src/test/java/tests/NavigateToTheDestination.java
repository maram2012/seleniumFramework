/*The aim of this TC is check that the user
 * is able to select any destination and navigate to it */

package tests;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class NavigateToTheDestination extends TestBase{
	HomePage homeObject;
	HomePage destObject;
	@Test
	public void userCanNavigateToaDestination() {

		homeObject = new HomePage(driver);

		// select destination 
		homeObject.selectDestination();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.nav-icon")));

		// navigate to destination tab 
		Set<String> tab_handles = driver.getWindowHandles();
		int number_of_tabs = tab_handles.size();
		int new_tab_index = number_of_tabs - 1;
		driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());

		//give driver the new tab 
		destObject= new HomePage(driver);

		//Assert that user navigate to destination page successfully 
		Assert.assertTrue(destObject.sucess_destination.isDisplayed());


	}


}
