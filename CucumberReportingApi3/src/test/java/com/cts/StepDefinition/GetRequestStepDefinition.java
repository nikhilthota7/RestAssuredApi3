package com.cts.StepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import contextdto.ContextDI;

public class GetRequestStepDefinition {
	String baseUri = "https://reqres.in/";
	
	ValidatableResponse _VALIDATABLE_RESP;
	Scenario scn;
	ContextDI _CNTXT;

	public GetRequestStepDefinition(ContextDI cntxt) {
		this._CNTXT = cntxt;

	}

	@Before
	public void BeforeHook(Scenario s) {
		this.scn = s;
	}

	@Given("I have an endpointApi")
	public void i_have_an_endpointApi() {
		RequestSpecification _REQS_SPEC = given().baseUri(baseUri);
		_CNTXT.set_REQS_SPEC(_REQS_SPEC);
		scn.write("Baseuri is :" + baseUri);
	}

	@When("I submit the Get request")
	public void i_submit_the_Get_request() {
		Response _RESP = _CNTXT.get_REQS_SPEC().get("/api/users/2");
		_CNTXT.set_RESP(_RESP);
		scn.write("Endpoint Response Body is :" +_CNTXT.get_RESP().asString());
	}

	@Then("I should get status code as {int}")
	public void i_should_get_status_code_as(Integer int1) {

		ValidatableResponse _VALIDATABLE_RESP =_CNTXT.get_RESP().then().assertThat().statusCode(int1);
		scn.write("Status code from response is :" + _CNTXT.get_RESP().getStatusCode());

		_VALIDATABLE_RESP.log().all();
		JsonPath path = new JsonPath(_CNTXT.get_RESP().then().extract().asString());
		scn.write("I d from response :" + path.get("data.id"));
		scn.write("email from response :" + path.get("data.email"));

	}

	@Then("the response should contain the id as {int} and email as {string}")
	public void the_response_should_contain_the_id_as_and_email_as(Integer int1, String string) {

		_VALIDATABLE_RESP = _CNTXT.get_RESP().then().assertThat();
		_VALIDATABLE_RESP.body("data.id", equalTo(int1));
		_VALIDATABLE_RESP.body("data.email", equalTo(string));
		scn.write("Email from response is :" + string);

	}

}
