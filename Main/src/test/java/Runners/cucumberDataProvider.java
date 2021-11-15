package Runners;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepDefs"}

)


public class cucumberDataProvider {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "LogData",dataProviderClass=dataProvider.class)
    public void runCucumberForTestNG(String email,String password){
        CucumberParams.dataMap.put("email",email);
        CucumberParams.dataMap.put("password",password);
        for(CucumberFeature feature: testNGCucumberRunner.getFeatures()){
            testNGCucumberRunner.runCucumber(feature);
        }
    }
@AfterClass(alwaysRun = true)
    public void tearDownClass() {

        testNGCucumberRunner.finish();
    }


}
