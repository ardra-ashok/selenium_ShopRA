package Runners;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

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

    @Test(dataProvider = "features")
    public void runPickle(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {

        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] features() {
        Object[][] data = testNGCucumberRunner.provideScenarios();
        PickleWrapper wrapper = (PickleWrapper)data[0][0]; // scenario name
        FeatureWrapper fW = (FeatureWrapper)data[0][1]; // feature name
        System.out.println(wrapper.getPickle().);
        System.out.println(wrapper.toString());
        System.out.println(fW.toString());
       return testNGCucumberRunner.provideScenarios();
    }

//    private void filterTheScenario(Object[][] data) {
//
//
//    }


@AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
