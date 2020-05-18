Feature: Android , IOS and WebAppApp Testing

  @severity=blocker
  @Android
  Scenario: Testing Demo App links
    Given I initialize the android driver
    And I click on "Preference" Link after opening demo application
    And I click on "3. Preference dependencies" Link after opening demo application
    Then I validate the "WiFi settings" should present on the page
    And I click on CheckBox present on the page
    And I click on "WiFi settings" on the page
    Then I enter value in textbox "Hello App"

  @Android
  Scenario: Api validation from Native App
    Given I initialize the android driver
    And I click on "Preference" Link after opening demo application
    And I click on "3. Preference dependencies" Link after opening demo application
    Then I validate the "WiFi settings" should present on the page
    Given I provide ContentType.JSON for the next task
    Then I validate the json response at index "2" with the native android app


  Scenario:BrowserStack IOS application on Iphone 11 Pro
    Given I initializes the IOS driver and there desired capabilities
    And I click on "Text Button" on the page after opening the application
    And I have pass the value "Testing the field" in the textbox
    Then I quit the IOS driver

          #Scenario: WebApp Chrome Testing Covid19 page
             #Given I initializes the chrome
             #And I open the Webpage "https://www.google.com/"
             #And I search "Covid19" in search bar on the page
             #And I clicked on search Button
             #Then I click on covid19 home page link
             #Then I validate The text "Ministry of Health[ ]and Family Welfare" on the page"""