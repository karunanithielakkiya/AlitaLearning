package org.epam.learn.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/resources/features/"},
            glue = {"org.epam.learn.stepdefinition"},
            plugin = {"pretty", "html:target/cucumber-reports.html"}
    )

    public class TestRunner {

    }
