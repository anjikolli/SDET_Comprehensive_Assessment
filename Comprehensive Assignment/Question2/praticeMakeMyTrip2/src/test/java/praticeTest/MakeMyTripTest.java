package praticeTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {

	
	 private WebDriver driver;
	    private Actions action;

	    @BeforeTest
	    public void Setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.makemytrip.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        driver.navigate().refresh();
	    }

	    @Test(priority = 0)
	    public void Popups() throws Exception {
	        driver.switchTo().frame("notification-frame-~5584c898");
	        System.out.println("Frame Switched Successfully");
	        WebElement popup = driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div"));
	        if (popup.isDisplayed()) {
	            popup.click();
	            this.HighlightMethod(popup);
	            System.out.println("Popup Clicked SuccessFully");
	            driver.switchTo().defaultContent();

	            Set<String> totalWindows = driver.getWindowHandles();
	            System.out.println(totalWindows.size());
	            for (String windows : totalWindows) {
	                driver.switchTo().window(windows);
	                String ActualTittle = driver.getTitle();
	                if (ActualTittle.equalsIgnoreCase("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday")) {
	                    System.out.println("Page Tittle Matched");
	                } else {
	                    System.out.println("Driver reference currently matched");
	                }
	            }

	            System.out.println("Popup Handled SuccessFully");
	        } else {
	            System.out.println("popup not Displayed");
	        }
	    }


	    public void validateOneWayRadioButton() {
	        WebElement onewayRadioButton = driver.findElement(By.xpath("//ul[@class='fswTabs latoRegular darkGreyText ']/li[@data-cy='oneWayTrip']"));
	        String status = onewayRadioButton.getAttribute("class");
	        if (status.equalsIgnoreCase("selected")) {
	            System.out.println("OneWay radio Button Selected  By Default");
	        } else {
	            System.out.println("Oneway radio Button not Selected");
	        }

	    }

	    @Test
	    public void enterDetails() throws Exception {
	        this.validateOneWayRadioButton();
	        WebElement fromPlace = driver.findElement(By.id("fromCity"));
	        String origin = "HYD";
	        fromPlace.sendKeys(origin);
	        Thread.sleep(3000);
	        action = new Actions(driver);
	        WebElement firstElement = driver.findElement(By.xpath("(//ul[@class='react-autosuggest__suggestions-list']/li)[1]"));
	        String ActualTextOrigin = firstElement.getText();
	        System.out.println(ActualTextOrigin);
	        action.moveToElement(firstElement).perform();
	        this.HighlightMethod(firstElement);
	        firstElement.click();
	        System.out.println("Origin  selected  Successfully");
	        Assert.assertEquals(ActualTextOrigin.contains(origin), true);
	        WebElement departure = driver.findElement(By.id("toCity"));
	        String departurePlace = "MAA";
	        departure.sendKeys("MAA");
	        Thread.sleep(3000);
	        System.out.println("Entered departure Place");
	        WebElement departureFirst = driver.findElement(By.xpath("(//p[@class='font14 appendBottom5 blackText'])[1]"));
	        action.moveToElement(departureFirst).perform();
	        this.HighlightMethod(departureFirst);
	        action.click().perform();
	        System.out.println("SuccessFully enter the departure");
	        String today = "26";
	        WebElement StartDate = driver.findElement(By.xpath("(//div[@class='dateInnerCell']/p[text()='" + today + "']/parent::div)[1]"));
	        System.out.println(StartDate.getText());
	        this.HighlightMethod(StartDate);
	        StartDate.click();
	        System.out.println("Starting date Selected Successfully");
	        Thread.sleep(3000);
	        WebElement returnDate = driver.findElement(By.xpath("//span[@class='lbl_input appendBottom10'][text()='Return']"));
	        returnDate.click();
	        String ReturnDate = "30";
	        WebElement returnDateSelector = driver.findElement(By.xpath("//div[@class='DayPicker-Day']/div/p[text()='" + ReturnDate + "']"));
	        System.out.println(returnDateSelector.getText());
	        this.HighlightMethod(returnDateSelector);
	        returnDateSelector.click();
	        System.out.println("ReturnDate Selected Successfully");
	        WebElement SearchFlights = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn '] [text()='Search']"));
	        this.HighlightMethod(SearchFlights);
	        SearchFlights.click();
	        Thread.sleep(10000);
	        this.payLaterPopup();
	        String bookingTitle = driver.getTitle();
	        Assert.assertEquals(bookingTitle, "MakeMyTrip");

	        Thread.sleep(10000);
	    }


	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	        System.out.println("Browser Closed Successfully");

	    }

	    public void HighlightMethod(WebElement element) throws Exception {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
	        System.out.println("highlighted element");
	    }

	    public void payLaterPopup() {
	        WebElement discountAndPayLater = driver.findElement(By.xpath("//p[text()='Now Lock Prices & Pay Later!\t']"));
	        if (discountAndPayLater.isDisplayed()) {
	            System.out.println("Popup displayed With This Name::Now Lock Prices & Pay Later!");
	            WebElement DAPLClose = driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon'] "));
	            DAPLClose.click();
	            System.out.println("Popup Clicked and Closed");

	        } else {
	            System.out.println("Popup Not DisPlayed ");
	        }
	    }


	//p[text()='Now Lock Prices & Pay Later!	']
	}





	
		
		


