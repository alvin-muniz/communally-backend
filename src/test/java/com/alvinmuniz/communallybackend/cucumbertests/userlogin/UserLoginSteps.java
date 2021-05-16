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

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Scope(SCOPE_CUCUMBER_GLUE)
public class UserLoginSteps {

    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Autowired
    private CucumberHttpClient userHttpClient;

    @LocalServerPort
    private int randomServerPort;

    User user = new User();


    @Given("I am a visitor to your site accessing \\/register end point")
    public void i_am_a_visitor_to_your_site_accessing_register_end_point() {

        user.setEmail("user@email.com");
        user.setUsername("testUser");
        user.setPassword("123456");

        ResponseEntity<?> response =
                userHttpClient.returnPostRequestResults(userHttpClient.getRequest(
                        "register"), user);

        assertEquals(200,response.getStatusCodeValue());

    }


    @When("I complete registration by sending a username and password for registration")
    public void i_complete_registration_by_sending_a_username_and_password_for_registration() {
        // Write code here that turns the phrase above into concrete actions

        throw new io.cucumber.java.PendingException();
    }
    @Then("I am notified of a successful registration")
    public void i_am_notified_of_a_successful_registration() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("A response is generated with the credentials I provided")
    public void a_response_is_generated_with_the_credentials_i_provided() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
