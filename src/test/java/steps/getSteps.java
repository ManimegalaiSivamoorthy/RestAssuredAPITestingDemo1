package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.Posts;
import utilities.RestAssuredExtension;


import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class getSteps {

    private static ResponseOptions<Response> response;

    //Scenario: Verify one name of the customer profile
    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void i_perform_GET_operation_for(String url) {
        response = RestAssuredExtension.getOps(url);
    }

    @Then("^I should see the customer name as \"([^\"]*)\"$")
    public void i_should_see_the_author_name_as(String name) {
        var posts = response.getBody().as(Posts.class);
        assertThat(posts.getName(), equalTo(name));
        //assertThat(response.getBody().jsonPath().get("name"), is(name));
    }
}
