# Selenium Cucumber with Rest Assured Framework

---

## Project Purpose
This vita-mojo assignment project aims to create simple automation test framework that uses Selenium and Cucumber
and Rest Assured with Java to support UI and API automation test
---

## Tools and Libraries
This project using 3 main tools, Selenium, Rest Assured and Cucumber.
Also, some other tools that support this great framework.
The complete list of tools, you can see in the `pom.xml` file.
Note: imported Faker package to create random data everytime to create account successfully
In UI and API Automation test

## Requirements
* Java Development Kit
* Maven
* WebDriver, using ChromeDriver
* Rest Assured

## API Test - src/test/java/API folder - only using Rest Assured with test framework
* Two files - 1. LoginTest.java 2. SingupTest.java
* LoginTest.java for get user profile and other tests - 7 tests
* SignUpTest.Java file to create user and validate profile info - 1 test

## All Test - src/test/resources - Can run both feature file using TestRunner.java file
* Can run all 3 test using src/test/java/Runners/TestRunner by right click then Run "TestRunner"
* 3 files - 1. UI_LoginTests.feature  2. UI_SignUpTests.feature 3. API_UserTests.feature
* For UI tag is @UIDemo and For API tag is @APIDemo
* UI_LoginTests.feature file is for UI login test
* UI_SignUpTests.feature file is for UI create user account
* API_UserTests.feature is for API endpoints to create user account

## Running Tests
* Clone the repository from your fork to this directory
* Open the project using any Java IDE
* Run the tests with many ways 
1. With the script below
```shell
$ mvn clean install
```
* If you want to run the specific test, use the cucumber tags like this
```shell
$ mvn clean install -Dcucumber.filter.tags="@REPLACE_WITH_ANY_TAGS_THAT_YOU_WANT"
```
2. Using TestRunner File (Location: src/test/java/Runners/TestRunner)

3. Right click and select particular file to run test for folder location below
   * 3.1 src/main/test/java/API
   * 3.2 src/main/test/resources/features/

## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* See test report from `target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html`
* You can also share your Cucumber Report with another person at https://reports.cucumber.io, just go to `src/test/resources/cucumber.properties` then change the value to be `true`
```properties
cucumber.publish.enabled=true
```
* For more information about reports cucumber you can go to https://reports.cucumber.io/docs/cucumber-jvm

---

### References
* https://cucumber.io/docs/installation/java/
* https://www.selenium.dev/documentation/en/
* https://www.toolsqa.com/cucumber-automation-framework/
* https://www.w3schools.com/java/
* https://www.oracle.com/java/technologies/javase/codeconventions-introduction.html
