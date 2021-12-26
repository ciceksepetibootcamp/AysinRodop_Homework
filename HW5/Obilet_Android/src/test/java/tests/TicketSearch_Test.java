package tests;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketSearch_Page;

public class TicketSearch_Test extends Obilet_baseTest{

@Test
    public void validTicketSearch(){
    //Kullanıcı isterleri doğru girdiğinde,listelenen sonuçların girilen şehirlerle denkliğini test eder.
    TicketSearch_Page ticketSearch_page= new TicketSearch_Page(driver);
    ticketSearch_page.valid_ticket_search()
            .checkValidation();
}

@Test
    public  void invalidTicketSearch(){
    //Kullanıcının gidiş ve dönüş yerini aynı şeçtiğinde ekrana gelen mesajı kontrol eder.
    TicketSearch_Page ticketSearch_page= new TicketSearch_Page(driver);
    ticketSearch_page
            .invalid_ticket_search()
            .checkErrorMessage("Gidiş ve dönüş için aynı lokasyonu seçtiniz.Lütfen farklı bir lokasyon seçiniz.");
}
}
