package techproed.tests.day20_Properties;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_PropertiesTest {
    @Test
    public void test01() {

        String url = ConfigReader.getProperty("amazonurl");
        System.out.println(url);
        Driver.getDriver().get(ConfigReader.getProperty("techprourl"));
        Driver.getDriver().get(url);
    }

}
