package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C05_BlueRentalCarExcelTest {
    @Test
    public void excelTest() {
        //BlueRentalCar Sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage rentalPage = new BlueRentalPage();

        //Excel dosyamızdaki tüm email ve passwordler ile login olalım ve login olduğumuzu doğrulayalım
        String dosyaYolu ="src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi ="customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaIsmi);
        for (int i = 1; i <=reader.rowCount() ; i++) {
            String email = reader.getCellData(i,0);
            String password = reader.getCellData(i,1);
            rentalPage.loginButton.click();
            ReusableMethods.bekle(2);
            rentalPage.email.sendKeys(email,Keys.TAB,password,Keys.ENTER);
            ReusableMethods.bekle(3);
            Assert.assertTrue(rentalPage.verify.isDisplayed());
            rentalPage.profileButton.click();
            ReusableMethods.bekle(1);
            rentalPage.logout.click();
            ReusableMethods.bekle(1);
            rentalPage.okButton.click();

        }
       //sayfayı kapatını
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}