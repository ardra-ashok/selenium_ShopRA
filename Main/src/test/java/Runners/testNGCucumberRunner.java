package Runners;



import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;



@CucumberOptions(
        features = "src/test/resources",
        glue = {"StepDefinitions"}
)

@Test
public class testNGCucumberRunner  {
}
