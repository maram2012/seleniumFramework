package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

public class UrlsPage extends PageBase {

	public UrlsPage(WebDriver driver) {
		super(driver);
	}
    //flag to check if there is a broken link 
	public int brokenLinksCounter =0;
    
	public void VerifyLinkisNotBroken(String UrlLink) throws MalformedURLException {
		URL link = new URL(UrlLink);
	//create collection using URL object 
		HttpURLConnection httpconnection;
		try {
			//Send HTTP request for the link and read HTTP response code
			httpconnection = (HttpURLConnection) link.openConnection();
			httpconnection.setConnectTimeout(4000);
			httpconnection.connect();
			// Find out whether the link is valid or broken based on HTTP response code
			if(httpconnection.getResponseCode() >= 400) {
				System.out.println(link +" is a broken link");
				brokenLinksCounter ++;
			}

		} catch (IOException e) {
			System.out.println(" connection error " + e);
		}
     
	}
	
	   
}
