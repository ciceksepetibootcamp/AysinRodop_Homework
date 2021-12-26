package Helper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    public Helper(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    //Test için kullanılabilecek yararlı komutların kaydedildiği sınıf

    public void click(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickElement(By elementBy) {
        MobileElement element = driver.findElement(elementBy);
        element.click();
    }

    public void sendKeysElement(By elementBy, String value) {
        MobileElement element = driver.findElement(elementBy);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }


    public String getText(By elementBy) {
        MobileElement element = driver.findElement(elementBy);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }



}
