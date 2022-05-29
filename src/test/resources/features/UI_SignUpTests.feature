@UIDemo
Feature: Create account tests
  I want to create account in fego.vmos-demo.com

  Background: Home page of fego.vmos-demo.com
    Given Goto the Home Page
    When Login form in login page

  Scenario: Login to fego.vmos-demo.com using valid account type
    Given Login page is displayed
    And Click on create account page
    And Create account page is displayed
    When Input credentials to create account
    And Click Create Account button
    And Click profile button
    And Click logout button
