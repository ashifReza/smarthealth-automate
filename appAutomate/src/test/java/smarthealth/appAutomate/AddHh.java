package smarthealth.appAutomate;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AddHh extends AppTest {

	@Test
	public void HouseHoldCreate() throws InterruptedException {
		
		loginToApp();
		
		// Example usage of explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='নাম : Mcdonald ']")));
		
//		//Wait for sync to finish
//		Thread.sleep(10000);
		
		//Click on "খানা নিবন্ধন"
		driver.findElement(By.id("org.smartregister.unicef.mis:id/action_register")).click();
		
		//Fill up HH form

		//union
		driver.findElement(By.xpath("//android.widget.TextView[@text='ইউনিয়ন/ জোন *']")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='ZONE-02']")).click();
		selectDropdownItemByIndex(1);
		//old ward
		driver.findElement(By.xpath("//android.widget.TextView[@text='পুরাতন ওয়ার্ড *']")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='NO OLD WARD']")).click();
		selectDropdownItemByIndex(1);
		//new ward
		driver.findElement(By.xpath("//android.widget.TextView[@text='নতুন ওয়ার্ড *']")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='DNCC:WARD 06']")).click();
		selectDropdownItemByIndex(1);
		//sub-block site
		driver.findElement(By.xpath("//android.widget.TextView[@text='সাব-ব্লক/ সাইট *']")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='সাব-ব্লক/ সাইট *']")).click();
		selectDropdownItemByIndex(4);

        
        //Scroll to "স্থায়ী ঠিকানা কি একই"
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"স্থায়ী ঠিকানা কি একই *\"));"));
        
        //Choose if permanent address is same or not
        driver.findElement(By.xpath("//android.widget.TextView[@text='স্থায়ী ঠিকানা কি একই *']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='হ্যাঁ']")).click();
        
        //HH head name
        driver.findElement(By.xpath("//android.widget.EditText[@text='পরিবারের প্রধানের নাম এর প্রথম অংশ (ইংরেজীতে) *']")).sendKeys("Howard");
        
        //Mobile Number
        driver.findElement(By.xpath("//android.widget.EditText[@text='পরিবারের গুরুত্বপূর্ণ মোবাইল নাম্বার *']")).sendKeys("01634563742");
        
        //Family member count
        driver.findElement(By.xpath("//android.widget.EditText[@text='খানার মোট সদস্য সংখ্যা *']")).sendKeys("5");
        
        //Scroll to submit
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"জমা দিন\"));"));
        
        //submit Button
        driver.findElement(By.id("org.smartregister.unicef.mis:id/next")).click();
        
        //Wait for sync to finish
        Thread.sleep(15000);
        
        //Click on side menu
        driver.findElement(AppiumBy.accessibilityId("Open")).click();
        
        //Sync
        driver.findElement(By.id("org.smartregister.unicef.mis:id/rlIconSync")).click();
        
        //Wait for sync to finish
        Thread.sleep(15000);
       
	}

}
