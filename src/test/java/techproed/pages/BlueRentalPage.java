package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;
public class BlueRentalPage {
    public BlueRentalPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//li//a)[1]")
    public WebElement loginButton;

    @FindBy(xpath = "(//input)[1]")
    public WebElement email;

    // CONTINUE RESERVATION Button
    @FindBy(xpath = "(//button)[3]")
    public WebElement verify;

    //Giriş yapılamayan bölümdeki Login Button
    @FindBy(xpath = "(//button)[2]")
    public WebElement verifyNegatif;

    @FindBy(xpath = "(//button)[1]")
    public WebElement profileButton;

    @FindBy(xpath = "//*[.='Profile']")
    public WebElement profile;

    @FindBy(xpath = "//em")
    public WebElement profileEmail;

    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logout;

    @FindBy(xpath = "//*[.='OK']")
    public WebElement okButton;
}
