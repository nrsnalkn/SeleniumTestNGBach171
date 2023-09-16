package techproed.tests.day22_DataProvider_XmlFile;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] veriler() {
        return new Object[][]{{"honda"}, {"ford"}, {"audi"}, {"volvo"}, {"tesla"}};
    }

    @Test(dataProvider = "veriler")
    public void test01(String data) {
        GooglePage googlePage = new GooglePage();
        //Google sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleurl"));
        //DataProvider ile istedigimiz arac isimlerini aratalim
        googlePage.aramaKutusu.sendKeys(data, Keys.ENTER);
        //odev her cikan sonuctan rastgale 5 urunu tiklayip tiklamadigini dogrulayin

        //sayfayi kapatalim
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }

    @Test(dataProvider = "veriler")
    public void test02(String data) {
        AmazonPage amazonPage = new AmazonPage();
        //Google sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonurl"));
        //DataProvider ile istedigimiz arac isimlerini aratalim
        amazonPage.aramaKutusu.sendKeys(data, Keys.ENTER);
        //sayfayi kapatalim
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }

    @Test(dataProvider = "araclar")
    public void test03(String data) {
        System.out.println(data);
    }
}
