package page.classes;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HouseholdPage extends AppTest {
    //private AndroidDriver driver;

    // Locators for household page
    private By registerButton = By.id("org.smartregister.unicef.mis:id/action_register");
    private By unionDropdown = By.xpath("//android.widget.TextView[@text='ইউনিয়ন/ জোন *']");
    private By oldWardDropdown = By.xpath("//android.widget.TextView[@text='পুরাতন ওয়ার্ড *']");
    private By newWardDropdown = By.xpath("//android.widget.TextView[@text='নতুন ওয়ার্ড *']");
    private By subBlockDropdown = By.xpath("//android.widget.TextView[@text='সাব-ব্লক/ সাইট *']");
    private By permanentAddressSame = By.xpath("//android.widget.TextView[@text='স্থায়ী ঠিকানা কি একই *']");
    private By permanentAddressYes = By.xpath("//android.widget.TextView[@text='হ্যাঁ']");
    private By householdHeadName = By.xpath("//android.widget.EditText[@text='পরিবারের প্রধানের নাম এর প্রথম অংশ (ইংরেজীতে) *']");
    private By mobileNumber = By.xpath("//android.widget.EditText[@text='পরিবারের গুরুত্বপূর্ণ মোবাইল নাম্বার *']");
    private By familyMembersCount = By.xpath("//android.widget.EditText[@text='খানার মোট সদস্য সংখ্যা *']");
    private By submitButton = By.id("org.smartregister.unicef.mis:id/next");
    private By sideMenuButton = AppiumBy.accessibilityId("Open");
    private By syncButton = By.id("org.smartregister.unicef.mis:id/rlIconSync");

    public HouseholdPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void openRegistration() {
        driver.findElement(registerButton).click();
    }

    public void fillHouseholdDetails() {
        // Union
        driver.findElement(unionDropdown).click();
        selectDropdownItemByIndex(1);

        // Old ward
        driver.findElement(oldWardDropdown).click();
        selectDropdownItemByIndex(1);

        // New ward
        driver.findElement(newWardDropdown).click();
        selectDropdownItemByIndex(1);

        // Sub-block
        driver.findElement(subBlockDropdown).click();
        selectDropdownItemByIndex(4);

        // Scroll and select permanent address as same
        scrollToText("স্থায়ী ঠিকানা কি একই *");
        driver.findElement(permanentAddressSame).click();
        driver.findElement(permanentAddressYes).click();
    }

    public void enterHouseholdHeadDetails(String headName, String mobile, String members) {
        driver.findElement(householdHeadName).sendKeys(headName);
        driver.findElement(mobileNumber).sendKeys(mobile);
        driver.findElement(familyMembersCount).sendKeys(members);
    }

    public void submitForm() {
        scrollToText("জমা দিন");
        driver.findElement(submitButton).click();
    }

    public void syncData() throws InterruptedException {
        Thread.sleep(15000); // Wait for sync to finish
        driver.findElement(sideMenuButton).click();
        driver.findElement(syncButton).click();
        Thread.sleep(15000); // Wait for sync to finish
    }
}
