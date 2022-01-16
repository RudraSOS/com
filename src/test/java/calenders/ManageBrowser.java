package calenders;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageBrowser {
	
	private static WebDriver driver;//private instance variable
	
	



@Before//This below method setupBrowser executes before each Test
	public  void setupBrowser() {
	WebDriverManager.chromiumdriver().setup();
	ManageBrowser.driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.easemytrip.com/");
	}

@After//This below method quitBrowser executes after each Test case
public  void quitBrowser() {
//driver.quit();
}

@Test//This below method is treated as test case.this we used page object model passing driver instance to easymytrip class constructor
public void clickCalennder() throws Exception {
	Easymytrip mytrip=new Easymytrip(driver);
	mytrip.clickCalender();
	mytrip.selectYear(2024);
	mytrip.selectMonth("MAR");
	mytrip.selectDate("1");
}
}
//eclipse run this class as it finds @test annotation here only