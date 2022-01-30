package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

public class TakeScreenshots {
	private WebDriver screenshotDriver=null;
	public TakeScreenshots(WebDriver screenshotDriver) {
		
		this.screenshotDriver = screenshotDriver;
	}

	public void takescreenshot(String FileName ) throws IOException {
		TakesScreenshot tscreen=((TakesScreenshot)screenshotDriver);
		
		
     File srcfile=   tscreen.getScreenshotAs(OutputType.FILE);

FileUtils.copyFile(srcfile,
           new File("D:\\Files and folders\\MyFiles\\Eclipse workspace\\com\\src\\test\\resources\\Screenshots\\"
                    + FileName + ".jpeg"));
}

	
	
	
	public void markElement(WebElement elementToBeClicked) {
		//This is to highlight the webelement on webpage
		JavascriptExecutor js= (JavascriptExecutor)screenshotDriver;
		js.executeScript("arguments[0].style.border = '3px solid red'",elementToBeClicked);
	}

}
