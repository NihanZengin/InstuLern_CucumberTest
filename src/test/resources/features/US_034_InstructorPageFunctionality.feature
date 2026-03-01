Feature: Instructors Sayfası Fonksiyonel Testleri

  Background:
    Given kullanici_InstuLern_anasayfaya_gider

    Rule: Kullanici Student olarak login olur

  Scenario: TC_001 Anasayfada Instructors linki görünür ve aktif olmalı
    Then Instructors linki görünür olmalı
    And Instructors linki tıklanabilir olmalı

  Scenario: TC_002 Instructors linkine tıklandığında sayfa başlığı görüntülenmeli
    When Kullanıcı Instructors linkine tıklar
    Then Sayfada Instructors metni görüntülenmeli

  Scenario: TC_003 Instructors sayfasında arama alanları görünür ve aktif olmalı
    Given Kullanıcı Instructors linkine tıklar
    Then Search textbox görünür olmalı
    And Search textbox aktif olmalı
    And Search butonu görünür olmalı
    And Search butonu aktif olmalı

  Scenario: TC_004 Instructor seçmeden önce kategori seçilebilmeli
    Given Kullanıcı Instructors linkine tıklar
    Then Categories basligi altinda kategoriler görünür olmalı
    And Categories basligi altinda kategoriler aktif olmalı
    When Kullanıcı "Health and Fitness4" adindaki kategoriyi seçer
    Then Instructorlar seçilen kategoriye gore filtrelenmeli

  Scenario: TC_005 Seçilen instructor bilgileri görüntülenmeli
    Given Kullanıcı Instructors linkine tıklar
    When Kullanıcı "1" siradaki instructori seçer
    Then Instructor fiyat bilgisi görünür olmalı
    And Instructor ders adı görünür olmalı
    And Instructor beğeni bilgisi görünür olmalı

  Scenario: TC_006 Instructor için randevu talebi başarıyla oluşturulabilmeli
    Given Kullanıcı Instructors linkine tıklar
    And Kullanıcı "1" siradaki instructori seçer
    When Kullanıcı "2026-03-18" tarihini secer.
    And Kullanıcı meeting icin zaman araligi secer
    And Kullanıcı meeting Type"i "Online" olarak secer
    And Kullanici aciklamaya "a" yazar
    And Kullanici Reserve a Meeting butonuna tiklar
    And Kullanici sepete tiklar
    And Kullanici Go to Card butonuna tiklar
    And Kullanici Checkout butonuna tiklar
    When Kullanici odeme turu olarak " stripe " secer
    And Kullanici Start Payment butonuna tiklar
    Then Kullanici eposta olarak "test@gmail.com" girer
    And Kullanici odeme yontemi formunu doldurur
    And Kullanici Ode butonuna tiklar
    Then Congratulations mesajı görüntülenmeli

  Scenario: TC_007 My Panel butonu görünür ve aktif olmalı
    Given Kullanıcı Instructors linkine tıklar
    And Kullanıcı "1" siradaki instructori seçer
    When Kullanıcı "2026-03-18" tarihini secer.
    And Kullanıcı meeting icin zaman araligi secer
    And Kullanıcı meeting Type"i "Online" olarak secer
    And Kullanici aciklamaya "a" yazar
    And Kullanici Reserve a Meeting butonuna tiklar
    And Kullanici sepete tiklar
    And Kullanici Go to Card butonuna tiklar
    And Kullanici Checkout butonuna tiklar
    When Kullanici odeme turu olarak " stripe " secer
    And Kullanici Start Payment butonuna tiklar
    Then Kullanici eposta olarak "test@gmail.com" girer
    And Kullanici odeme yontemi formunu doldurur
    And Kullanici Ode butonuna tiklar
    Then My Panel butonu görünür olmalı
    And My Panel butonu tıklanabilir olmalı

  Rule: Kullanici Instructor olarak login olur