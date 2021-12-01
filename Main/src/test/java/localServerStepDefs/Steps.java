//package localServerStepDefs;
//
//import cucumber.api.DataTable;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.response.Response;
//import org.testng.Assert;
//// import restAssuredService.localService;
//
//
//
//import java.util.Map;
//
//public class Steps {
//
//
//
//    @Given("^I set the environment to local server$")
//    public void setEnvironment() {
//        localService.setEnvironment();
//
//    }
//
//    @Then("^I send a \"([^\"]*)\" API request with the following data$")
//    public void handlePostRequest(String method, Map<String,String> data)  {
//        // move the next line to service
//
//        Response response = localService.handlePostRequest(method,data);
//        Assert.assertEquals(response.path("title"),data.get("title"));
//    }
//
//    @Then("^I send a create post request with the following data to perform \"([^\"]*)\" Api request,and get gave a Not Found$")
//    public void handleDeletePost(String method, Map<String,String> data)  {
//        // move the next line to service
//
//        Response response = localService.handleDeleteRequest(method,data);
//        Assert.assertEquals(response.statusCode(),Integer.parseInt(data.get("responseCode")));
//    }
//
//
////    @Then("^I send a create post API request with the following data, and \"([^\"]*)\" with the updated title$")
////    public void handlePutRequest(Map<String,String> data)  {
////        Response response = localService.handlePutRequest(,data);
////        Assert.assertEquals(response.statusCode(),Integer.parseInt(data.get("responseCode")));
////    }
//
//
//
//
//
//}
