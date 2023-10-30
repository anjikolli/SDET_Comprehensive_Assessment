package stepdefination;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeMyTripSteffdef {

WebDriver driver;
	
	@Given("I am on the MakeMyTrip website")
	public void i_am_on_the_MakeMyTrip_website() throws InterruptedException 
	{
	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win32\\chromedriver.exe");	

        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().refresh();
	}
	
	
	@Then("I Handle the Frames and Popups")
	public void i_Handle_the_Frames_and_Popups() 
	{
		 driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
	        System.out.println("Frame Switched Successfully");
	        WebElement popup = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
	        if (popup.isDisplayed()) 
	        {
	            popup.click();
	            
	            System.out.println("Popup Clicked SuccessFully");
	            driver.switchTo().defaultContent();

	            Set<String> totalWindows = driver.getWindowHandles();
	            System.out.println(totalWindows.size());
	            for (String windows : totalWindows) 
	            {
	                driver.switchTo().window(windows);
	                String ActualTittle = driver.getTitle();
	                if (ActualTittle.equalsIgnoreCase("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday")) 
	                {
	                    System.out.println("Page Tittle Matched");
	                } 
	                else 
	                {
	                    System.out.println("Driver reference currently matched");
	                }
	            }

	            System.out.println("Popup Handled SuccessFully");
	        }
	        else 
	        {
	            System.out.println("popup not Displayed");
	        }
	    }
	


	@When("I select one-way trip")
	public void i_select_one_way_trip() throws Exception
	{
		 
		 WebElement roundTrip = driver.findElement(By.xpath("//ul[@class='fswTabs latoRegular darkGreyText ']/li[@data-cy='oneWayTrip']"));
		 roundTrip.click();
	        String status = roundTrip.getAttribute("class");
	        
	        if (status.equalsIgnoreCase("selected")) 
	        {
	            System.out.println("OneWay radio Button Selected  By Default");
	        } 
	        else 
	        {
	            System.out.println("Oneway radio Button not Selected");
	        }

	    }
		      
		 

	@When("I enter {string} as the origin")
	public void i_enter_as_the_origin(String string) throws InterruptedException 
	{
		 WebElement fromPlace = driver.findElement(By.id("fromCity"));
	        String origin = "BOM";
	        fromPlace.sendKeys(origin);
	        Thread.sleep(3000);
	}

	@When("I enter {string} as the departure")
	public void i_enter_as_the_departure(String string) 
	{
		Actions action = new Actions(driver);
        WebElement firstElement = driver.findElement(By.xpath("(//ul[@class='react-autosuggest__suggestions-list']/li)[1]"));
        String ActualTextOrigin = firstElement.getText();
        System.out.println(ActualTextOrigin);
        action.moveToElement(firstElement).perform();
        firstElement.click();
        
        System.out.println("Origin  selected  Successfully");
       // Assert.assertEquals(ActualTextOrigin.contains(origin), true);
	}

	@When("I select the start date")
	public void i_select_the_start_date() throws InterruptedException 
	{
		Actions action = new Actions(driver);
		 WebElement departure = driver.findElement(By.id("toCity"));
	        String departurePlace = "HYD";
	        departure.sendKeys("HYD");
	        Thread.sleep(3000);
	        System.out.println("Entered departure Place");
	        
	        WebElement departureFirst = driver.findElement(By.xpath("(//p[@class='font14 appendBottom5 blackText'])[1]"));
	        action.moveToElement(departureFirst).perform();
	       
	        action.click().perform();
	        System.out.println("SuccessFully enter the departure");
	}

	@When("I select the return date")
	public void i_select_the_return_date() throws InterruptedException 
	{
		 String today = "26";
	        WebElement StartDate = driver.findElement(By.xpath("(//div[@class='dateInnerCell']/p[text()='" + today + "']/parent::div)[1]"));
	        System.out.println(StartDate.getText());
	     
	        StartDate.click();
	        System.out.println("Starting date Selected Successfully");
	        Thread.sleep(3000);
	        
	        
	        WebElement returnDate = driver.findElement(By.xpath("//span[@class='lbl_input appendBottom10'][text()='Return']"));
	        returnDate.click();
	        String ReturnDate = "30";
	        
	        WebElement returnDateSelector = driver.findElement(By.xpath("//div[@class='DayPicker-Day']/div/p[text()='" + ReturnDate + "']"));
	        System.out.println(returnDateSelector.getText());
	        
	        returnDateSelector.click();
	        System.out.println("ReturnDate Selected Successfully");
	}

	@When("I click the Search button")
	public void i_click_the_Search_button() throws InterruptedException 
	{
		WebElement SearchFlights = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn '] [text()='Search']"));
      
        SearchFlights.click();
        Thread.sleep(10000);
       
        String bookingTitle = driver.getTitle();


        Thread.sleep(10000);
	}

	@Then("I should see search results")
	public void i_should_see_search_results() 
	{
		 WebElement discountAndPayLater = driver.findElement(By.xpath("//p[text()='Now Lock Prices & Pay Later!\t']"));
	        if (discountAndPayLater.isDisplayed()) 
	        {
	            System.out.println("Popup displayed With This Name::Now Lock Prices & Pay Later!");
	            WebElement DAPLClose = driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon'] "));
	            DAPLClose.click();
	            System.out.println("Popup Clicked and Closed");

	        } 
	        else 
	        {
	            System.out.println("Popup Not DisPlayed ");
	        }
	}


	
	}

	

