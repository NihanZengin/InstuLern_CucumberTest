package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class MeetingPage {

    public MeetingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    // -----------------------------
    // Meeting Page Lokasyonları
    // -----------------------------


    // 1- Login butonu
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginButton;

    // 2- Email input
    @FindBy(id = "email")
    public WebElement emailInput;

    // 3- Password input
    @FindBy(id = "password")
    public WebElement passwordInput;

    // 4- Login submit button
    @FindBy(xpath = "//button[@type='submit' and text()='Login']")
    public WebElement loginSubmitButton;


    // Instructors linki
    @FindBy(xpath = "//a[@href='/instructors']")
    public WebElement instructorsLink;

    // Instructors basligi
    @FindBy(xpath = "//h1[normalize-space()='Instructors']")
    public WebElement instructorsTitle;

    //searchTextBox
    @FindBy(name = "search")
    public WebElement searchTextBox;

    //searchButton
    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//h3[normalize-space()='Categories']")
    public WebElement categoriesTitle;

    @FindBy(css = "input[name='categories[]']")
    public List<WebElement> categoryCheckboxes;

    //kategori filtresinden sonra instructor listesi
    @FindBy(css = "#bestRateInstructorsSwiper .course-teacher-card")
    public List<WebElement> instructorResults;

    // kategori filtresinden sonra instructor listesi /İsimler
    @FindBy(css = "#bestRateInstructorsSwiper h3")
    public List<WebElement> instructorNames;

    // Label’lar
    @FindBy(css = "div.mt-30 input[name='categories[]'] + label")
    public List<WebElement> categoryLabels;

    @FindBy(css = "#bestRateInstructorsSwiper .course-teacher-card")
    public List<WebElement> instructorCards;

    // Kart içindeki fiyat
    @FindBy(css = ".course-teacher-card .font-20.text-primary, .course-teacher-card .font-20.text-primary.font-weight-bold")
    public List<WebElement> instructorPrices;

    // Kart içindeki ders adı (instructor adı)
    @FindBy(css = ".course-teacher-card h3")
    public List<WebElement> instructorNames1;

    // Kart içindeki beğeni (rating)
    @FindBy(css = ".course-teacher-card .badge-primary")
    public List<WebElement> instructorRatings;

    @FindBy(xpath = "//a[contains(@href,'/profile?tab=appointments') and contains(@class,'btn-primary')]")
    public List<WebElement> reserveMeetingButtons;

    @FindBy(id = "plotId")
    public WebElement calendarArea;

    @FindBy(xpath = "//button[normalize-space()='Reserve a Meeting']")
    public WebElement reserveMeetingButton;

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


    // login methodu
    public void login(String email, String password){

        loginButton.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginSubmitButton.click();
    }

    //dinamik date methodu
    public void selectDate(String date){

        // 2026-03-18 → 2026,3,18 formatına çeviriyoruz
        String[] parts = date.split("-");
        String formattedDate = parts[0] + "," + Integer.parseInt(parts[1]) + "," + Integer.parseInt(parts[2]);

        String dynamicXpath = "//td[@data-date='" + formattedDate + "' and not(contains(@class,'disabled'))]";

        WebElement day = Driver.getDriver().findElement(By.xpath(dynamicXpath));
        day.click();
    }

    //Time secme
    public void selectTimeRange(String timeRange){

        String dynamicXpath = "//label[normalize-space()='" + timeRange + "']";

        WebElement timeElement = Driver.getDriver().findElement(By.xpath(dynamicXpath));
        timeElement.click();
    }

    public void selectMeetingType(String meetingType){

        By dynamicLocator = By.xpath(
                "//label[normalize-space()='" + meetingType + "']"
        );

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(dynamicLocator))
                .click();
    }

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





