$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./FeatureFile/CucumberFrameWork.feature");
formatter.feature({
  "line": 1,
  "name": "CUCUMBER FRAMEWORK",
  "description": "",
  "id": "cucumber-framework",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1686608504,
  "status": "passed"
});
formatter.before({
  "duration": 5339621664,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Input form with validations",
  "description": "",
  "id": "cucumber-framework;input-form-with-validations",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Navigate to the URL \"https://www.seleniumeasy.com/test/input-form-demo.html\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Enter the Firstname",
  "rows": [
    {
      "cells": [
        "Firstname"
      ],
      "line": 6
    },
    {
      "cells": [
        "Cucumber BDD"
      ],
      "line": 7
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Enter the LastName",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Enter email address",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Enter the phonenumber",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Enter the Address",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Enter the City",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Select the state",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Enter ZipCode",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Enter domine name",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Select hosting or not",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "Enter the description",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Click send button",
  "keyword": "But "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.seleniumeasy.com/test/input-form-demo.html",
      "offset": 21
    }
  ],
  "location": "Scenario_01.Navigate_to_the_URL(String)"
});
formatter.result({
  "duration": 5964534476,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Enter_the_Firstname(DataTable)"
});
formatter.result({
  "duration": 4383388832,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.And_Enter_the_LastName()"
});
formatter.result({
  "duration": 4285512740,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Enter_email_address()"
});
formatter.result({
  "duration": 4489714820,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Enter_the_phonenumber()"
});
formatter.result({
  "duration": 3047650648,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Enter_the_Address()"
});
formatter.result({
  "duration": 8563420180,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Enter_the_City()"
});
formatter.result({
  "duration": 5256734188,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Select_the_state()"
});
formatter.result({
  "duration": 8345782244,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Enter_ZipCode()"
});
formatter.result({
  "duration": 5229795452,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Enter_domine_name()"
});
formatter.result({
  "duration": 5447141604,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Select_hosting_or_not()"
});
formatter.result({
  "duration": 3159888808,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Enter_the_description()"
});
formatter.result({
  "duration": 5356425256,
  "status": "passed"
});
formatter.match({
  "location": "Scenario_01.Click_send_button()"
});
formatter.result({
  "duration": 6433404108,
  "status": "passed"
});
formatter.after({
  "duration": 3700060132,
  "status": "passed"
});
});