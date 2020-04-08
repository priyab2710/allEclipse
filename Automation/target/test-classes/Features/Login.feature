Feature: Login page

Scenario: Validate login page
Given User is on login page
When user enters username and password
Then login is successful
And user details are displayed 