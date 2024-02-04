package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src\\test\\java\\featureFiles", 
glue = "stepDefinitions", 
plugin= {"html:target/cucumber.html", "pretty", "json:target/cucumber.json"}, 
monochrome = true, 
dryRun = false,
tags="@check_links"
)
public class testRunnerTestNG extends AbstractTestNGCucumberTests {

}
