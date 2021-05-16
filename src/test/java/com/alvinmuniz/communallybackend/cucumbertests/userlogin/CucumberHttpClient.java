package com.alvinmuniz.communallybackend.cucumbertests.userlogin;

import com.alvinmuniz.communallybackend.models.User;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CucumberHttpClient {

    private final String BASE_URL = "/auth/users";

    @LocalServerPort
    private int randomServerPort;

    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    public String getRequest(String endPoint) {
        return "http://localhost:" + randomServerPort + BASE_URL+"/" + endPoint;
    }

    public ResponseEntity<?> returnGetRequestResults(String uri){
        ResponseEntity<User> result = this.testRestTemplate.getForEntity(uri,
                User.class);
        return result;
    }

    public ResponseEntity<User> returnPostRequestResults(String uri, User user){
        ResponseEntity<User> response = this.testRestTemplate.postForEntity(uri
                , user,
                User.class);
        return response;
    }



}
