Feature: US1002 Kullanici ortak baslangic adimlarini background ile calistirir

  Background: Testotomasyonu anasayfaya gidis
    Given kullanici testotomasyonu anasayfaya gider

  Scenario: TC04 kullanici testotomasyonu sayfasinda phone bulabilmeli
    When arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder



  @smoke @paralel1
  Scenario: TC05  kullanici testotomasyonu sayfasinda dress bulabilmeli
    When arama kutusuna dress yazip aratir
    Then arama sonucunda urun bulunabildigini test eder


  @paralel2
  Scenario: TC06  kullanici testotomasyonu sayfasinda travel kelimesi aratinca urun bulabilmeli
    When arama kutusuna travel yazip aratir
    And arama sonucunda urun bulunabildigini test eder