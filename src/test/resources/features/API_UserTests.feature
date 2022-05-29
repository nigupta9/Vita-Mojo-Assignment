@APIDemo
Feature: Create user API tests
  I want to create user using /user/v1/user endpoint and validate it

  Background: Create user successfully and validate
    Given Create user request

  Scenario: Create user with user profile and validate profile firstname and memberNumber
    Given Create user with "https://vmos2.vmos-demo.com/user/v1/user" endpoint
    And Validate create user response status code with 201
    And Validate all user request field with user profile response
    And Validate new user profile member number and token generation