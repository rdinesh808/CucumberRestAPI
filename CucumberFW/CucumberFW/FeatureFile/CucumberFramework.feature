Feature: CUCUMBER FRAMEWORK

Scenario: Input form with validations
Given Navigate to the URL "https://www.seleniumeasy.com/test/input-form-demo.html"
Then Enter the Firstname 
|Firstname|
|Cucumber BDD|
And Enter the LastName
Then Enter email address
And Enter the phonenumber
Then Enter the Address
And Enter the City
When Select the state
Then Enter ZipCode
And Enter domine name
Then Select hosting or not
And Enter the description
But Click send button