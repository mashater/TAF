Feature: Более сложный тест

  Background: #повторяющееся действие которое выполняется до в каждом сценарии
    Given открыт браузер

  Scenario: Сценарий 1
    And login page is open


  Scenario: Сценарий 2
    * login page is open
    Then username field is displayed