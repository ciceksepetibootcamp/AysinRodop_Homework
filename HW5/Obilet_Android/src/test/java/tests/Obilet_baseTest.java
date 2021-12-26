package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Obilet_baseTest {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "/Users/aysin/Downloads/obilet Uçak Otobüs Bileti_v13.0.21_apkpure.com.apk");
        caps.setCapability("fullReset", "true");
        caps.setCapability("noReset", "false");
        caps.setCapability("autoGrantPermissions", "true");

        driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
