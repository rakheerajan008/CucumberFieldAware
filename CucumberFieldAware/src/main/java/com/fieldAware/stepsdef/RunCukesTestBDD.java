package com.fieldAware.stepsdef;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"progress", "html:target/cucumber-html-report"},
features = "src/test/java")
public class RunCukesTestBDD {

}
