package dbRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/dbFeatures",
        glue = {"dbSteps"}
)


public class dbRunner extends AbstractTestNGCucumberTests{
}
