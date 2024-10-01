package page.classes;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ECCDPage extends AppTest {
	
	// Locators for ECCD form elements
    private By followUpTab = By.xpath("//android.widget.TextView[@text='ফলোআপ']");
    private By eccdOption = By.xpath("//android.widget.TextView[@text='২-৩ মাসের শিশুর বিলম্বিত বিকাশ সনাক্তকরন ফলোআপ']");
    private By submitButton = By.id("org.smartregister.unicef.mis:id/next");
    private By acceptButton = By.xpath("//android.widget.Button[@text='ঠিক আছে']");
    private By referrerDropdown = By.xpath("//android.widget.TextView[@text='রেফারের স্থান *']");
    private By dropdownOptions = By.className("android.widget.Spinner");

    // Constructor to initialize driver
    public ECCDPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to ECCD form
    public void navigateToECCDForm() {
        driver.findElement(followUpTab).click();
        driver.findElement(eccdOption).click();
    }

    // Method to answer a question by selecting an option from a dropdown
    public void answerQuestion(int questionIndex, String answer) {
        driver.findElements(dropdownOptions).get(questionIndex).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + answer + "']")).click();
    }

    // Method to scroll and submit the form
    public void scrollToSubmit() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"জমা দিন\"));"));
    }

    // Method to select referrer from dropdown
    public void selectReferrer(int index) {
        driver.findElement(referrerDropdown).click();
        selectDropdownItemByIndex(index);
    }

    // Method to click the submit button
    public void submitForm() {
        driver.findElement(submitButton).click();
        driver.findElement(acceptButton).click();
    }

    // Reusable method to select a dropdown item by index
    public void selectDropdownItemByIndex(int index) {
        driver.findElements(By.className("android.widget.TextView")).get(index).click();
    }

}
