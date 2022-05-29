@UIDemo
Feature: Login tests
  I want to create account in fego.vmos-demo.com

  Background: Home page of fego.vmos-demo.com
    Given Goto the Home Page
    When Login form in login page

  Scenario: Login to fego.vmos-demo.com using valid account type
    Given Login page is displayed
    When Input credentials to login with headers table
      | Email                         | Password     |
      | nileshgupta.nitc@gmail.com    | Nilu@demo26  |
    And Click login button
    And Click profile button
    And Click logout button