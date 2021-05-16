package com.alvinmuniz.communallybackend.cucumber;

//https://thepracticaldeveloper.com/cucumber-tests-spring-boot-dependency
// -injection/#entry-point-runwith-cucumber


import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

//https://thepracticaldeveloper.com/cucumber-tests-spring-boot-dependency
// -injection/#entry-point-runwith-cucumber


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {
}
