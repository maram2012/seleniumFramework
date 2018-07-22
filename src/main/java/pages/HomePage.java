package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		}
	
	//finding all elements in homePage 
	
	@FindBy(css="div.search-icon")
	WebElement searchIcon;
	
	@FindBy(css="input.search-input")
	WebElement inputSearch;	
	
	@FindBy(css="div.search-results")
	public WebElement results;	
	
	@FindBy(css="div.Cookie__button")
	WebElement cookie;
	
	@FindBy(linkText="Contact")
	public WebElement contact;
	
	@FindBy (name="email")
	WebElement email;
	
	@FindBy (id="confirm")
	WebElement confirm;
	
	@FindBy (css="button.submit")
	WebElement submit;
	
	@FindBy  (css="p.submitted.h1")
	public WebElement submitted_sucess;
	
	@FindBy (css="div.nav-icon")
	WebElement menu;

	@FindBy (css="div.menu-container")
	WebElement menuOfdestination;
	
	@FindBy (css="span.hero-image")
	public WebElement sucess_destination;
	
	//Collect all the links in the web page based on <a> tag.
	@FindBy (tagName="a")
	public List <WebElement> UrlList;
	
	//collect all images in the web page based on <img> tag 
	@FindBy (tagName="img")
	public List<WebElement> listOfImages ;
	
	
	public void clickOnSearchIcon() {
		
		clickButton(searchIcon);
		
	}
	
	//Hide cookie text when it is displayed 
	
   public void HandleCookie() {
		
		if(cookie.isDisplayed()){
			clickButton(cookie);
			
		}
	}
	
   
   //provide email to subscribe to news 
   public void subscribeToNews(String Email) {
	   
	   setTextElemetText(email, Email);
	   clickButton(confirm);
	   clickButton(submit);
	   
   }
	
	
	//search for locations 
	public void searchforlocation(String location) {
		
		inputSearch.sendKeys(location);
		//Click on enter key 
		inputSearch.sendKeys(Keys.RETURN);
	}
	
	//Close search 
	public void exitSearch() {
		clickButton(searchIcon);
		
	}
	
	//Click on contact link in the footer 
	public void openContactPage() {
	    clickButton(contact);
	}
	
	
	//select destination from destination menu 
	public void  selectDestination() {
		
		clickButton(menu);
		clickButton(menuOfdestination);
		
	}
}
