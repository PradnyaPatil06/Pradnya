package commonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class webDriverUtills {

	
	public void maximize(WebDriver d) {
		d.manage().window().maximize();
	}
	
   public void implicitwait(WebDriver d) {
	   d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }
   
   public void handledropdown(WebElement element , String targetedelement) {
	   Select s = new Select(element);
	   s.selectByVisibleText(targetedelement);
   }
   
   public void mousehover(WebDriver d , WebElement ele)
   {
	   Actions a = new Actions(d);
	   a.moveToElement(ele);
	   a.perform();
   }
   
   
   public void switchWindow(WebDriver d, String expectedurl)
   {
	   Set<String> ids = d.getWindowHandles();
	   
	   for(String e: ids)
	   {
		  String actualurl = d.switchTo().window(e).getCurrentUrl();
		  
		  
		   
		   if(actualurl.contains(expectedurl)) 
		   {
			   break;
		   }
	   }
	   
   }
   
   
   public File screenShort(WebDriver d, String ScreenshotName) throws IOException 
   {
	   TakesScreenshot ts = (TakesScreenshot)d;
	   File tempFile = ts.getScreenshotAs(OutputType.FILE);
	   File destinationFile = new File("./ScreenShot/"+ScreenshotName+".png");
	   FileUtils.copyFile(tempFile, destinationFile);
	   return destinationFile;
	   
	   
   }
}





