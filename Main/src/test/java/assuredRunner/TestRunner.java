package assuredRunner;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/restAssuredFeatures/goRest.feature",
        glue = {"goRestDefs"}
)
public class TestRunner  extends AbstractTestNGCucumberTests {

}
