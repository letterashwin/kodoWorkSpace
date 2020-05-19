Feature: KODO's Mini project 

Scenario Outline: Search Functionality Validation 
	Given TC-1 I launch the URL 
	Then TC-2 Checking search bar availablity 
	And TC-3 Checking Search bar input validations 
	And TC-5 Checking Search bar functional behaviour using "<validText1>" and "<inValidText>" 
	Examples: 
		| validText1   | inValidText |
		| PRINTED SUMMER DRESS| xxxxyyyy |
		
