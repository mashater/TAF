Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Простой тест с Given
    Given открыт браузер

  Scenario: простой тест с Given и When
    Given открыт браузер
    When login page is open

  Scenario: простой тест со всеми ключевыми словами
    Given открыт браузер
    When login page is open
    Then username field is displayed

  Scenario: Использование And (*) c Given
    Given открыт браузер
    And login page is open


  Scenario: Использование And (*) c Given
    Given открыт браузер
    * login page is open
    Then username field is displayed