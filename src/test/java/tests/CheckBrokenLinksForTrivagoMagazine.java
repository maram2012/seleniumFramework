 /*
 * The aim of this TC is to check all URLs 
 * on the page and make sure there is no broken links   
 */

package tests;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UrlsPage;

public class CheckBrokenLinksForTrivagoMagazine extends TestBase{

	HomePage homeObject ;
	UrlsPage urlObject;
	@Test(enabled=true) 
	public void TestAllBokrenUrls() throws MalformedURLException {
	homeObject = new HomePage(driver);
	urlObject = new UrlsPage(driver);
	System.out.println("number of links " + homeObject.UrlList.size());
	
		for(int i =0; i<homeObject.UrlList.size();i++) {
	
			WebElement element = homeObject.UrlList.get(i);
			String url = element.getAttribute("href");
			urlObject.VerifyLinkisNotBroken(url);
			//Check the flag  if = 0 there is a broken link 
			assertEquals(urlObject.brokenLinksCounter, 0);
			//reset the counter after tC  
			urlObject.brokenLinksCounter = 0;
		}
	}}
			

