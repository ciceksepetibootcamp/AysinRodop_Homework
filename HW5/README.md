# Obilet Android Otomasyonu

Bu projede Appium ve TestNG frameworkü ile Obilet uygulamasına Java dilinde 3 farklı test yazılmıştır.


## Gereksinimler

Projenin kullanımı için gerekli araçlar: 

- Appium server ve inspector 
- Android Studio ile emülatör 
- Intellij IDE


```java
    
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "/Users/aysin/Downloads/obilet Uçak Otobüs Bileti_v13.0.21_apkpure.com.apk");
        caps.setCapability("fullReset", "true");
        caps.setCapability("noReset", "false");
        caps.setCapability("autoGrantPermissions", "true");

        driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);

```
Appium Inspector da ayarladığımız capability parametlerini burada "baseTest" sınıfında "beforeMethod" una koyarak her testten önce gerekli ayarlamaların yapılması sağlanmış oldu.

## Testler

####  Test-1
```java
 public void Invalid_Login_Test()
```
- Yanlış username ve password ile giriş yapılması
- Ekrana gelen hata mesajının beklenen mesaj ile eş olma durumunun kontrolü

#### Test-2
```java
 public void validTicketSearch()
```
- Gidiş ve dönüş şehirlerinin İzmit ve Ankara seçilerek doğru listeleme yapılıp yapılmadığı kontrolü gerçekleştirilmektedir.

#### Test-3
```java
 public  void invalidTicketSearch()
```
- Gidiş ve dönüş yerinin aynı seçildiğinde ekrana gelen hatanın, beklenen hata mesajı ile aynı olup olmadığını kontrol eder.
