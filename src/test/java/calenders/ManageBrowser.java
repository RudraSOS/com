package calenders;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utilities.TakeScreenshots;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageBrowser {
	
	private static WebDriver driver;//private instance variable
	
	



@Before//This below method setupBrowser executes before each Test
	public  void setupBrowser() {
	WebDriverManager.chromiumdriver().setup();
	//introducing way to handle web notification
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("profile.default_content_setting_values.notifications", 2);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", prefs);
	//
	
	
	ManageBrowser.driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://www.easemytrip.com/");
	}

@After//This below method quitBrowser executes after each Test case
public  void quitBrowser() {
driver.quit();
}

@Test//This below method is treated as test case.this we used page object model passing driver instance to easymytrip class constructor
public void clickCalennder() throws Exception {
	Easymytrip mytrip=new Easymytrip(driver);
	mytrip.clickCalender();
	mytrip.selectYear(2023);
	mytrip.selectMonth("MAR");
	mytrip.selectDate("10");
	WebElement ele = driver.findElement(By.xpath("//*[@class='search_bg']//input[@placeholder='Departure']"));
	TakeScreenshots tk=new TakeScreenshots(driver);
	tk.markElement(ele);
	tk.takescreenshot("Departure date");
}
}
//eclipse run this class as it finds @test annotation here only