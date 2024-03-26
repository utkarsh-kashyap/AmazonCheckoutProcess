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
Reporting in this project is facilitated by Extent Reports, a versatile reporting library for Java. Extent Reports generates detailed and interactive HTML reports that provide insights into test execution results.

### Setup
To generate Extent Reports, a custom listener named ListenerClass is configured in the testng.xml file located in the project's src/test/resources/runner directory. This listener captures test results and logs them using Extent Reports. The reports are generated in the test-output folder of the project directory.
```bash
./test-output/Test-Report-Extent.html
```

### Features
- Detailed Reports: Extent Reports provide comprehensive information about test execution, including test case status, duration, and logs.
- Custom Listener: The ListenerClass captures test results and passes them to the Extent logger for inclusion in the report.
- Screenshot Attachment: A feature has been added to attach screenshots for failed test cases directly within the report. Screenshots are encoded as Base64 images to enhance visibility and troubleshooting.

## Logging
Logging in this project is implemented using log4j, a popular logging framework for Java. It provides a flexible logging mechanism that allows logs to be displayed in the console and saved to a log file simultaneously.

### Configuration
- The log4j configuration is defined in the log4j2.xml file located in the project directory with path as:
```bash
/src/test/resources/log4j2.xml
```
- In this configuration, logs with a level of info or higher are displayed in the console and saved to the below defined file. The log messages are formatted with a timestamp, log level, and the logger's name.
```bash
.log/test.log
```
## Contributor
- [Utkarsh Kashyap](https://github.com/utkarsh-kashyap)
  
  
Feel free to contribute to the project by raising issues or submitting pull requests.

⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡
