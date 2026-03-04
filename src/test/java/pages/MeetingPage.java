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

    @FindBy(xpath = "//*[@class='checkbox-button bordered-200 mr-20']")
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
    @FindBy(css = ".course-teacher-card span.font-20.text-primary")
    public List<WebElement> instructorPrices;

    // İlk instructor kartındaki güncel fiyat
    @FindBy(css = ".course-teacher-card:first-of-type span.font-20.text-primary")
    public WebElement firstInstructorPrice;

    // Kart içindeki ders adı (instructor adı)
    @FindBy(css = ".course-teacher-card h3")
    public List<WebElement> instructorNames1;

    // İlk instructor kartındaki isim
    @FindBy(css = ".course-teacher-card:first-of-type h3.mt-20.font-16.font-weight-bold.text-dark-blue")
    public WebElement firstInstructorName;

    // İlk instructor kartındaki ders/unvan bilgisi
    @FindBy(css = ".course-teacher-card:first-of-type div.mt-5.font-14.text-gray")
    public WebElement firstInstructorTitle;

    // Kart içindeki beğeni (rating)
    @FindBy(css = ".course-teacher-card .badge-primary")
    public List<WebElement> instructorRatings;

    // İlk instructor kartındaki rating / beğeni bilgisi
    @FindBy(css = ".course-teacher-card:first-of-type span.badge.badge-primary")
    public WebElement firstInstructorRating;


    @FindBy(xpath = "//a[contains(@href,'/profile?tab=appointments') and contains(@class,'btn-primary')]")
    public List<WebElement> reserveMeetingButtons;

    @FindBy(id = "plotId")
    public WebElement calendarArea;


    // İlk instructor için ilk saat aralığı label
    @FindBy(xpath = "(//div[contains(@class,'course-teacher-card')]//div[contains(@class,'available-times')]//label)[1]")
    public WebElement instructorFirstTimeLabel;

    @FindBy(id = "availableTime91")
    public WebElement availableTime;


    @FindBy(name = "description")
    public WebElement descriptionTextArea;

    @FindBy(xpath = "//button[normalize-space()='Reserve a Meeting']")
    public WebElement reserveMeetingButton;





    @FindBy(id = "navbarShopingCart")
    public WebElement shoppingCartButton;

    @FindBy(xpath = "//a[normalize-space()='Go to cart']")
    public WebElement goToCartButton;

    @FindBy(css = "label[for='Stripe']")
    public WebElement checkoutButton;



    // Stripe ödeme seçeneği
    @FindBy(css = "label[for='Stripe']")
    public WebElement stripePaymentOption;

    // Offline / Account Charge ödeme seçeneği
    @FindBy(xpath = "//label[@for='offline']")
    public WebElement offlinePaymentOption;

    @FindBy(id = "paymentSubmit")
    public WebElement startPaymentButton;



    @FindBy(id = "cardNumber")
    public WebElement cardNumberInput;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement payButton;



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

    public void enterEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void selectCategory(String categoryName) {
        WebElement category =
                Driver.getDriver().findElement(By.xpath("//label[normalize-space()='" + categoryName + "']"));
        category.click();
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

    public void enterCardNumber(String cardNumber){
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNumber);
    }

    public void fillCardDetails( String number, String expiry, String cvc, String fullName) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // ---------------- CARD NUMBER ----------------
        WebElement cardNumber = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber"))
        );

       cardNumber.sendKeys(number);


        // ---------------- EXPIRY ----------------
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cardExpiry"))).sendKeys(expiry);



        // ---------------- CVC ----------------
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cardCvc"))).sendKeys(cvc);




        // ---------------- BILLING NAME ----------------
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("billingName")
        )).sendKeys(fullName);

    }
}





