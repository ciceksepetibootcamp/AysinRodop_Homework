package pages;

import Helper.Helper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TicketSearch_Page extends Helper {

    public String fromCity_name= "İzmit";
    public String whereCity_name="Ankara";

    //Bilet arama sayfasındaki elementlerin tanımlamaları
    By from_city= By.id("com.obilet.androidside:id/find_bus_journey_from_where_textView");
    By searchbar= By.id("com.obilet.androidside:id/search_editText");
    By first_city= By.xpath("//*[contains(@text, 'İzmit (Kocaeli)')]");
    By where_city= By.id("com.obilet.androidside:id/find_bus_journey_to_where_textView");
    By second_city= By.xpath("//*[contains(@text, 'Ankara')]");
    By tomorrow= By.id("com.obilet.androidside:id/find_bus_journey_departure_tomorrow_button");
    By find_ticket= By.id("com.obilet.androidside:id/find_bus_journey_find_button");
    By alert= By.id("com.obilet.androidside:id/alert_dialog_alert_message_textView");
    By origin_item= By.id("com.obilet.androidside:id/item_origin_textView");
    By destination_item= By.id("com.obilet.androidside:id/item_destination_textView");

    public TicketSearch_Page(AndroidDriver driver) {
        super(driver);
    }

    //Kullanıcının iki farklı şehir girerek arama yapması durumu
    public TicketSearch_Page valid_ticket_search(){

        click(from_city);
        sendKeysElement(searchbar,fromCity_name);
        click(first_city);
        click(where_city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchbar));
        click(second_city);
        click(tomorrow);
        click(find_ticket);
        return this;

    }

     //Kullanıcının aynı şehiri girerek arama yapması durumu
    public TicketSearch_Page invalid_ticket_search(){

        click(from_city);
        sendKeysElement(searchbar,fromCity_name);
        click(first_city);
        click(where_city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchbar)).sendKeys(fromCity_name);
        click(first_city);
        click(tomorrow);
        click(find_ticket);
        return this;
    }

    //Ekrana gelen hata mesajının kontrolü
    public void checkErrorMessage(String textAlert){
        Assert.assertTrue(getText(alert).contains(textAlert));

    }

    //Assert kontrolü
    public void checkValidation(){
        Assert.assertTrue(getText(origin_item).contains(fromCity_name));
        Assert.assertTrue(getText(destination_item).contains(whereCity_name));

    }
}
