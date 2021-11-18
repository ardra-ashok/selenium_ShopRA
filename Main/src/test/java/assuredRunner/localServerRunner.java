package assuredRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/restAssuredFeatures/localServer.feature",
        glue = {"localServerStepDefs"}
)
public class localServerRunner  extends AbstractTestNGCucumberTests {

}
