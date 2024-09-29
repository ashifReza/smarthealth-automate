package smarthealth.appAutomate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class NewBornActions extends AppTest {
	
	@Test
	public void memberAdd() {
		
		//loginToApp();
		
		// Locate the RecyclerView
		WebElement recyclerView = driver.findElement(By.id("org.smartregister.unicef.mis:id/recycler_view"));

		// Get all the items (RelativeLayouts) inside the RecyclerView
		List<WebElement> listViews2 = recyclerView.findElements(By.className("android.widget.RelativeLayout"));
		listViews2.get(1).click();
		
		//Fill out form
		//Click on Child Button
		driver.findElement(By.id("org.smartregister.unicef.mis:id/add_child_btn")).click();
		//Click on NoIDAvailable
		driver.findElement(By.id("org.smartregister.unicef.mis:id/id_less_btn")).click();
		
		//First Name
		driver.findElement(By.xpath("//android.widget.EditText[@text='নামের প্রথম অংশ (ইংরেজীতে) *']")).sendKeys("Daniel");
		
		//Parent Phone No
		driver.findElement(By.xpath("//android.widget.EditText[@text='মা/বাবা/অভিভাবক এর মোবাইল নং *']")).sendKeys("01359875654");
		
		//Mothers Name
		driver.findElement(By.xpath("//android.widget.EditText[@text='মাতার নাম (ইংরেজীতে) *']")).sendKeys("Mary");
		
		//DOB
		driver.findElement(By.xpath("//android.widget.EditText[@text='জন্ম তারিখ *']")).click();
		
		//Click on Month
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		driver.findElement(By.id("org.smartregister.unicef.mis:id/ok_button")).click();
		
		//Scroll to submit
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"জমা দিন\"));"));
		
		//HH Leader Relation
        driver.findElement(By.xpath("//android.widget.TextView[@text='খানা প্রধানের সাথে সম্পর্ক *']")).click();
        selectDropdownItemByIndex(2);
        
        //Select Gender
        driver.findElement(By.xpath("//android.widget.TextView[@text='লিঙ্গ *']")).click();
        selectDropdownItemByIndex(2);
        
       //submit Button
       driver.findElement(By.id("org.smartregister.unicef.mis:id/next")).click();
        
		
	}
	
	@Test(dependsOnMethods = "memberAdd")
	public void PNCAdd() {
		
		//Click on Follow up tab
		driver.findElement(By.xpath("//android.widget.TextView[@text='ফলোআপ']")).click();
		
		//Click on PNC option
		driver.findElement(By.xpath("//android.widget.TextView[@text='নবজাতক পি এন সি - ১ম']")).click();
		
		//PNC form Input
		//Birth Weight
		driver.findElement(By.xpath("//android.widget.EditText[@text='জন্ম ওজন (গ্রাম) *']")).sendKeys("500");
		
		//Current Weight
		driver.findElement(By.xpath("//android.widget.EditText[@text='বর্তমান ওজন (গ্রাম) *']")).sendKeys("500");
		
		//Scroll to element
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"বিলম্বিত নাড়ি কাটা (১ থেকে ৩ মিনিটের মধ্যে)\"));"));
		
        //data
        driver.findElements(By.className("android.widget.CheckBox")).get(2).click();
	    driver.findElements(By.className("android.widget.CheckBox")).get(3).click();
	    driver.findElements(By.className("android.widget.CheckBox")).get(4).click();
	    driver.findElements(By.className("android.widget.CheckBox")).get(5).click();
	    
	    //Scroll to Submit
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"জমা দিন\"));"));
	    
	   //danger sign
       driver.findElements(By.className("android.widget.CheckBox")).get(3).click();
	   driver.findElements(By.className("android.widget.CheckBox")).get(4).click();
	   driver.findElements(By.className("android.widget.CheckBox")).get(5).click();
	   
	   //agree to go to hospital
	   driver.findElement(By.id("android:id/text1")).click();
	   driver.findElement(By.xpath("//android.widget.TextView[@text='হ্যাঁ']")).click();
	   
	   //submit Button
       driver.findElement(By.id("org.smartregister.unicef.mis:id/next")).click();
       
       //Accept
	   driver.findElement(By.xpath("//android.widget.Button[@text='ঠিক আছে']")).click();
	}
	
	@Test(dependsOnMethods = "PNCAdd")
	public void ECCDAdd() throws InterruptedException {
		
		Thread.sleep(3000);
		
		//Click on Follow up tab
		driver.findElement(By.xpath("//android.widget.TextView[@text='ফলোআপ']")).click();
		
		//Click on ECCD
		driver.findElement(By.xpath("//android.widget.TextView[@text='২-৩ মাসের শিশুর বিলম্বিত বিকাশ সনাক্তকরন ফলোআপ']")).click();
		
		//click on 1st question
		driver.findElements(By.className("android.widget.Spinner")).get(0).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='না']")).click();
		
		//click on 2nd question
		driver.findElements(By.className("android.widget.Spinner")).get(1).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='না']")).click();
		
		//click on 3rd question
		driver.findElements(By.className("android.widget.Spinner")).get(2).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='না']")).click();
		
		//click on 4th question
		driver.findElements(By.className("android.widget.Spinner")).get(3).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='হ্যাঁ']")).click();
		
		//click on 5th question
		driver.findElements(By.className("android.widget.Spinner")).get(4).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='হ্যাঁ']")).click();
		
		//click on 6th question
		driver.findElements(By.className("android.widget.Spinner")).get(5).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='হ্যাঁ']")).click();
				
		//Scroll to Submit
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"জমা দিন\"));"));
	    
	    //referrer
	    driver.findElement(By.xpath("//android.widget.TextView[@text='রেফারের স্থান *']")).click();
	    selectDropdownItemByIndex(2);
	    
	    //submit Button
	    driver.findElement(By.id("org.smartregister.unicef.mis:id/next")).click();
	    
	    //Accept
	    driver.findElement(By.xpath("//android.widget.Button[@text='ঠিক আছে']")).click();
		
	}
	
	
	

	
}
