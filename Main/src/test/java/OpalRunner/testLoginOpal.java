package OpalRunner;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/opalfeatures/OpalLogin.feature",
        glue = {"OpalSteps"}
)
public class testLoginOpal extends AbstractTestNGCucumberTests {


}
