using System;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium;
using NUnit.Framework;
using SeleniumExtras.PageObjects;



    public class BasePage{

        public static IWebDriver driver;

        public void Initialize(){

            //chromedriverın set etilmesi ve URL belirlenmesi
            driver= new ChromeDriver();
            driver.Navigate().GoToUrl("https://open.spotify.com/");
        }

        [OneTimeTearDown]
  protected void TearDown() {
    driver.Quit();
  }
    }
