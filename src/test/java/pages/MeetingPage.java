package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MeetingPage {

    public MeetingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    // -----------------------------
    // Meeting Page Lokasyonları
    // -----------------------------


    // Stripe ödeme seçeneği
    @FindBy(xpath = "//label[@for='Stripe']")
    public WebElement stripePaymentOption;

    // Offline / Account Charge ödeme seçeneği
    @FindBy(xpath = "//label[@for='offline']")
    public WebElement offlinePaymentOption;

    //Congratulations basligi
    @FindBy(xpath = "//h2[.='Congratulations!']")
    public WebElement congratulationsTitle;

    //My Panel Butonu
    @FindBy(xpath = "//a[@href='/panel']")
    public WebElement myPanelButton;

    @FindBy(xpath = "//h1[text()='Events']")
    public WebElement eventsPageTitle;

//    public void verifyEventsPageOpened() {
//        Assertions.assertTrue(eventsPageTitle.isDisplayed());
//    }




    // -----------------------------
    // Yardımcı Metotlar
    // -----------------------------


    // Dinamik ödeme seçme methodu
    public void selectPaymentType(String paymentType) {

        switch (paymentType.toLowerCase()) {

            case "stripe":
                stripePaymentOption.click();
                break;

            case "offline":
                offlinePaymentOption.click();
                break;

            default:
                throw new IllegalArgumentException("Gecersiz odeme tipi: " + paymentType);
        }
    }
}





