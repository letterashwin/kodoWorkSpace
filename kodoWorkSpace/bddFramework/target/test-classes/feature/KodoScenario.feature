Feature: KODO's Mini project 

Scenario Outline: Search Functionality Validation 
	Given I launch the URL 
	Then Checking search bar availablity 
	And Checking Search bar input validations 
	And Checking Search bar functional behaviour using "<validText1>" and "<inValidText>" 
	Examples: 
		| validText1   | inValidText |
		| PRINTED SUMMER DRESS| xxxxyyyy |
		
