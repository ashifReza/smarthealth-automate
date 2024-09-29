package test.classes;

import page.classes.AppTest;
import page.classes.HouseholdPage;
//import page.classes.LoginPage;

import org.testng.annotations.Test;

public class AddHhTest extends AppTest {

    @Test
    public void testHouseholdCreation() throws InterruptedException {
        //LoginPage loginPage = new LoginPage(driver);
        HouseholdPage householdPage = new HouseholdPage(driver);
        
        // Log in
        //loginPage.login("dnccw06team4", "123456");

        // Household creation steps
        householdPage.openRegistration();
        householdPage.fillHouseholdDetails();
        householdPage.enterHouseholdHeadDetails("Jimmy", "01934563742", "6");
        householdPage.submitForm();
        
        // Sync
        householdPage.syncData();
    }
}
