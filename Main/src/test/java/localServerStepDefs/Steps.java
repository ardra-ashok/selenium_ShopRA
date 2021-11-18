package localServerStepDefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import restAssuredService.localService;


import java.util.HashMap;
import java.util.Map;

public class Steps {


    @Given("^I set the environment to local server$")
    public void setEnvironment() {
        localService.setEnvironment();

    }

    @Then("^I send a \"([^\"]*)\" API request with the following data$")
    public void handleRequest(String endPoint, DataTable posts)  {
        String urlEndPoint = localService.setRequest(endPoint,posts);
        for(Map<String, String> data: posts.asMaps(String.class,String.class)){
            HashMap<String, String> body = localService.getBody(data);
            String ResponseCode = localService.getResponseCode(data);
            String bodyData = localService.convertJson(body);
            localService.handleRequest(endPoint,urlEndPoint,bodyData,ResponseCode);
        }

    }
}
