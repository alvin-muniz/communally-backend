package com.alvinmuniz.communallybackend.cucumbertests.util;

import com.alvinmuniz.communallybackend.models.Login.LoginRequest;
import com.alvinmuniz.communallybackend.models.Login.LoginResponse;
import com.alvinmuniz.communallybackend.models.Session;
import com.alvinmuniz.communallybackend.models.User;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class CucumberHttpClient {

    private final String BASE_URL = "/auth/users";
    private final String SESSION_URL = "api/sessions";

    @LocalServerPort
    private int randomServerPort;

    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    public ResponseEntity<?> returnPostRequestResults(String uri, User user){

        ResponseEntity<?> response =
                this.testRestTemplate.postForEntity("http://localhost:" + randomServerPort + BASE_URL + "/" + uri, user, User.class);

        return response;
    }

    public ResponseEntity<?> returnSessionPostResults(String uri,
                                                      Session session,
                                                      String token)
    {
        // create headers
        HttpHeaders headers = new HttpHeaders();
// set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
// set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Object> map = new HashMap<>();
        map.put("Authorization", "Bearer " + token);
        map.put("body", session);

        ResponseEntity<?> response =
                this.testRestTemplate.postForEntity("http://localhost:" + randomServerPort + SESSION_URL, headers, Session.class);

        System.out.println(response.getBody());
        Session foundSession = (Session) response.getBody();
        System.out.println(foundSession.toString());

        return response;

    }

    public ResponseEntity<?> returnLoginRequestResults(String uri
            , LoginRequest loginRequest) {
        ResponseEntity<?> response =
                this.testRestTemplate.postForEntity("http://localhost:" + randomServerPort + BASE_URL + "/" + uri, loginRequest, LoginResponse.class);
        System.out.println(response.getBody().getClass());
        LoginResponse fondResponse = (LoginResponse) response.getBody();
        System.out.println(fondResponse.getJwt());
        return response;
    }






}
