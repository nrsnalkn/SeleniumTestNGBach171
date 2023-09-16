package techproed.tests.day21_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_NegatifTest {
    @Test(groups = "smoke")
    public void negatifTest() {
        //Name:
        //US100208_Negative_Login
        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found

        //BlueRentarCar sayfasina gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        //Login buttonuna tiklayalim
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();
        String fakeEmail = ConfigReader.getProperty("fakeEmail");
        String fakePassword = ConfigReader.getProperty("fakePassword");
        blueRentalPage.email.sendKeys(fakeEmail, Keys.TAB, fakePassword, Keys.ENTER);
        //Properties dosyasindaki kullanimda olmayan email ve password bilgileri ile login olmadigini test edelim
        Assert.assertTrue(blueRentalPage.verifyNegatif.isDisplayed());

        //sayfayi kapatalim
        Driver.closeDriver();

    }

}
