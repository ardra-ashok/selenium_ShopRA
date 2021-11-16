package reqResStepDefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import restAssuredService.reqResService;

import java.util.List;

public class Steps {

    @Given("^reqRes API as the rest API$")
    public void setAPI(){
       reqResService.setAPI();
    }

    @When("^I hit the api with get request and end point as \"([^\"]*)\",API returns all the users$")
    public void ApiReturnAllUsers(String endPoint) throws Throwable {
        reqResService.getAllUsers(endPoint);
    }

    @When("^I hit the api with get request and end point as \"([^\"]*)\",API returns single user with id as <(\\d+)>$")
    public void ApiReturnUserMatchingId(String endPoint,int id){
        reqResService.getUserMatchingId(endPoint,id);
    }
    @When("^I hit the api with get request and end point as \"([^\"]*)\",and select page <(\\d+)>$")
    public void ApiReturnSinglePageData(String endPoint,int pageId){
        reqResService.getSinglePageData(endPoint,pageId);
    }

    @When("^I hit the api with get request and end point as \"([^\"]*)\",API should return user not found response for wrong id$")
    public void ApiReturningErrorResponse(String endPoint){
        reqResService.getErrorResponseForWrongUser(endPoint);
    }

    @When("^I hit the api with \"([^\"]*)\" with the following data$")
    public void AddUpdateOrEditUserDetailsOnApi(String method){
        reqResService.addUpdateOrEditUser(method);
    }
}
