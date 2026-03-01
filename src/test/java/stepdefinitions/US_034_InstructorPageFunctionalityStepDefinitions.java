package stepdefinitions;

import io.cucumber.java.en.*;
import pages.MeetingPage;
import pages.RegisterPage;

public class US_034_InstructorPageFunctionalityStepDefinitions {

    RegisterPage RegisterPage = new RegisterPage();
    MeetingPage MeetingPage = new MeetingPage();

    @When("Kullanici odeme turu olarak {string} secer")
    public void kullanici_odeme_turu_olarak_secer(String paymentType) {

        MeetingPage.selectPaymentType(paymentType);
    }
}
