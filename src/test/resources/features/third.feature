Feature: Параметаризированные тесты

  Scenario: Простая параметаризация
    Given открыт браузер
    * login page is open
    When user with email "atrostyanko@gmail.com" and psw "Americana#1" logged in
    Then add project button is displayed
    And user name is "Alex Tros"
    And project count is 15


  Scenario Outline: Таблицы
    Given открыт браузер
    * login page is open
    When user with email "<email>" and psw "<psw>" logged in
    Then user name is "<visibleText>"
    Examples:
      | email                 | psw         | visibleText |
      | atrostyanko@gmail.com | Americana#1 | Alex Tros   |
      | test@gmail.com        | 123         | 123         |