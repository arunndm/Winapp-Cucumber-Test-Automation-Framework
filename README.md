# winapp-cucumber-sample
A ready to use Test Automation framewok for windows based applications. Framework uses java, junit and winapp driver. Framework comes with an integrated reporting module with extent-reports.

#How to use
a) define page objects (src/test/java/pageObjects/jsonLocator.json)
b) write feature files (src/test/resources/featureFiles) with reference to pre-defined stepdefinitions (src/test/java/stepDefinitions)
c) Execute the tests by running the testRunner file (src/test/java/runnerFiles/testRunner.java) as Junit
d) Reports will be generated (test-output\HtmlReport)

#Default Example
For ease of understanding, a simple sign-in and sign-out process of skype application is demonstrated in the framework. 

#Framework Configuration
Use the framework configuration (/src/test/java/config/frameworkConfig.java) to declare the windows application, Winapp remote and Global wait time (in seconds).

#Report Configuration
Use the Report configuration (src/test/resources/configs/extent-config.xml) to modify any extent-report configs.
