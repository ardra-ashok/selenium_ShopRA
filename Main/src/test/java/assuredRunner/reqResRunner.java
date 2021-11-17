package assuredRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
        features = "src/test/resources/restAssuredFeatures/reqRes1.feature",
        glue = {"reqResStepDefs"}
)
public class reqResRunner extends AbstractTestNGCucumberTests {

}


