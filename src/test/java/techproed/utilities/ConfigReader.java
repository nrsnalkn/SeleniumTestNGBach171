package techproed.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    .properties dosyasindaki datalara ulasabilmek icin return type i
    String olan statik bir method olustururuz.
    Bu method icinde Properties classindan bir obje olustururuz
    ve fileinputStream ile .properties dosyamizi akisa alir
    properties classindan olusturdugumuz objeye akisa aldigimiz dosyayi
    load(): methodu ile yukleriz son olarak properties classindan olusturdugumuz
    obje ile gerProperty() methodunu kullanir ve girilen key 'in degerini bize return eder
     */
    public static String getProperty(String key) {
        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }

}
