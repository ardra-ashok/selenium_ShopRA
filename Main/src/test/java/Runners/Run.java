package Runners;




import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

//@CucumberOptions(
//        tags = {"@Regression","@Functional"},
//        features = "src/test/resources/basic.feature",
//        glue = {"StepDefinitions"}
//
//)


@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/basic.feature",
        glue = {"StepDefinitions/Steps"},
        tags = "@Regression"

)

public class Run {}
