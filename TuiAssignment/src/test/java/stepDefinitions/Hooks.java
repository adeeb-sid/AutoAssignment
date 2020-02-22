package stepDefinitions;

import com.auto.page.InitializePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends InitializePage{
	
	@Before
    public void beforeScenario(Scenario scenario){
       setUp(scenario);
    } 
 
	@After
    public void afterScenario(Scenario scenario){
        tearDown(scenario);
    }

}
