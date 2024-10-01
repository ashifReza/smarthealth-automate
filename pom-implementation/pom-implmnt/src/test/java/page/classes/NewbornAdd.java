package page.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class NewbornAdd extends AppTest {
	
	// Locators for New Born page elements
    private By recyclerView = By.id("org.smartregister.unicef.mis:id/recycler_view");
    private By addChildButton = By.id("org.smartregister.unicef.mis:id/add_child_btn");
    private By idLessButton = By.id("org.smartregister.unicef.mis:id/id_less_btn");
    private By firstNameField = By.xpath("//android.widget.EditText[@text='নামের প্রথম অংশ (ইংরেজীতে) *']");
    private By parentPhoneField = By.xpath("//android.widget.EditText[@text='মা/বাবা/অভিভাবক এর মোবাইল নং *']");
    private By mothersNameField = By.xpath("//android.widget.EditText[@text='মাতার নাম (ইংরেজীতে) *']");
    private By dobField = By.xpath("//android.widget.EditText[@text='জন্ম তারিখ *']");
    private By hhLeaderRelation = By.xpath("//android.widget.TextView[@text='খানা প্রধানের সাথে সম্পর্ক *']");
    private By genderField = By.xpath("//android.widget.TextView[@text='লিঙ্গ *']");
    private By submitButton = By.id("org.smartregister.unicef.mis:id/next");
    private By monthButton = By.className("android.widget.Button");
    private By okButton = By.id("org.smartregister.unicef.mis:id/ok_button");
    private By followUpTab = By.xpath("//android.widget.TextView[@text='ফলোআপ']");



//Constructor to initialize the driver
public NewbornAdd(AndroidDriver driver) {
    this.driver = driver;
}

// Method to select an item from the RecyclerView
public void selectListItem(int index) {
    WebElement recyclerViewElement = driver.findElement(recyclerView);
    List<WebElement> listItems = recyclerViewElement.findElements(By.className("android.widget.RelativeLayout"));
    listItems.get(index).click();
}

// Method to fill out the new child form
public void addNewChild(String firstName, String phone, String motherName) {
    driver.findElement(addChildButton).click();
    driver.findElement(idLessButton).click();
    driver.findElement(firstNameField).sendKeys(firstName);
    driver.findElement(parentPhoneField).sendKeys(phone);
    driver.findElement(mothersNameField).sendKeys(motherName);
}

// Method to click DOB field
public void clickDOB() {
    driver.findElement(dobField).click();
    List<WebElement> buttons = driver.findElements(monthButton);
    buttons.get(1).click();  // Click month
    buttons.get(1).click();
    for(int i=0;i<11; i++) {
    	buttons.get(3).click();
    }
    driver.findElement(okButton).click();  // Confirm date selection
    scrollToText("জমা দিন");
}

// Method to select household leader relation and gender
public void selectRelationAndGender(int relationIndex, int genderIndex) {
    driver.findElement(hhLeaderRelation).click();
    selectDropdownItemByIndex(relationIndex);
    driver.findElement(genderField).click();
    selectDropdownItemByIndex(genderIndex);
}

// Method to scroll and submit the form
public void SubmitForm() {
    driver.findElement(submitButton).click();
    driver.findElement(followUpTab).click();
}

// Reusable method to select from dropdown by index
public void selectDropdownItemByIndex(int index) {
    WebElement listView = driver.findElement(By.className("android.widget.ListView"));
    List<WebElement> listItems = listView.findElements(By.className("android.widget.TextView"));
    if (index < listItems.size()) {
        listItems.get(index).click();
    }
 }
}