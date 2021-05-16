package com.alvinmuniz.communallybackend.cucumbertests.userlogin;

import com.alvinmuniz.communallybackend.models.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.junit.jupiter.api.Assertions.*;


@Scope(SCOPE_CUCUMBER_GLUE)
public class UserLoginSteps {

    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Autowired
    private CucumberHttpClient userHttpClient;

    @LocalServerPort
    private int randomServerPort;

    // POJOS for testing purposes
    User user = new User();
    ResponseEntity<?> response;


    /***
     * Checks if access to "auth/users/register" is 200 status"
     */
    @Given("I am a visitor to your site accessing \\/register end point")
    public void i_am_a_visitor_to_your_site_accessing_register_end_point() {
        user.setEmail("user@email.com");
        user.setUsername("testUser");
        user.setPassword("123456");
    }


    @When("I complete registration by sending a username and password for registration")
    public void i_complete_registration_by_sending_a_username_and_password_for_registration() {
        response =
                userHttpClient.returnPostRequestResults("register", user);
        assertNotNull(response);
    }
    @Then("I am notified of a successful registration")
    public void i_am_notified_of_a_successful_registration() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println();
        assertEquals(200,response.getStatusCodeValue());
    }
    @Then("A response is generated with the credentials I provided")
    public void a_response_is_generated_with_the_credentials_i_provided() {
        // Write code here that turns the phrase above into concrete actions
        User responseUser = (User) response.getBody();
        assertNotNull(responseUser.getId());
        assertEquals(user.getUsername(), responseUser.getUsername());
        assertEquals(user.getEmail(), responseUser.getEmail());
    }

}
