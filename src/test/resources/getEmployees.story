Feature: employees

Scenario: when a user get all the employees, all employees should be returned
Given the api to get all the employees
When the find all api is triggered
Then employees should be retrieved from database [{"id":1,"firstName":"Malli","lastName":"Bandi","dateOfJoin":[2012,3,15],"dateOfExit":[2019,9,30]},{"id":2,"firstName":"Sakthi","lastName":"Subramaniam","dateOfJoin":[2013,1,9],"dateOfExit":[2017,3,9]},{"id":3,"firstName":"Sakthi","lastName":"Malli","dateOfJoin":[2017,3,15],"dateOfExit":[2019,10,31]},{"id":4,"firstName":"Mallikarjuna","lastName":"Bandi","dateOfJoin":[2019,10,22],"dateOfExit":[2021,6,11]},{"id":5,"firstName":"Sakthi","lastName":"Subramaniam","dateOfJoin":[2019,11,13],"dateOfExit":[2023,6,14]},{"id":6,"firstName":"Gokula Sakthi","lastName":"Bandi","dateOfJoin":[2013,1,9],"dateOfExit":[2017,3,8]},{"id":7,"firstName":"Gokula Sakthi","lastName":"Mallikarjun","dateOfJoin":[2013,1,9],"dateOfExit":[2017,3,9]},{"id":8,"firstName":"Mallikarjuna","lastName":"Bandi","dateOfJoin":[2021,6,14],"dateOfExit":[2023,6,14]}]
