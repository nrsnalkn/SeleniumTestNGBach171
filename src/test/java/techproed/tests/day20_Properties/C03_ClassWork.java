package techproed.tests.day20_Properties;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_ClassWork {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        String userName = ConfigReader.getProperty("techpro_test_username");
        String password = ConfigReader.getProperty("techpro_test_password");
        centerPage.username.sendKeys(userName,Keys.TAB,password,Keys.ENTER);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(centerPage.verify.isDisplayed());
        ReusableMethods.bekle(2);

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logout.click();
        softAssert.assertEquals("Login",Driver.getDriver().getTitle());
        softAssert.assertAll();

        //sayfayı kapatınız
        Driver.closeDriver();
    }
}