package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends PageBase {

	public ContactPage(WebDriver driver) {
		super(driver);
	}
	
    //Finding all elements related to Contact page 
	
	@FindBy(css="textarea.contact-msg")
	WebElement contactMsg;
	@FindBy(css="input.contact-input")
    WebElement fullName;
	@FindBy(id="contact-email")
	WebElement Email;
	@FindBy(id="confirm")
	WebElement checkBox;
	@FindBy(css="button.contact-submit")
    WebElement submit;
	@FindBy(css="p.feedback")
    public WebElement successMessage;
	
	
	//send contact data through the form 
     public void sendContactdata (String message, String fullname , String email)
     {
    	 setTextElemetText(contactMsg, message);
    	 setTextElemetText(fullName, fullname);
    	 setTextElemetText(Email, email);
    	 checkBox.click();
    	 submit.click();
    	 
     }
	
}
