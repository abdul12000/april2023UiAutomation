#@TestToRun
Feature: 3101-Register an account
  As a User
  I want to be able to create an account
  So that I can purchase items on the lambdatest website

  Background:
    Given I am on the Lambdatest home page "https://ecommerce-playground.lambdatest.io/"

  @te
  Scenario: Register Page is dispayed when Register link in clicked
    When I click on MyAccount Menu
    And I click on Continue under the New Customer
    Then the Register Account page should be displayed

#  @TestToRun
  Scenario: Register new user happy path
    When I click on MyAccount Menu
    And I click on Continue under the New Customer
    And I enter valid details for First Name as "Lateef", Last Name as "Abdul", E-mail as "lat1@email.com", Telephone as "0788383838", Password as "123Pasword!"
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then Register Confirmation page is displayed

#  @TestToRun
  Scenario: 3108- Privacy Policy Acceptance validation
    When I click on MyAccount Menu
    And I click on Continue under the New Customer
    And I enter valid details for First Name as "Lateef", Last Name as "Abdul", E-mail as "lat1@email.com", Telephone as "0788383838", Password as "123Pasword!"
    And the pp box is left unticked
    And I click on Continue button on the Register and Account page
    Then error message is displayed

#  @TestToRun
  Scenario: Checkout
    When I click on MyAccount Menu
    And I enter username as  "lat1@email.com" and password "123Pasword!"
    And I click on Login button
    And I click on "Shop by Category" menu
    And I click on "Software" from the left hand menu
    And I choose "Palm Treo Pro"
    And I click on Buy Now
    And I accept terms and condition
    And I click on continue
    And I click on Confirm order button
    Then "Your order has been placed!" is displayed


#  @TestToRun
  Scenario: Register new user by hoovering on myAccount and clicking Register option
    When I hover on myAccount and click Register
#    And I click on Continue under the New Customer
    And I enter valid details for First Name as "Lateef", Last Name as "Abdul", E-mail as "lat1@email.com", Telephone as "0788383838", Password as "123Pasword!"
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then Register Confirmation page is displayed

  @TestToRun3
  Scenario Outline: Register new users happy path - using Scenario outline
    When I click on MyAccount Menu
    And I click on Continue under the New Customer
    And I enter valid details for "<firstName>", "<lastName>", "<emailAddress>", "<Telephone>" and "<password>"
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then Register Confirmation page is displayed
    Examples:
      | firstName | lastName | emailAddress | Telephone | password |
      | Tomi      | Ade      | tomAde@g.com | 013839    | 12345    |
#      | Remi     | Gragna   | remiAde@g.com | 000313839 | 1332345  |


#  @TestToRunNow
  Scenario: Register new users happy path - using data table
    When I click on MyAccount Menu
    And I click on Continue under the New Customer
    And I enter valid details as
      | Tomi            |
      | Ade             |
      | twwsomAde@g.com |
      | 013839          |
      | 12345           |
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then Register Confirmation page is displayed


  @TestToRunNow
  Scenario: Register new users happy path - using data table list 2X2
    When I click on MyAccount Menu
    And I click on Continue under the New Customer
    And I enter valid details for registration as
      | FIELD       | VALUE           |
      | firstName   | Tomi            |
      | lastname    | Ade             |
      | email       | twwsomAde@g.com |
      | phoneNumber | 013839          |
      | password    | 12345           |
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then Register Confirmation page is displayed


  Scenario: Login to Lambda site and logout
    When I click on MyAccount Menu
    And I login with the following details
      | username | lat1@email.com |
      | password | 123Pasword!    |
    Then "My Account" page is displayed
    When I click on Logout link from the right hand menu
    Then "Account Logout" page is displayed


 @scenarioToRun
  Scenario: Register new user by hoovering on myAccount and clicking Register option using POM
    When I hover on myAccount and click Register using POM
#    And I click on Continue under the New Customer
    And I enter valid details for First Name as "Lateef", Last Name as "Abdul", E-mail as "lat1@email.com", Telephone as "0788383838", Password as "123Pasword!"
    And I accept the privacy policy
    And I click on Continue button on the Register and Account page
    Then Register Confirmation page is displayed


