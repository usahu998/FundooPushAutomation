package com.bridgelabz.fundoopush.pompages;

import com.bridgelabz.fundoopush.generic.BaseTest;
import com.bridgelabz.fundoopush.utility.JsonReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class FundooPushLogin extends BaseTest {
    @DataProvider(name = "User Detail")
    public Object[][] passData() throws IOException {
        //return JsonReader.getJSONdata(AppConfig.getJsonPath()+"Registration.json", "Registration Data",3);
        return JsonReader.getdata("/home/admin1/Documents/Testing/FundooPushAutomation/src/test/java/com/bridgelabz/fundoopush/files/UserData.json", "User Detail", 5, 2);
    }

    @Test(dataProvider = "User Detail")
    public void userLogin(String emailId, String password) throws Exception {
        System.out.println(emailId + password);
        driver.get("https://fundoopush-dev.bridgelabz.com/login");
        driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(emailId);
        driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
        Thread.sleep(500);

    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}
