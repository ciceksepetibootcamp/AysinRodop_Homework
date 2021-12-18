using System;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium;
using NUnit.Framework;
using SeleniumExtras.PageObjects;
using System.Threading;


    public class SearchPage : BasePage {


            public string search_word= "Duman";

        public SearchPage(IWebDriver driver){
             SearchPage.driver= driver;
             PageFactory.InitElements(driver,this);
        }

           //sayfadaki elementlerin tanımlanması
          [FindsBy( How = How.XPath, Using = "//span[contains(.,\'Search\')]" )]
          private IWebElement searchButton;

          [FindsBy( How = How.CssSelector, Using = ".QO9loc33XC50mMRUCIvf" )]

          private IWebElement searchBar;

           [FindsBy( How = How.CssSelector, Using = ".jDhY6c7obZ6QMTKlZM_w" )]
           private IWebElement artist;

          


    

         public void search(){
             // belirli bir sanatçının aranması
             Thread.Sleep(4000);
             searchButton.Click();
            Thread.Sleep(2000);
             searchBar.SendKeys(search_word);
             Thread.Sleep(4000);
             searchBar.SendKeys(Keys.Enter);
             artist.Click();
             Thread.Sleep(2000);

         }


           

    }
