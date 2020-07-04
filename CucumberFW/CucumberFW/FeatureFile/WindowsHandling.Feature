Feature: Selenium Windows Handling

Scenario: Windows Handling
Given Navigate to the URL
When Click multiple windows button
Then Navigate to child window
And get position of button
But go to parent window
