package Runners;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CucumberOptions(
        features = "src/test/resources",
        glue = {"StepDefinitions"}

)


public class cucumberDataProvider {
    private TestNGCucumberRunner testNGCucumberRunner;


    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "LogData",dataProviderClass=dataProvider.class)
    public void runCucumberForTestNG(String email,String password){
        HashMap<String,String> data = new HashMap<>();
        data.put(email,password);
        CucumberParams.addToMap(data);
        //        List<String> data = new ArrayList<>();
        //        CucumberParams.addToList(email);

        for(CucumberFeature feature: testNGCucumberRunner.getFeatures()){
            testNGCucumberRunner.runCucumber(feature);
        }

    }




@AfterClass(alwaysRun = true)
    public void tearDownClass() {

        testNGCucumberRunner.finish();
    }
}
