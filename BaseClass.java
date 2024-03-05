package commonUtils;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public WebDriver d;
	
	webDriverUtills wutil = new webDriverUtills();
    PropertyFileUtil putil = new PropertyFileUtil();
   
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("Connect to Data Base");
	}
	
	@BeforeClass
	public void BC() throws IOException
	{
		
		    // BeforeClass is used to launch the application  
		
		
		     String URL = putil.getDataFromPropertyFile("Url");
		      //To launch the empty browser
			  WebDriver d = new ChromeDriver();
				
				//To maximize the browser
				wutil.maximize(d);
				wutil.implicitwait(d);
				
				
				
				//To launch application
		        d.get(URL);
	}
	
	@BeforeMethod
	public void BM() throws IOException
	{
		// Beforemethod annotation is used to login to the application
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");
		
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("DisConnect from the  Data Base");
	}
	@AfterClass
	public void AC()
	{
		// afterClass is used to close the Browser
		d.quit();
		
	}
	
	@AfterMethod
	public void AM() throws InterruptedException
	{
		//afterMethod annotation is used to signOut from the applicatation
		Thread.sleep(2000);
		//mousehover on image
				WebElement img = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wutil.mousehover(d, img);
				
				Thread.sleep(2000);
				
				//click on sign out
				d.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	

}
