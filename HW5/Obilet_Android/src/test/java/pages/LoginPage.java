package pages;

import Helper.Helper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends Helper {

    //Giriş yap sayfasındaki elementlerin tanımlamaları

    By hesabim= By.id("com.obilet.androidside:id/bottom_nav_account");
    By username_textfield= By.xpath("(//android.widget.EditText)[1]");
    By password_textfield= By.xpath("(//android.widget.EditText)[2]");
    By login= By.id("com.obilet.androidside:id/login_button");
    By alert= By.id("com.obilet.androidside:id/alert_dialog_alert_message_textView");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    //Uygulamaya giriş yapar.
    public LoginPage invalid_login(String username, String password){

        clickElement(hesabim);
        sendKeysElement(username_textfield,username);
        sendKeysElement(password_textfield,password);
        click(login);
      return this;

    }

    //Ekrana gelen hata mesajını kontrol eder.
    public void checkErrorMessage(String textAlert){
        Assert.assertTrue(getText(alert).contains(textAlert));
    }

}
