package calenders;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*page construtor which takes webdriver refrence
 * locators for element of page 
 * page methods 
 * page is ready
 */

public class Easymytrip {//Page object Model example
	
	private static WebDriver calenderdriver;//webdriver refrence of this page.it gets value of reference from ManageBrowser class
	By calenderYearWithmonth=By.xpath("//div[@class='box']//div[@class='month2']");
	By calendericon=By.xpath("//div[@id='dvfarecal']/input[@placeholder='Departure']");//locator for page object model
	By nextIcon=By.xpath("//div[@class='month3']/img");
	//By calenderDay=By.xpath("//div[@class='box']//div[@class='days']//li[text()="+day+"]");
	public Easymytrip(WebDriver driver) {//constructor in page objectmodel
		calenderdriver=driver;//note
	}
	
	
	public void clickCalender() throws Exception {
		
	calenderdriver.findElement(calendericon).click();
		Thread.sleep(3000);
	}
	
	public void selectYear(int year) throws Exception {//loop until particular year is displayed-Sequennce of date selection-1st sequence
		
		String monthyear=calenderdriver.findElement(calenderYearWithmonth).getText();
		String arr[]=monthyear.split(" ",2);//split into 2 parts using space
		int years= Integer.parseInt(arr[1]);
			while(!(years==year)) {
				Thread .sleep(2000);
			calenderdriver.findElement(nextIcon).click();	
			 monthyear=calenderdriver.findElement(calenderYearWithmonth).getText();
				years=Integer.parseInt(monthyear.substring(4));//updates value of years
				
			}
			
			
		
			
		
		
/*The string split() method breaks a given string around matches of the given regular expression. After splitting against the given regular expression, this method returns a char array.
 
Example:  

Input String: 016-78967
Regular Expression: - 
Output : {"016", "78967"}*/
	}
	
	public void selectMonth(String mon)	{
		String month=calenderdriver.findElement(calenderYearWithmonth).getText().substring(0,3);
		while(!(mon.equalsIgnoreCase(month))) {
			calenderdriver.findElement(nextIcon).click();
			month=calenderdriver.findElement(calenderYearWithmonth).getText().substring(0,3);
		}
	}
//calender is like a table only
	public void selectDate(String day) {
		
		calenderdriver.findElement(By.xpath("//div[@class='box']//div[@class='days']//li[text()="+day+"]")).click();
		
	}
}
