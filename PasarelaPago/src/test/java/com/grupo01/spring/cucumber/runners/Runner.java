package com.grupo01.spring.cucumber.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"}, 
features= {"classpath:features/Payment.feature"},
glue = {"com.grupo01.spring.cucumber.steps"})
public class Runner {
}

	




