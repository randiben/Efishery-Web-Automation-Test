package com.saucedemo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = "src/test/resources/features",
glue="com.saucedemo",
plugin = {"pretty",
		"html:target/demosauce-reports/login-scenario.html",
		})

public class RunnerFiles extends AbstractTestNGCucumberTests {

}
