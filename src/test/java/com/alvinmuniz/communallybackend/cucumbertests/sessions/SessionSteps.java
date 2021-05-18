package com.alvinmuniz.communallybackend.cucumbertests.sessions;

import com.alvinmuniz.communallybackend.cucumbertests.util.CucumberHttpClient;
import com.alvinmuniz.communallybackend.models.Login.LoginRequest;
import com.alvinmuniz.communallybackend.models.Login.LoginResponse;
import com.alvinmuniz.communallybackend.models.Session;
import com.alvinmuniz.communallybackend.models.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SessionSteps {

    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Autowired
    private CucumberHttpClient httpClient;

    User user = new User();
    ResponseEntity<?> response;
    User responseUser;
    LoginRequest loginRequest = new LoginRequest();
    String token;



    @Given("I am a registered user")
    public void i_am_a_registered_user() {
        user.setEmailAddress("user3@email.com");
        user.setUsername("testUser3");
        user.setPassword("1234567");
        this.response = httpClient.returnPostRequestResults("register",
                user);
        this.responseUser = (User) response.getBody();

        assertNotNull(this.responseUser.getId());

        loginRequest.setEmailAddress(this.responseUser.getEmailAddress());
        loginRequest.setPassword(this.user.getPassword());
        response = httpClient.returnLoginRequestResults("login",
                loginRequest);
        LoginResponse foundResponse = (LoginResponse) response.getBody();
        assertNotNull(response);
        assertNotNull(foundResponse);
        assertEquals(200,response.getStatusCodeValue());
        this.token = foundResponse.getJwt();

    }

    @When("I finish my meditation I save it")
    public void i_finish_my_meditation_i_save_it() {
        Session session = new Session();
        session.setUser(responseUser);
        session.setDate(LocalDate.now());
        session.setDuration(Duration.of(109L, ChronoUnit.SECONDS));

        response = httpClient.returnSessionPostResults("",session,this.token);

        assertEquals(200,response.getStatusCodeValue());
        // Write code here that turns the phrase above into concrete actions
        System.out.println(responseUser.getId());

    }
    @Then("I am notified of a successful save")
    public void i_am_notified_of_a_successful_save() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I am shown the successfully saved session filled out")
    public void i_am_shown_the_successfully_saved_session_filled_out() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I can only modify the reflection")
    public void i_can_only_modify_the_reflection() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I receive successful response showing I was successfull")
    public void i_receive_successful_response_showing_i_was_successfull() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I receive a copy of the updated reflection")
    public void i_receive_a_copy_of_the_updated_reflection() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("I am a user who has registered who has saved a session")
    public void i_am_a_user_who_has_registered_who_has_saved_a_session() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I select the saved meditation")
    public void i_select_the_saved_meditation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I can view the meditation")
    public void i_can_view_the_meditation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I can delete the saved meditation")
    public void i_can_delete_the_saved_meditation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
