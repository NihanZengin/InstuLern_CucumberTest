package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestotomasyonuStepdefinitions {

    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @When("arama kutusuna phone yazip aratir")
    public void arama_kutusuna_phone_yazip_aratir() {
        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder() {

        String bulunamadiYazisi = ConfigReader.getProperty("toBulunamadiYazisi");
        String actualAramaSonucu = testotomasyonuPage.aramaSonucElementi.getText();

        Assertions.assertNotEquals(bulunamadiYazisi,actualAramaSonucu);
    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }

    @When("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir() {
        testotomasyonuPage.aramaKutusu.sendKeys("dress" + Keys.ENTER);
    }

    @When("arama kutusuna travel yazip aratir")
    public void aramaKutusunaTravelYazipAratir() {
        testotomasyonuPage.aramaKutusu.sendKeys("travel" + Keys.ENTER);
    }

    @Then("ilk urunu tiklar")
    public void ilk_urunu_tiklar() {
        testotomasyonuPage.bulunanUrunElementleriList.get(0).click();
    }

    @Then("acilan sayfadaki urun isminin case sensitive olmadan phone icerdigini test eder")
    public void acilan_sayfadaki_urun_isminin_case_sensitive_olmadan_phone_icerdigini_test_eder() {

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

    }

    @When("arama kutusuna {string} yazip aratir")
    public void arama_kutusuna_yazip_aratir(String aranacakKelime) {

        testotomasyonuPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);
    }

    @And("kodlari {int} saniye bekletir")
    public void kodlariSaniyeBekletir(int saniye) {
        ReusableMethods.bekle(saniye);
    }


    @Then("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder() {

        String expectedAramaSonucu = ConfigReader.getProperty("toBulunamadiYazisi");
        String actualAramaSonucu = testotomasyonuPage.aramaSonucElementi.getText();

        Assertions.assertEquals(expectedAramaSonucu,actualAramaSonucu);
    }

    @When("account linkine basar")
    public void account_linkine_basar() {
        testotomasyonuPage.accountLinki.click();
    }

    @Then("email olarak {string} girer")
    public void email_olarak_girer(String configDosyasiEmail) {

        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty(configDosyasiEmail));

    }

    @Then("password olarak {string} girer")
    public void password_olarak_girer(String configDosyasiPassword) {

        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty(configDosyasiPassword));
    }

    @Then("signIn butonuna basar")
    public void sign_in_butonuna_basar() {
        testotomasyonuPage.loginSayfasiSubmitButonu.click();
    }

    @Then("basarili olarak giris yapilabildigini test eder")
    public void basarili_olarak_giris_yapilabildigini_test_eder() {
        Assertions.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
    }

    @Then("logout butonuna basarak cikis yapar")
    public void logout_butonuna_basarak_cikis_yapar() {

        testotomasyonuPage.logoutButonu.click();

    }


    @When("sisteme giris yapilamadigini test eder")
    public void sistemeGirisYapilamadiginiTestEder() {
        Assertions.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
    }


    @And("acilan sayfadaki urun isminde case sensitive olmadan config dosyasindaki toAranacakKelime oldugunu test eder")
    public void acilanSayfadakiUrunIsmindeCaseSensitiveOlmadanConfigDosyasindakiToAranacakKelimeOldugunuTestEder() {

        String expectedIsimIcerik = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

    }

    @When("arama kutusuna config dosyasindaki toAranacakKelime yazip aratir")
    public void aramaKutusunaConfigDosyasindakiToAranacakKelimeYazipAratir() {

        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String configDosyasiUrl) {

        Driver.getDriver().get(ConfigReader.getProperty(configDosyasiUrl));
    }

    @When("email olarak listede verilen {string} girer")
    public void emailOlarakListedeVerilenGirer(String direktVerilenEmail) {

        testotomasyonuPage.loginSayfasiEmailKutusu.sendKeys(direktVerilenEmail);
    }


    @And("password olarak listede verilen {string} girer")
    public void passwordOlarakListedeVerilenGirer(String direktVerilenPassword) {

        testotomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(direktVerilenPassword);
    }
}
