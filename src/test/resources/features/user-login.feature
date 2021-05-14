#Feature: Spring Security Implementation
#  As a user of the system, I should have access to specified areas based off
#  of my user role associated security settings.
#
#  Scenario: Access Register Page As a Visitor
#    Given I am a visitor to your site
#    When I complete registration
#    Then I am notified of a successful registration
#
#  Scenario: Login in as a registered user
#    Given I am a registered user
#    When I send a login request
#    Then I receive a valid JWT token
