# Selenium-TestNG Framework (Amazon Checkout Process)

A based on Page Object Model, Selenium, TestNG using Java for testing Amazon checkout process.

This framework is based in Page Object Model (POM).

The framework uses:

- Java 
- Selenium
- TestNG
- Extent Report

## Setup Instruction

- Clone the repository to your local machine.
- Ensure you have JDK, Maven, and Git installed on your system.
- Configure the config.properties file to specify browser, headless mode, baseURL, email, password, and wait time.

## Configuring Browsers and Headless Mode

- Modify the config.properties file to set the desired browser (chrome, firefox, edge) and headless mode (true/false).
- Location for config file :
```bash
/src/test/resources/property/config.properties
```

 ### Executing Tests
 - TestNG.xml: Execute tests by running the TestNG.xml file present at src/test/resources/runner/testng.xml. Right-click on the TestNG.xml file and select "Run As" -> "TestNG Suite".
 ```bash
 /src/test/resources/runner/testng.xml
 ```
 - Maven Command: Execute tests using Maven command mvn clean test from the terminal/command prompt.
    
 ```bash
 mvn clean test
 ```
## Reporting
- Test reports are generated using Extent Reports.
- Custom listeners are configured in the testng.xml file to generate reports.
- Location of extent test report :-
```bash
./test-output/Test-Report-Extent.html
```
## Contributor
- [Utkarsh Kashyap](https://github.com/utkarsh-kashyap)
  
  
Feel free to contribute to the project by raising issues or submitting pull requests.

⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡
