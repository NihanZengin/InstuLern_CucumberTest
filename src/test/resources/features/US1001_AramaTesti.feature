@smoke @regression
Feature: US1001 kullanici testotomasyonu sayfasinda arama yapar

  Scenario: TC01 kullanici testotomasyonu sayfasinda phone bulabilmeli
    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder



  @E2E_kullanici @paralel1
  Scenario: TC02  kullanici testotomasyonu sayfasinda dress bulabilmeli
    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna dress yazip aratir
    Then arama sonucunda urun bulunabildigini test eder


  @paralel2
  Scenario: TC03  kullanici testotomasyonu sayfasinda travel kelimesi aratinca urun bulabilmeli
    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna travel yazip aratir
    And arama sonucunda urun bulunabildigini test eder