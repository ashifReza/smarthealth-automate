package page.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PNCPage extends AppTest {
	
	// Locators for PNC form elements
    private By followUpTab = By.xpath("//android.widget.TextView[@text='ফলোআপ']");
    private By pncOption = By.xpath("//android.widget.TextView[@text='নবজাতক পি এন সি - ১ম']");
    private By birthWeightField = By.xpath("//android.widget.EditText[@text='জন্ম ওজন (গ্রাম) *']");
    private By currentWeightField = By.xpath("//android.widget.EditText[@text='বর্তমান ওজন (গ্রাম) *']");
    private By checkBoxes = By.className("android.widget.CheckBox");
    private By goToHospitalDropDown = By.id("android:id/text1");
    private By agreeHospitalOption = By.xpath("//android.widget.TextView[@text='হ্যাঁ']");
    private By submitButton = By.id("org.smartregister.unicef.mis:id/next");
    private By acceptButton = By.xpath("//android.widget.Button[@text='ঠিক আছে']");

    // Constructor to initialize the driver
    public PNCPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to PNC form
    public void navigateToPNCForm() {
        driver.findElement(followUpTab).click();
        driver.findElement(pncOption).click();
    }

    // Method to fill out PNC form fields
    public void fillPNCForm(String birthWeight, String currentWeight) {
        driver.findElement(birthWeightField).sendKeys(birthWeight);
        driver.findElement(currentWeightField).sendKeys(currentWeight);

        // Scroll to "বিলম্বিত নাড়ি কাটা" field
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"বিলম্বিত নাড়ি কাটা (১ থেকে ৩ মিনিটের মধ্যে)\"));"));
    }

    // Method to select check-boxes
    public void selectCheckBoxes(int... indices) {
        List<WebElement> allCheckBoxes = driver.findElements(checkBoxes);
        for (int index : indices) {
            allCheckBoxes.get(index).click();
        }
    }

    // Method to scroll to submit and select danger signs
    public void scrollToSubmitAndSelectDangerSigns(int... dangerIndices) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"জমা দিন\"));"));

        // Select danger signs
        selectCheckBoxes(dangerIndices);
    }

    // Method to select "agree to go to hospital"
    public void agreeToHospital() {
        driver.findElement(goToHospitalDropDown).click();
        driver.findElement(agreeHospitalOption).click();
        scrollToText("জমা দিন");
    }

    // Method to submit the form
    public void submitPNCForm() {
        driver.findElement(submitButton).click();
        driver.findElement(acceptButton).click();
    }

}
