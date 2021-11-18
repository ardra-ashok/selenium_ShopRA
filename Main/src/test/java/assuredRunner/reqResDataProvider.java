package assuredRunner;

import Runners.CucumberParams;
import Runners.dataProvider;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/restAssuredFeatures/reqResDataProvider.feature",
        glue = {"reqResStepDefs"}

)
public class reqResDataProvider {
        private TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass(alwaysRun = true)
        public void setUpCucumber() {
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        @Test(dataProvider = "userData", dataProviderClass = DataProviderUser.class)
        public void runCucumberForTestNG(String name,String job) {

            CucsParams.dataMap.put("name",name);
            CucsParams.dataMap.put("job",job);
            for (CucumberFeature feature : testNGCucumberRunner.getFeatures()) {
                testNGCucumberRunner.runCucumber(feature);
            }
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() {

            testNGCucumberRunner.finish();
        }

    }

