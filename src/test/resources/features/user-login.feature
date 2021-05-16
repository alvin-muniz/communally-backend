Feature: Spring Security Implementation
  As a user of the system, I should have access to specified areas based off
  of my user role associated security settings.

  Scenario: Access Register Page As a Visitor
    Given I am a visitor to your site accessing /register end point
    When I complete registration by sending a username and password for registration
    Then I am notified of a successful registration
    And A response is generated with the credentials I provided

  Scenario: Login in as a registered user
    Given I am a user who has registered
    When I send a login request with my login credentials
    Then I receive a valid JWT token in response to authenticate me in the database
