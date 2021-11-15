package restAssuredStepDefs;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import restAssuredService.Services;

public class Steps {
    private static Services service;

    public Steps(){
        this.service = new Services();
    }

    @Given("^Go rest API is up and running$")
    public void go_rest_API_is_up_and_running(){
        service.getRestApiRunning();
    }

    @When("^I hit the api with get request and end point as \"([^\"]*)\"$")
    public void i_hit_the_api_with_get_request_and_end_point_as(String endPoint){

        service.hitEndpointGet(endPoint);
    }

    @Then("^API should return all the users$")
    public void api_should_return_all_the_users(){
        service.returnAllUsers();
    }



    @Then("^API should return user details of user id \"([^\"]*)\"$")
    public void api_should_return_user_details_of_user_id(String userId){
        service.returnSingleUser(userId);
    }

    @Then("^API should return user not found response for id \"([^\"]*)\"$")
    public void api_should_return_user_not_found_response_for_id(String userId) throws Throwable {
        service.userWrongId(userId);
    }
    @When("^I hit the api with post request and end point as \"([^\"]*)\"$")
    public void i_hit_the_api_with_post_request_and_end_point_as(String endPoint){
        service.hitEndpointPost(endPoint);

    }

    @Then("^I set header and body to create new user$")
    public void i_set_header_and_body_to_create_new_user() {
        service.setHeaderAndContent();
    }





    @Then("^API created a new User in the system$")
    public void api_created_a_new_User_in_the_system()  {
        service.newUserCheckInSystem();
    }

    @Then("^I can find the new user in the system when i get the user$")
    public void i_can_find_the_new_user_in_the_system_when_i_get_the_user() {

    }

    @Given("^I set header and but with out any body$")
    public void i_set_header_and_but_with_out_any_body() {

    }

    @Then("^API returned the error code as (\\d+)$")
    public void api_returned_the_error_code_as(int arg1) {

    }

    @Then("^error message displayed as \"([^\"]*)\"$")
    public void error_message_displayed_as(String arg1) {

    }


    @When("I hit the api with delete request")
    public void i_hit_the_api_with_delete_request() {
        String userId = "2088";
        service.deleteUser(userId);

    }


    @Then("get request to the user should not return the user")
    public void get_request_to_the_user_should_not_return_the_user() {
        String userId ="2088";
        service.confirmDelete(userId);
    }

    @When("I hit the api with patch request to update the existing user details")
    public void i_hit_the_api_with_patch_request_to_update_the_existing_user_details() {
        String newUserID = "47";
        service.updateExistingUser(newUserID);

    }
    @Then("^API should update the user$")
    public void api_should_update_the_user() throws Throwable {
        service.shouldUpdateUser();
    }

    @When("^I hit the api with put request to update the existing user details$")
    public void updateExistingUser(){

    }







}
