Feature: Sessions
  As a user of the system, I should have access to view my meditation
  sessions, save my meditations, add reflections to meditations and view all
  uploaded user generated content to the community board.

  Scenario: Save a meditation session and leave my reflection
    Given I am a registered user
    When I finish my meditation I save it
    Then I am notified of a successful save
    And I am shown the successfully saved session filled out

  Scenario: Update a meditation session
    Given I am a user who has registered who has saved a session
    When I select the saved meditation
    And I can only modify the reflection
    Then I receive successful response showing I was successfull
    And I receive a copy of the updated reflection

  Scenario: View a meditation
    Given I am a user who has registered who has saved a session
    When I select the saved meditation
    Then I can view the meditation

  Scenario: Delete a meditation
    Given I am a user who has registered who has saved a session
    When I select the saved meditation
    Then I can delete the saved meditation

