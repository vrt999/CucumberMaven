$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/Sample.feature");
formatter.feature({
  "name": "Facebook login test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "login postive test",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "open chrome and run application",
  "keyword": "Given "
});
formatter.step({
  "name": "I enter valid \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User should be loggedin successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "vrt1",
        "vrt1pass"
      ]
    },
    {
      "cells": [
        "vrt2",
        "vrt2pass"
      ]
    }
  ]
});
formatter.scenario({
  "name": "login postive test",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "open chrome and run application",
  "keyword": "Given "
});
formatter.match({
  "location": "com.selenium.StepDefinitions.LoginStepDefinition.open_chrome_and_run_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter valid \"vrt1\" and \"vrt1pass\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.selenium.StepDefinitions.LoginStepDefinition.i_enter_valid_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be loggedin successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "com.selenium.StepDefinitions.LoginStepDefinition.user_should_be_loggedin_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "login postive test",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "open chrome and run application",
  "keyword": "Given "
});
formatter.match({
  "location": "com.selenium.StepDefinitions.LoginStepDefinition.open_chrome_and_run_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter valid \"vrt2\" and \"vrt2pass\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.selenium.StepDefinitions.LoginStepDefinition.i_enter_valid_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be loggedin successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "com.selenium.StepDefinitions.LoginStepDefinition.user_should_be_loggedin_successfully()"
});
formatter.result({
  "status": "passed"
});
});