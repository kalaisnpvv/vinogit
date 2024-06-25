package org.rest.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/org/rest/cucumber/feature", glue = {
		"org.rest.cucumber.stepDef" }, plugin = "json:target/jsonReports/cucumber-report.json")
public class TestRunner {

}
