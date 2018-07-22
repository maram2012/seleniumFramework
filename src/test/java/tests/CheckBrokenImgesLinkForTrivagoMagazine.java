/*
 * The aim of this TC is to check all links of the images 
 * on the page and make sure there is no broken links   
 */


package tests;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UrlsPage;

public class CheckBrokenImgesLinkForTrivagoMagazine extends TestBase {

	UrlsPage urlObject;
	HomePage homeObject ;

	@Test
	public void TestAllBokrenImgs() throws ClientProtocolException, IOException {
		homeObject = new HomePage(driver);
		urlObject = new UrlsPage(driver);

		//check number of images in the page 
		System.out.println("number of imgs " + homeObject.listOfImages.size());
		for(int i =0; i<homeObject.listOfImages.size();i++) {

			WebElement element = homeObject.listOfImages.get(i);
			String img = element.getAttribute("src");
			
			//System.out.println(img);
			
			urlObject.VerifyLinkisNotBroken(img);
			
			
			//Check the flag  if != 0 there is a broken img 
			assertEquals(urlObject.brokenLinksCounter, 0);

			//reset the counter after tC  
			urlObject.brokenLinksCounter = 0;
		}

	}

}
