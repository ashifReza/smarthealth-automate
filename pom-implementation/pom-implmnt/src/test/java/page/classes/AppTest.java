package page.classes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class AppTest 
{	
    public WebElement listView;
    public List<WebElement> listItems;
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeClass
	public void configAppium() throws MalformedURLException {
		
//		// Start Appium server
//        service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
//		
		//create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("phone2");
		options.setApp("C:\\Users\\Ashif\\eclipse-workspace\\appAutomate\\src\\test\\java\\appFolder\\opensrp-mis-unicef-19.166-debug.apk");
		
		// Keep session and avoid clearing cache
        options.setCapability(MobileCapabilityType.NO_RESET, true);  // Prevent clearing app data
        options.setCapability(MobileCapabilityType.FULL_RESET, false);  // Avoid reinstalling the app
        
		//create object for android user
		driver = new AndroidDriver(new URL("http://192.168.22.51:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	// Reusable method to select drop-down by index
    public void selectDropdownItemByIndex(int index) {
        
        // Locate the ListView element and initialize listItems
        listView = driver.findElement(By.className("android.widget.ListView"));
        listItems = listView.findElements(By.className("android.widget.TextView"));
        
        // Select the item by index, make sure the index is within bounds
        if (index < listItems.size()) {
            listItems.get(index).click();
        } else {
            System.out.println("Index out of bounds for dropdown selection");
        }
    }
    
    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }
	
	 @AfterClass
	    public void tearDown() {
	        // Close the driver and stop the Appium service
	        if (driver != null) {
	            driver.quit();
	        }
	        if (service != null) {
	            service.stop();
	        }
	        
//	        // Flush the report
//	        extent.flush();
	    }
	
	
}
