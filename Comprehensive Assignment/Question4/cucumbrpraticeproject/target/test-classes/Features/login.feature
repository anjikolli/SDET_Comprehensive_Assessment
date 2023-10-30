Feature: Searching for Flights on MakeMyTrip
Scenario: Search for one-way flights
Given I am on the MakeMyTrip website
Then I Handle the Frames and Popups 
When I select one-way trip
And I enter "BOM" as the origin
And I enter "HYD" as the departure
And I select the start date
And I select the return date
And I click the Search button
Then I should see search results
