package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends Obilet_baseTest {



@Test
public void Invalid_Login_Test(){
    //Kullanıcı yanlış şifre/kullanıcı adı girdiğinde ekrana gelen hata mesajını kontrol eder.

    LoginPage loginPage = new LoginPage(driver);
    loginPage
            .invalid_login("aysinrodop@gmail.com","123456")
            .checkErrorMessage("Kullanıcı adı ve şifrenizi kontrol ederek tekrar deneyiniz.");

}

}
