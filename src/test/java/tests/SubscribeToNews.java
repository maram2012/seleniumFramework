/*The aim of these TC is to check the user
 * is able to send his contact to get more news from trivago*/

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class SubscribeToNews extends TestBase {
    String email="test@test.com";
	HomePage homeObject ;
	@Test
	public void UserCanSubscribetoNewsLetter() {
		homeObject= new HomePage(driver);
		homeObject.subscribeToNews(email);
		
		//Wait until success message is displayed 
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.submitted.h1")));
        
		
		//Check success message is displayed 
		Assert.assertTrue(homeObject.submitted_sucess.isDisplayed());
	}

	
}
