
using System;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium;
using NUnit.Framework;
using SeleniumExtras.PageObjects;
using System.Threading;


    public class LoginPage : BasePage {

        public LoginPage(IWebDriver driver){
             LoginPage.driver= driver;
             PageFactory.InitElements(driver,this);
        }

           //sayfadaki elementlerin tanımlanması
          [FindsBy( How = How.CssSelector, Using = "div:nth-child(4) > .jzic9t5dn38QUOYlDka0" )]
          private IWebElement loginbutton;
    
          [FindsBy( How = How.Id, Using = "login-username")]
          private IWebElement username;

          [FindsBy( How = How.Id, Using = "login-password")]
          private IWebElement password;

         [FindsBy( How = How.Id, Using = "login-button")]
         private IWebElement signin;

         public void login(){
             //giriş yapmak için sıralı adımlar
             Thread.Sleep(2000);
             loginbutton.Click();
            Thread.Sleep(2000);
             username.SendKeys("aysinr");
             password.SendKeys("aysin123");
             signin.Click();
             Thread.Sleep(4000);

         }


           

    }
