package techproed.tests.day20_Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.time.Duration;

public class C02_PropertiesTest {
    @Test
    public void test01() {
        OpenSourcePage openSourcePage = new OpenSourcePage();
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        //kullanici=Admin
        //kullaniciSifre=admin123

        openSourcePage.userName.sendKeys(ConfigReader.getProperty("OSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("OSourcePassword"));
        openSourcePage.loginButton.click();
        //Login Testinin basarili oldugunu test et
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOf(openSourcePage.verify));
        Assert.assertTrue(openSourcePage.verify.isDisplayed());

        //sayfayi kapatiniz
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        OpenSourcePage openSourcePage = new OpenSourcePage();
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        String url = ConfigReader.getProperty("openSourceUrl");
        Driver.getDriver().get(url);
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        //kullanici=Admin
        //kullaniciSifre=admin123

       String userName = ConfigReader.getProperty("OSourceUserName");
       String passwoord = ConfigReader.getProperty("OSourcePassword");
        openSourcePage.userName.sendKeys(userName, Keys.TAB,passwoord,Keys.ENTER);

        //Login Testinin basarili oldugunu test et
        ReusableMethods.visibleWait(openSourcePage.verify,15);
        Assert.assertTrue(openSourcePage.verify.isDisplayed());

        //sayfayi kapatiniz
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
