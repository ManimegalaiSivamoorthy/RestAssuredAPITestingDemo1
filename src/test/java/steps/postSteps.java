package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class postSteps {
    private static ResponseOptions<Response> response;

    @Given("^I Perform POST operation for \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationForWithBody(String url, DataTable table) {
        var data = table.raw();

        //set body
        HashMap<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("name", data.get(1).get(1));
        body.put("age", data.get(1).get(2));
        body.put("character",data.get(1).get(3));

        //perform post operation
        response = RestAssuredExtension.postOpsWithBodyAndPathParams(url, body);
    }

    @Then("^I should see the body has id as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyHasIdAs(String id) throws Throwable {
        assertThat(response.getBody().jsonPath().get("id_created"), equalTo(id));
    }

    @And("^I Perform PUT operation for \"([^\"]*)\"$")
    public void iPerformPUTOperationFor(String url, DataTable table) {
        var data = table.raw();

        //set body
        HashMap<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("name", data.get(1).get(1));
        body.put("age", data.get(1).get(2));
        body.put("character",data.get(1).get(3));

        //pathParams
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("id", data.get(1).get(0));

        response = RestAssuredExtension.putOpsWithBodyAndPathParams(url, pathParams, body);
    }

}
