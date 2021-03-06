package com.alvinmuniz.communallybackend.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        features = "classpath:features",
        extraGlue = "com.alvinmuniz.communallybackend.cucumbertests"
)
public class RunCucumberTest {
}
