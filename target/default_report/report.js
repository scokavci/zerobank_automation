$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/FindTransactions.feature");
formatter.feature({
  "name": "Find Transactions in Account Activity",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "user is on login page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepDefinition.user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logs in as authorized user",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepDefinition.user_logs_in_as_authorized_user()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user logs in Account Activity page",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefinitions.user_logs_in_Account_Activity_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user access Find Transactions tab",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefinitions.userAccessFindTransactionsTab()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Type",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@type"
    }
  ]
});
formatter.step({
  "name": "click \"Deposit\" type",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefinitions.click_type(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks search",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefinitions.clicks_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "results table should show at least one result under Deposit",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.FindTransactionStepDefinitions.results_table_should_show_at_least_one_result_under_Deposit()"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of [[ChromeDriver: chrome on WINDOWS (5bed842d37f28ef5737ebfc0824541d3)] -\u003e xpath: (//table//tbody/tr/td[3])[1]] (tried for 25 second(s) with 500 milliseconds interval)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LAPTOP-E98E5O5G\u0027, ip: \u0027192.168.2.9\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002713.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 81.0.4044.129, chrome: {chromedriverVersion: 81.0.4044.69 (6813546031a4b..., userDataDir: C:\\Users\\Lenovo\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:55620}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 5bed842d37f28ef5737ebfc0824541d3\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:95)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\r\n\tat com.zerobank.pages.AccountActivityPage.verifyOneResultUnderDeposit(AccountActivityPage.java:133)\r\n\tat com.zerobank.stepdefinitions.FindTransactionStepDefinitions.results_table_should_show_at_least_one_result_under_Deposit(FindTransactionStepDefinitions.java:56)\r\n\tat ✽.results table should show at least one result under Deposit(file:///C:/Users/Lenovo/IdeaProjects/zerobank-automation/src/test/resources/features/FindTransactions.feature:31)\r\n",
  "status": "failed"
});
});