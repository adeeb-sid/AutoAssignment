package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"classpath:stepDefinitions"},
        //tags = {"@Login"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class TestRunner extends AbstractTestNGCucumberTests  {
	
}
