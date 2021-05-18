Feature: Sessions
  As a user of the system, I should have access to view my meditation
  sessions, save my meditations, add reflections to meditations and view all
  uploaded user generated content to the community board.

  Scenario: Save a meditation session and leave my reflection
    Given I am a registered user
    When I finish my meditation I
    Then I am notified of a successful registration
    And A response is generated with the credentials I provided

  Scenario: Login in as a registered user
    Given I am a user who has registered
    When I send a login request with my login credentials
    Then I receive a valid JWT token in response to authenticate me in the database
