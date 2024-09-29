package smarthealth.appAutomate;

import java.io.FileReader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import io.appium.java_client.AppiumBy;

public class TestBulk extends AppTest {
	
	@DataProvider(name = "householdData")
    public Object[][] getHouseholdData() throws Exception {
        // Reading data from CSV
        CSVReader csvReader = new CSVReader(new FileReader("path/to/households.csv"));
        List<String[]> csvData = csvReader.readAll();
        csvReader.close();
        
        // Remove the header row
        csvData.remove(0);
        
        // Convert List<String[]> to Object[][]
        Object[][] data = new Object[csvData.size()][csvData.get(0).length];
        for (int i = 0; i < csvData.size(); i++) {
            data[i] = csvData.get(i);
        }
        return data;
    }

    @Test(dataProvider = "householdData")
    public void HouseHoldCreate(String subBlockSite, String hhHeadName, String mobileNumber, String familyMemberCount) {

        // Click on "খানা নিবন্ধন"
        driver.findElement(By.id("org.smartregister.unicef.mis:id/action_register")).click();

        // Fill up HH form
      //union
      		driver.findElement(By.xpath("//android.widget.TextView[@text='ইউনিয়ন/ জোন *']")).click();
      		driver.findElement(By.xpath("//android.widget.TextView[@text='ZONE-02']")).click();
      		//old ward
      		driver.findElement(By.xpath("//android.widget.TextView[@text='পুরাতন ওয়ার্ড *']")).click();
      		driver.findElement(By.xpath("//android.widget.TextView[@text='NO OLD WARD']")).click();
      		//new ward
      		driver.findElement(By.xpath("//android.widget.TextView[@text='নতুন ওয়ার্ড *']")).click();
      		driver.findElement(By.xpath("//android.widget.TextView[@text='DNCC:WARD 06']")).click();
        // sub-block site
        driver.findElement(By.xpath("//android.widget.TextView[@text='সাব-ব্লক/ সাইট *']")).click();

        // (Selecting Sub-Block Site) Locate the ListView element by its class
        WebElement listView = driver.findElement(By.className("android.widget.ListView"));
        // Find all TextView elements inside the ListView (list items)
        List<WebElement> listItems = listView.findElements(By.className("android.widget.TextView"));

        // Iterate through each list item and click on it
        for (WebElement item : listItems) {
            String itemText = item.getText();  // Get the text of each list item
            if (itemText.equals(subBlockSite)) {
                item.click();  // Click the item
                break;
            }
        }

        // Scroll to "স্থায়ী ঠিকানা কি একই"
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"স্থায়ী ঠিকানা কি একই *\"));"));

      //Choose if permanent address is same or not
        driver.findElement(By.xpath("//android.widget.TextView[@text='স্থায়ী ঠিকানা কি একই *']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='হ্যাঁ']")).click();

        // HH head name
        driver.findElement(By.xpath("//android.widget.EditText[@text='পরিবারের প্রধানের নাম এর প্রথম অংশ (ইংরেজীতে) *']")).sendKeys(hhHeadName);

        // Mobile Number
        driver.findElement(By.xpath("//android.widget.EditText[@text='পরিবারের গুরুত্বপূর্ণ মোবাইল নাম্বার *']")).sendKeys(mobileNumber);

        // Family member count
        driver.findElement(By.xpath("//android.widget.EditText[@text='খানার মোট সদস্য সংখ্যা *']")).sendKeys(familyMemberCount);

        // Scroll to submit
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"জমা দিন\"));"));

        // submit Button
        driver.findElement(By.id("org.smartregister.unicef.mis:id/next")).click();
    }

}
