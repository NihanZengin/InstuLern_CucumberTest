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

    //My Panel Butonu
    @FindBy(xpath = "//a[@href='/panel']")
    public WebElement myPanelButton;

    @FindBy(xpath = "//h1[text()='Events']")
    private WebElement eventsPageTitle;

//    public void verifyEventsPageOpened() {
//        Assertions.assertTrue(eventsPageTitle.isDisplayed());
//    }
}
