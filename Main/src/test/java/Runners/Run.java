package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/login.feature",
        glue = {"StepDefinitions/Steps"}
)

public class Run extends AbstractTestNGCucumberTests {

}
