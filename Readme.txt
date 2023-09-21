<Version 1.0>

Hybrid test automation framework based on:
  - Selenium WebDriver
  - TestNG 
  - Maven 
  - ExtentReports
  - Log4j2 
  - Jackson library
  
With this framework, automation engineers can get started quickly on automating their tests rather than wasting time on designing and maintaining the framework. New features are being added to the framework constantky. My intent in designing this framework is to make it easy to setup and start quickly with selenium. But at the same time, I have tried to make it extendable, readable and maintainable.  Users can clone and adapt the framework according to their respective requirements if needed.

Following patterns are followed in this framework (some of which shall be altered according to the usability)
  - Page Object Model is followed which is golden rule for test automation. Page Factory is not used in finding the elements but the page elements are segregated to separate       classes and used the respective page classes by means of composition rather than inheritance. 
  - Factory pattern is used in initialising the Webdriver for different browsers, hence it can be extended to add any new browser driver supported by Selenium without breaking     the existing code. 
  - Decorated driver and element are used in the entire framework which makes the logging easy without writing code for basic actions every time. Only a few actions are added       now which can be updated according to individual requirements.
  - Fluent pattern is used in the sample tests to enhance the readability of the tests which can be altered according to  the taste of the user.
 
RunSetup.csv file is present in the 'src/test/resources' folder which can be used to configure which test cases to run for each execution cycle by marking 'true' against the test case name in the csv file. While adding new test cases to this file, please note that the test case name in the csv should be the same as the method name of the test in test class file. Parallel execution is also possible by executing the WebTesRunner.xml file with the required thread count as done normally in testNG (Will be moving this to config file to make it easier at the time of execution in subsequent iterations). Only 3 sample tests are added now to give an idea of how to write the test cases but there are plans to add more test cases to give the users a better idea of the framework. 

Jackson library is used for reading the csv and json files. The utility classes for reading json files can read only simple json at present and is used to read the test data. But I am planning to upgrade it in near future as Rest assured will be added to the framework for API testing.

Also for easier reporting of the bugs, I will add utility to create bug tickets on JIRA for the failed test scrips. 

Framework can be easily extended to use Appium for Android / iOS or Windows based apps using WinAppDirver by adding the respective drivers and capabilities in the driver factory ( Will be adding a layer to seperate the dirver configuration for web projects and mobile/native windows product in future). Also, add the dependencies in the pom.xml file

