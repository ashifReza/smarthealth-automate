package page.classes;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	
	private AndroidDriver driver;

    // Locators for login page
    private By usernameField = By.id("org.smartregister.unicef.mis:id/login_user_name_edit_text");
    private By passwordField = By.id("org.smartregister.unicef.mis:id/login_password_edit_text");
    private By loginButton = By.id("org.smartregister.unicef.mis:id/login_login_btn");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Login action
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}


