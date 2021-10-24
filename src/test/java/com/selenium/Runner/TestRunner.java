package com.selenium.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
glue= {"com.selenium.StepDefinitions"},
//dry run - true checks if all the steps are defined in the step definition file
//dry run - false is default value taken and runs total code
dryRun = false,
//monochorme - false is default value and should be true enabled to true to see proper log format in the console output
monochrome = true,
plugin= {"html:target/html/cucumber-html-report","json:target/json/cucumber.json",
		 "pretty:target/pretty/cucumber-pretty.txt",
		 "junit:target/junit/cucumber-junit.xml"},
//strict - by default true value is taken, if false is given test excutes
//all the steps without fail even if some steps arenot defined
strict = true)
//tags = {"~@SmokeTest","~@Regression"})

/*Cucumber options
dryRun
features
glue
tags
monochrome
format - updated to plugin
strict*/
public class TestRunner extends AbstractTestNGCucumberTests{
//public class TestRunner {
	

}

/*Tags - similar to groups in testNG
{"@SmokeTest,@Regression"} - OR condition
{"@SmokeTest","@Regression"} - AND condition
{"~@SmokeTest","@Regression"} -  '~' - used as not operator - only regression tests gets executed and not smoke anymore*/
