package com.grupo01.spring.cucumber.runners;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"}, features= {"classpath:features/Payment.feature"},
glue = {"com.grupo01.spring.cucumber.steps"})
public class Runner {
}

	

