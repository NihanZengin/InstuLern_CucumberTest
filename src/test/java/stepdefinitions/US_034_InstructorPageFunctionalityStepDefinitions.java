package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.MeetingPage;
import pages.RegisterPage;
import utilities.Driver;

public class US_034_InstructorPageFunctionalityStepDefinitions {

    RegisterPage RegisterPage = new RegisterPage();
    MeetingPage MeetingPage = new MeetingPage();

    @When("Kullanıcı {string} olarak login olur")
    public void kullanici_olarak_login_olur(String role) {

        String email = "";
        String password = "Learn.123123"; // ortak password varsayalım

        if(role.equalsIgnoreCase("Student")){
            email = "nihan.user@instulearn.com";
        }
        else if(role.equalsIgnoreCase("Instructor")){
            email = "nihan.admin@instulearn.com";
        }
        else{
            throw new IllegalArgumentException("Geçersiz rol: " + role);
        }

        MeetingPage.login(email, password);
    }


    @Then("Instructors linki görünür olmalı")
    public void instructors_linki_gorunur_olmali() {
        Assertions.assertTrue(MeetingPage.instructorsLink.isDisplayed());
    }

    @Then("Instructors linki tıklanabilir olmalı")
    public void instructors_linki_tiklanabilir_olmali() {

        Assertions.assertTrue(MeetingPage.instructorsLink.isEnabled());
    }

    @Then("Kullanici Instructors linkine tıklar")
    public void kullanici_instructors_linkine_tiklar() {
        MeetingPage.instructorsLink.click();
    }

    @Then("Sayfada Instructors basligi görüntülenmeli")
    public void instructors_sayfasi_acilmalidir() {
        Assertions.assertTrue(MeetingPage.instructorsTitle.isDisplayed());
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().contains("instructors"));
    }

    @Then("Search textbox görünür olmalı")
    public void search_textbox_gorunur_olmali() {
        Assertions.assertTrue(MeetingPage.searchTextBox.isDisplayed());
    }

    @Then("Search textbox aktif olmalı")
    public void search_textbox_aktif_olmali() {
        Assertions.assertTrue(MeetingPage.searchTextBox.isEnabled());
    }

    @Then("Search butonu görünür olmalı")
    public void search_butonu_gorunur_olmali() {
        Assertions.assertTrue(MeetingPage.searchButton.isDisplayed());
    }

    @Then("Search butonu aktif olmalı")
    public void search_butonu_aktif_olmali() {
        Assertions.assertTrue(MeetingPage.searchButton.isEnabled());

    }

    @Then("Categories basligi altinda kategoriler görünür olmalı")
    public void categories_basligi_altinda_kategoriler_gorunur_olmali() {
        Assertions.assertTrue(MeetingPage.categoriesTitle.isDisplayed());

        // Checkbox listesi boş mu?
        Assertions.assertTrue(MeetingPage.categoryCheckboxes.size() > 0);

        // Tüm checkboxlar görünür mü?
        for (WebElement checkbox : MeetingPage.categoryCheckboxes) {
            Assertions.assertTrue(checkbox.isDisplayed());
        }
    }

    @Then("Categories basligi altinda kategoriler aktif olmalı")
    public void categories_basligi_altinda_kategoriler_aktif_olmali() {
        // Tüm checkboxlar enabled mı?
        for (WebElement checkbox : MeetingPage.categoryCheckboxes) {
            Assertions.assertTrue(checkbox.isEnabled());
        }
    }

    @When("Kullanıcı {string} adindaki kategoriyi seçer")
    public void kullanici_adindaki_kategoriyi_secer(String categoryName) {

        boolean found = false;

        for (WebElement label : MeetingPage.categoryLabels) {
            if (label.getText().equalsIgnoreCase(categoryName)) {
                WebElement checkbox = Driver.getDriver().findElement(By.id(label.getAttribute("for")));
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found, "Kategori bulunamadı: " + categoryName);
    }

    @Then("Instructorlar seçilen kategoriye gore filtrelenmeli")
    public void instructorlar_secilen_kategoriye_gore_filtrelenmeli() {


        // Instructor sonucu var mı?
        Assertions.assertTrue(MeetingPage.instructorResults.size() > 0, "Filtrelenmiş instructor bulunamadı.");

        // İstersen isim kontrolü de ekleyebilirsin
        for (WebElement name : MeetingPage.instructorNames) {
            Assertions.assertTrue(name.isDisplayed(), "Instructor ismi görünmüyor: " + name.getText());
        }
    }

    @Then("Instructor fiyat bilgisi görünür olmalı")
    public void instructor_fiyat_bilgisi_gorunur_olmali() {
        Assertions.assertTrue(MeetingPage.instructorPrices.size() > 0, "Instructor fiyat bilgisi bulunamadı.");
        for (WebElement price : MeetingPage.instructorPrices) {
            Assertions.assertTrue(price.isDisplayed(), "Instructor fiyat bilgisi görünmüyor: " + price.getText());
        }
    }

    @Then("Instructor ders adı görünür olmalı")
    public void instructor_ders_adi_gorunur_olmali() {
        Assertions.assertTrue(MeetingPage.instructorNames1.size() > 0, "Instructor adı bulunamadı.");
        for (WebElement name : MeetingPage.instructorNames1) {
            Assertions.assertTrue(name.isDisplayed(), "Instructor adı görünmüyor: " + name.getText());
        }
    }

    @Then("Instructor beğeni bilgisi görünür olmalı")
    public void instructor_begeni_bilgisi_gorunur_olmali() {
        Assertions.assertTrue(MeetingPage.instructorRatings.size() > 0, "Instructor beğeni bilgisi bulunamadı.");
        for (WebElement rating : MeetingPage.instructorRatings) {
            Assertions.assertTrue(rating.isDisplayed(), "Instructor beğeni bilgisi görünmüyor: " + rating.getText());
        }
    }

    @And("Kullanıcı {string}. siradaki instructori seçer")
    public void kullanici_siradaki_instructoru_secer(String siraNo) {

        int index = Integer.parseInt(siraNo) - 1; // Çünkü index 0'dan başlar


        MeetingPage.reserveMeetingButtons.get(index).click();
    }

    @When("Kullanıcı {string} tarihini secer")
    public void kullanici_tarih_secer(String tarih) {


        MeetingPage.selectDate(tarih);
    }

    @And("Kullanıcı {string} zaman araligini secer")
    public void kullanici_zaman_araligini_secer(String timeRange) {


        MeetingPage.selectTimeRange(timeRange);
    }

    @And("Kullanıcı meeting Type olarak {string} secer")
    public void kullanici_meeting_type_olarak_secer(String meetingType) {


        MeetingPage.selectMeetingType(meetingType);
    }

    @And("Kullanici Reserve a Meeting butonuna tiklar")
    public void kullanici_reserve_a_meeting_butonuna_tiklar() {

        MeetingPage.reserveMeetingButton.click();
    }

    @When("Kullanici odeme turu olarak {string} secer")
    public void kullanici_odeme_turu_olarak_secer(String paymentType) {

        MeetingPage.selectPaymentType(paymentType);
    }
}
