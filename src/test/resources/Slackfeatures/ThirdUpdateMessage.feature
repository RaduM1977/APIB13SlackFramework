@put
  Feature: Edit(Change) the message in Slack

    Background:
      Given user has valid slack url

    Scenario: Update my message
      When  user sends a new message to slack channel
      Then new message status code is 200
      And new message is successfully delivered
