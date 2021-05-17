package com.alvinmuniz.communallybackend.cucumbertests.userlogin;

import com.alvinmuniz.communallybackend.models.Login.LoginRequest;
import com.alvinmuniz.communallybackend.models.Login.LoginResponse;
import com.alvinmuniz.communallybackend.models.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;

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
    User responseUser;
    LoginRequest loginRequest = new LoginRequest();



    /***
     * Checks if access to "auth/users/register" is 200 status"
     */
    @Given("I am a visitor to your site accessing \\/register end point")
    public void i_am_a_visitor_to_your_site_accessing_register_end_point() {
        user.setEmailAddress("user@email.com");
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
        responseUser = (User) response.getBody();
        assertNotNull(responseUser.getId());
        assertEquals(user.getUsername(), responseUser.getUsername());
        assertEquals(user.getEmailAddress(), responseUser.getEmailAddress());
    }


    @Given("I am a user who has registered")
    public void i_am_a_user_who_has_registered() {
        user.setEmailAddress("user@email.com");
        user.setUsername("testUser");
        user.setPassword("123456");
        loginRequest.setEmailAddress(user.getEmailAddress());
        loginRequest.setPassword(user.getPassword());

        response = userHttpClient.returnLoginRequestResults("login",
                loginRequest);
        assertNotNull(response);

    }


    @When("I send a login request with my login credentials")
    public void i_send_a_login_request_with_my_login_credentials() {
        assertEquals(200,response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }
    @Then("I receive a valid JWT token in response to authenticate me in the database")
    public void i_receive_a_valid_jwt_token_in_response_to_authenticate_me_in_the_database() {
        // Write code here that turns the phrase above into concrete actions
        LoginResponse foundRespone = (LoginResponse) response.getBody();
        assertNotNull(foundRespone.getJwt());

    }


}
