package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C04_BlueRentalCarExcelTest {
    @Test
    public void excelTest() {
        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tıklayalım
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.loginButton.click();

        //Excel dosyasındaki herhangi bir email ve password ile login olalım
        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi = "customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);
        String email = reader.getCellData(2,0);
        String password = reader.getCellData(2,1);
        rentalPage.email.sendKeys(email,Keys.TAB,password,Keys.ENTER);

        //Girilen email ile giriş yapıldığını doğrulayın
        ReusableMethods.bekle(2);
        rentalPage.profileButton.click();
        ReusableMethods.bekle(2);
        rentalPage.profile.click();
        String profileEmail = rentalPage.profileEmail.getText();
        Assert.assertEquals(email,profileEmail,"Emaillerde Uyusmazlik var");

        //sayfayı kapatalım
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}