package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	protected WebDriver driver;
	//Create Constructor 
	public PageBase(WebDriver driver) {
		
		/*Factory class to make using Page Objects simpler and easier	
		(this) mean the current class 
		1-(driver) The driver that will be used to look up the elements
		2-(page) The object with WebElement and List<WebElement> fields that 
		should be proxied.*/
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button)
	{
		button.click();
	}
	// static method so you will not need to create object 
	protected static void setTextElemetText(WebElement txtElement, String value ) {
		txtElement.sendKeys(value);

	}
}
