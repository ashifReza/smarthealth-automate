package test.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.SkipException;
import org.testng.annotations.Test;

import page.classes.AppTest;
import page.classes.ECCDPage;
//import page.classes.LoginPage;
import page.classes.NewbornAdd;
import page.classes.PNCPage;


public class NewbornAddTest extends AppTest {
	
	@Test
    public void testMemberAdd() throws InterruptedException {
        // Initialize page objects
		//LoginPage loginPage = new LoginPage(driver);
        NewbornAdd newBornPage = new NewbornAdd(driver);
        
	    // Log in
	    //loginPage.login("dnccw06team4", "123456");

        // Perform the actions
        newBornPage.selectListItem(1);  // Select the second item in the RecyclerView
        newBornPage.addNewChild("Rogers", "01249875654", "Mina");  // Fill in details
        newBornPage.clickDOB();  // Click on DOB field
        

        // Select HH leader relation and gender, then scroll and submit
        newBornPage.selectRelationAndGender(2, 2);
        newBornPage.SubmitForm();  // Submit the form 
    }
	
	@Test (dependsOnMethods = "testMemberAdd")
    public void testPNCAdd() throws InterruptedException {
		
		// Check if the specific element exists in the DOM
	    boolean isElementPresent = false;
	    try {
	        // Try to find the element using XPath
	        driver.findElement(By.xpath("//android.widget.TextView[@text='নবজাতক পি এন সি - ১ম']"));
	        isElementPresent = true;
	    } catch (NoSuchElementException e) {
	        // Element not found, so we will skip the test
	        isElementPresent = false;
	    }

	    // Skip the test if the element is not present
	    if (!isElementPresent) {
	        throw new SkipException("Skipping testPNCAdd since the element is not found");
	    }

		
        // Initialize the PNCPage
        PNCPage pncPage = new PNCPage(driver);

        // Navigate to PNC Form
        pncPage.navigateToPNCForm();

        // Fill in PNC Form details
        pncPage.fillPNCForm("500", "500");

        // Select check-boxes for PNC actions
        pncPage.selectCheckBoxes(2, 3, 4, 5);

        // Scroll and select danger signs
        pncPage.scrollToSubmitAndSelectDangerSigns(3, 4, 5);

        // Agree to go to the hospital
        pncPage.agreeToHospital();

        // Submit the form
        pncPage.submitPNCForm();
    }
	
	@Test (dependsOnMethods = "testPNCAdd", alwaysRun = true)
    public void testECCDAdd() throws InterruptedException {
        // Initialize ECCDPage object
        ECCDPage eccdPage = new ECCDPage(driver);

        // Navigate to ECCD form
        eccdPage.navigateToECCDForm();

        // Answer the ECCD form questions
        eccdPage.answerQuestion(0, "না");
        eccdPage.answerQuestion(1, "না");
        eccdPage.answerQuestion(2, "না");
        eccdPage.answerQuestion(3, "হ্যাঁ");
        eccdPage.answerQuestion(4, "হ্যাঁ");
        eccdPage.answerQuestion(5, "হ্যাঁ");

        // Scroll to the submit button
        eccdPage.scrollToSubmit();

        // Select referrer
        eccdPage.selectReferrer(1);

        // Submit the form and confirm
        eccdPage.submitForm();
    }
}
