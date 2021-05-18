Feature: Sessions
  As a user of the system, I should have access to view my meditation
  sessions, save my meditations, add reflections to meditations and view all
  uploaded user generated content to the community board.

  Scenario: Save a meditation session and leave my reflection
    Given I am a registered user
    When I finish my meditation I save it
    Then I am notified of a successful save
    And I am shown the successfully saved session filled out

  Scenario: View, Update and Delete a Meditation
    Given I am a user who has registered who has saved a session
    When I select the saved meditation
    Then I can view the meditation
    And I can only modify the reflection
    Then I can save the meditation without creating a new one
    And I can delete the meditation the saved meditation

