@delete
  Feature: Delete the message in Slack

    Background:
      Given user has valid slack url

      Scenario: Delete my message
        When user sends delete to slack channel
        Then delete status code is 200
        And validate the message was deleted