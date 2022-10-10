@get
Feature: List messages and find the message

  Background:
    Given user has valid slack url

  Scenario: Find my message
    When user list message
    Then status code should be 200
    And user's message is in the list of messages