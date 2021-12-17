package tests;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AramaTesti {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("Tek yon secer")
    public void tekYonSecer() {
        driver.findElement(By.linkText("Tek yön")).click();
    }

    @When("Varis noktasina Viyana girer")
    public void varisNoktasinaViyanaGirer() {
        driver.findElement(By.id("#portInputTo")).sendKeys("Viyana");
        driver.findElement(By.cssSelector(".focused span:nth-child(1)")).click();

    }

    @And("Tarihi girer")
    public void tarihiGirer() {
        driver.findElement(By.xpath("//span[@id=\'calendarPlaceholder\']/span")).click();
        driver.findElement(By.linkText("31")).click();
        driver.findElement(By.id("executeSingleCitySubmit_i")).click();
    }

    @Then("Biletler listelenir")
    public void biletlerListelenir() {
        WebElement element = driver.findElement(By.cssSelector(".fs-28"));
        String value = element.getAttribute("value");
        String locator = String.format("option[@value='%s']", value);
        String selectedText = element.findElement(By.xpath(locator)).getText();
        MatcherAssert.assertThat(selectedText, is("İstanbul - Viyana,"));

    }

    @Given("navigate to website")
    public void navigateToWebsite() {
        driver.get("https://www.turkishairlines.com/tr-tr/");
    }

    @Given("Kullanici check-in sayfasini acar")
    public void kullaniciCheckInSayfasiniAcar() {
        driver.findElement(By.cssSelector(".row:nth-child(1) li:nth-child(2) .tk-booker-tab-btn-head")).click();

    }

    public WebElement pnr_no;
    public WebElement surname;


    @Given("Kullanici ucak takibi sayfasını acar")
    public void kullaniciUcakTakibiSayfasınıAcar() {
        driver.findElement(By.cssSelector(".row:nth-child(1) li:nth-child(3) .tk-booker-tab-btn-head")).click();
    }

    @When("Yanlis ucus no girer")
    public void yanlisUcusNoGirer() {
        driver.findElement(By.id("membershipNumber")).sendKeys("1234");
    }

    @Then("PNRno hata mesaji goruntulenir")
    public void pnrnoHataMesajiGoruntulenir() {
        driver.findElement(By.cssSelector(".delay22 .light-arrow-right")).click();
        MatcherAssert.assertThat(driver.findElement(By.id("errormessage")).getText(), is("Please check the reservation and surname and try again."));
    }

    @Then("UcusNo hata mesaji goruntulenir")
    public void ucusnoHataMesajiGoruntulenir() {
        MatcherAssert.assertThat(driver.findElement(By.cssSelector(".word-wrap")).getText(), is("The flight you were looking for was not found."));
    }

    @And("Yanlis {string} girer")
    public void yanlisGirer(String surname) {
        driver.findElement(By.id("surname")).sendKeys(surname);
    }


    @When("Yanlis no {string} girer")
    public void yanlisNoGirer(String pnr_no) {
        driver.findElement(By.id("ticketNo")).sendKeys(pnr_no);
    }
}
