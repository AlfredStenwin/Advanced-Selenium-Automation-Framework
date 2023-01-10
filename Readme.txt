<Version 1.0>

This sample hybrid test automation framework based on:
  - Selenium WebDriver
  - TestNG 
  - Maven 
  - ExtentReprts
  - Log4j2 
  - Jackson library
  
This is a hybrid framework which is still under development.  New features are being added to the framework according to the priority or requests. Users can clone and change the framework according to their respective requirements. My indent in designign this framework is to make it to setup and start quickly with selenium. But at the same time I have tried to make it extendable, readable and maintainable.  

Folowing patterns are followed in this framework (some of which shall be altered according to the usablility)
  - Page Object Model is followed which is golden rule for test automation. Page Factory is not used in finding the elements but the page elements are segregated to seperate       classes and used the respective page classes by means of composition rather than inheritance. 
  - Factory pattern is used in initialising the Webdriver for different browsers, hence it can be extended to add any new browser driver supported by Selenium wihtout breaking     the existing code. 
  - Decorated driver and element is used in the entire framework which makes the logging easy without writing code for basic actions everytime. Only a few actions are added       now which can be updated accroding to individual requirements.
  - Fluent pattern is used in the sample tests to enhance the readablity of the tests whcih can be altered according to  the taste of the user.

Jackson library is used for reading the csv and json files. The utility classes for reading json files can read only simple json at present and is used to read the test data. But I am plannig to upgrade it in near future as Rest assured capability will be added to the framework.

Only 3 sample test are added now to give an idea of how to write the test cases but there are plans to add more test cases to give the users a better idea of the framework. 
  
Framework can be easily extended to use Appium for Andoid / iOS or Windows based apps using WinAppDirver by adding the respective drivers and capabilities in the driver factory. Also add the dependencies in the pom.xml file 
