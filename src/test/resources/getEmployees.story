Scenario: when a user checks a valid user's profile on github, github would respond json data

Given the api to get all the employees
When the find all api is triggered
Then employees should be retrieved from database
