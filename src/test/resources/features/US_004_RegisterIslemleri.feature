Feature: Kullanıcı Kaydı

  Background:
    Given kullanıcı anasayfada
    And kullanıcı test verilerini hazırlar
      | accountType | Student         |
      | email       | test@mail.com   |
      | invalidEmail| invalidmail     |
      | fullName    | Ahmet Yılmaz    |
      | password    | Test123!        |
      | wrongPass   | Wrong123!       |
      | acceptTerms | true            |

  Scenario: TC_001 Kayıt linkinin görünürlüğünü doğrulama
    Then "Kayıt" linki görünür olmalı
    And "Kayıt" linki tıklanabilir olmalı

  Scenario: TC_002 Kayıt sayfasına gitme
    When kullanıcı "Kayıt" linkine tıklar
    Then "Kayıt" sayfası açılmalı
    And "Signup" formu görünür olmalı

  Scenario: TC_003 Öğrenci olarak başarılı kayıt
    Given kullanıcı Kayıt sayfasında
    When kullanıcı kayıt formunu varsayılan veriler ile doldurur
    And kullanıcı "Signup" butonuna tıklar
    Then kullanıcı başarıyla kayıt olmalı

  Scenario: TC_004 Geçersiz e-posta doğrulaması
    Given kullanıcı Kayıt sayfasında
    When kullanıcı kayıt formunu "invalidEmail" verisi ile doldurur
    And kullanıcı "Signup" butonuna tıklar
    Then "email" hata mesajı görüntülenmeli

  Scenario: TC_005 Şifre uyuşmazlığı doğrulaması
    Given kullanıcı Kayıt sayfasında
    When kullanıcı kayıt formunu "wrongPass" verisi ile doldurur
    And kullanıcı "Signup" butonuna tıklar
    Then "password mismatch" hata mesajı görüntülenmeli

  Scenario: TC_006 Kayıt sayfasından Giriş sayfasına gitme
    Given kullanıcı Kayıt sayfasında
    When kullanıcı "Login" linkine tıklar
    Then "Login" sayfası açılmalı