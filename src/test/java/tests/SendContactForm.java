/*user is able to open contact link
 *and Fill in the contact form and send it */


package tests;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
public class SendContactForm extends TestBase{

	HomePage homeObject; 
	ContactPage contactObject;
	String message ="I love trivago ! ";
	String email="test@test.com";
	String fullName="lover lover";

	@Test(alwaysRun=true)
	public void checkuserCansendContactForm() throws InterruptedException {
		homeObject = new HomePage(driver);

		//Close cookie message if displayed 
		homeObject.HandleCookie();

		//scroll down to find Contact link
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeObject.contact);
		homeObject.openContactPage();

		// Switch to the second tab 
		Set<String> tab_handles = driver.getWindowHandles();
		int number_of_tabs = tab_handles.size();
		int new_tab_index = number_of_tabs - 1;
		driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
		contactObject= new ContactPage(driver);
         
		
		//fill contact form
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm")));
		contactObject.sendContactdata(message,fullName,email);

		//Wait until success message is displayed 
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.feedback")));

		// Assert the success message is displayed to pass TC 
		Assert.assertTrue(contactObject.successMessage.isDisplayed());
		
	}
}
