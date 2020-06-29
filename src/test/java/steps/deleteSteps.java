package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;
import utilities.RestAssuredExtension;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

public class deleteSteps {

    private static ResponseOptions<Response> response;

    @Given("^I ensure to Perform POST operation for \"([^\"]*)\" with body as$")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url, DataTable table) throws Throwable {
        var data = table.raw();

        //set body
        HashMap<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("name", data.get(1).get(1));
        body.put("age", data.get(1).get(2));
        body.put("character",data.get(1).get(3));

        response = RestAssuredExtension.postOpsWithBody(url, body);
    }

    @And("^I Perform DELETE operation for \"([^\"]*)\"$")
    public void iPerformDELETEOperationFor(String url, DataTable table) {
        var data = table.raw();

        //set body
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("id", data.get(1).get(0));

        response = RestAssuredExtension.deleteOpsWithPathParams(url, pathParams);
    }

    @And("^I perform GET operation with path parameter for \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterFor(String url, DataTable table) {
        var data = table.raw();

        //set pathParams
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("id", data.get(1).get(0));

        response = RestAssuredExtension.getWithPathParams(url, pathParams);
    }

    @Then("^I should see the body with customer name as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyWithCustomerNameAs(String name) {
        assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
    }

    @Then("^I should not see the body with customer name as \"([^\"]*)\"$")
    public void iShouldNotSeeTheBodyWithCustomerNameAs(String name) {
        assertThat(response.getBody().asString(), is(emptyString()));
    }
}
