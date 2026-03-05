
Feature: Kullanıcının güvenli şekilde sistemden çıkış yapabilmesi

  Background:
    Given  kullanici_InstuLern_anasayfaya_gider
    When Kullanıcı "Instructor" olarak login olur

  Scenario: Dashboard sayfasında Logout linki görünür ve aktif
    When Kullanıcı profil ikonuna tıklar
    Then Kullanici acilan sekmede "Dashbord" butonuna tiklar
    And Kullanici sol side barda "Logout" gorunene kadar sayfayi asagi surukler
    Then Dashboard sayfasında "Logout" linki görünür olmalı
    And Dashboard sayfasında "Logout" linki tıklanabilir olmalı

  Scenario: Dashboard sayfasından başarılı şekilde Logout olunabilmeli
    When Kullanıcı profil ikonuna tıklar
    Then Kullanici acilan sekmede "Dashbord" butonuna tiklar
    And Kullanici sol side barda "Logout" gorunene kadar sayfayi asagi surukler
    When Kullanıcı Dashboard sayfasındaki "Logout" linkine tıklar
    Then Kullanıcı sistemden başarıyla çıkış yapabilmeli
    And Kullanıcı login sayfasına yönlendirilmelidir

  Scenario: Anasayfada profil ikonuna tıklanınca Logout linki görünür ve aktif olmalı
    When Kullanıcı profil ikonuna tıklar
    Then Profil sekmesinde "Logout" linki görünür olmalı
    And Profil sekmesinde "Logout" linki tıklanabilir olmalı

  Scenario: Profil menüsünden başarılı şekilde Logout olunabilmeli
    When Kullanıcı profil ikonuna tıklar
    And Kullanıcı profil sekmesindeki "Logout" linkine tıklar
    Then Kullanıcı sistemden başarıyla çıkış yapabilmeli
    And Kullanıcı login sayfasına yönlendirilmelidir