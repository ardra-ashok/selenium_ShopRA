package dbSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import services.DBServices;

import java.util.List;
import java.util.Map;

public class Steps {




    public Steps(){}


    @Given("^I set the test environment to \"([^\"]*)\"$")
    public void i_set_the_test_environment_to(String arg1){

    }

    @Given("^I get the current date with format \"([^\"]*)\" and save as \"([^\"]*)\"$")
    public void i_get_the_current_date_with_format_and_save_as(String arg1, String arg2)  {

    }

    @When("^I run a DB query with the following and save the result in variable \"([^\"]*)\"$")
    public void i_run_a_DB_query_with_the_following_and_save_the_result_in_variable(String arg1, DataTable dataTable) {
        List<Map<String, String>> queryData =  dataTable.asMaps(String.class, String.class);

        if (!queryData.get(0).containsKey("OPERATOR") || !queryData.get(0).containsKey("OPERAND"))
            System.out.println("Query data must include [OPERATOR] and [OPERAND]");

        String result = DBServices.runParametricDBQuery(queryData);
        System.out.println(result);


    }

    @Then("^I assert the query results saved in variable \"([^\"]*)\" with following$")
    public void i_assert_the_query_results_saved_in_variable_with_following(String arg1, DataTable arg2) throws Throwable {

    }


}
