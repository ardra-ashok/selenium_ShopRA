//package reqResStepDefs;
//
//import assuredRunner.CucsParams;
//import cucumber.api.DataTable;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
////import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
////import restAssuredService.reqResServices;
//
//import java.util.ArrayList;
//import java.util.Map;
//
//public class Steps {
//    //change the endpoint to somewhere else
//
//
//    @Given("^reqRes API as the test rest API$")
//    public void setAPI(){
//       reqResServices.setAPI();
//    }
//
//    @When("^I want to \"([^\"]*)\" details of the user from \"([^\"]*)\"$")
//    public void handleGetRequest(String method,String endPoint) {
//        reqResServices.handleRequest(method,endPoint,"");
//    }
//
//    @Then("^I should get the response for \"([^\"]*)\" from Api$")
//    public void ApiResponse(String method){
//        reqResServices.checkApiResponse(method);
//    }
//
//    @When("^I want to \"([^\"]*)\" user from \"([^\"]*)\"$")
//    public void handleDeleteRequest(String method,String endPoint) {
//        reqResServices.handleRequest(method,endPoint,"");
//    }
//
//    @When("^I want to \"([^\"]*)\" users to \"([^\"]*)\"$")
//    public void handlePostRequest(String method, String endPoint,DataTable userDetails) {
//        for(Map<String, String> data: userDetails.asMaps(String.class,String.class)){
//            String body = reqResServices.convertJson(data);
//            reqResServices.handleRequest(method,endPoint,body);
//        }
//
//
//    }
//    @When("^I want to \"([^\"]*)\" user details in \"([^\"]*)\"$")
//    public void handlePutRequest(String method, String endPoint,DataTable userDetails)  {
//        for(Map<String, String> data: userDetails.asMaps(String.class,String.class)){
//            String body = reqResServices.convertJson(data);
//            reqResServices.handleRequest(method,endPoint,body);
//        }
//    }
//
//    @When("^I want to get user details from \"([^\"]*)\"$")
//    public void i_want_to_user_details_from( String endPoint, DataTable userIdTable)  {
//        for(Map<String, String> data: userIdTable.asMaps(String.class,String.class)){
//            reqResServices.handleSingleGetRequest(endPoint,data.get("id"));
//        }
//    }
//
//    @When("^I want to \"([^\"]*)\" users in \"([^\"]*)\"$")
//    public void addUserDataProvider(String method, String endPoint)  {
//            String body = reqResServices.convertJson(CucsParams.dataMap);
//            reqResServices.handleRequest(method, endPoint, body);
//
//    }
//
//
//
//
//
//}
