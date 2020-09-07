package com.cts.StepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import contextdto.ContextDI;

public class DeleteRequest {


	
	
	Scenario scn;
	
   ContextDI _CNTXT;
	
	public DeleteRequest(ContextDI cntxt) {
		this._CNTXT=cntxt;
	} 
	 
	@Before
	public void BeforeHook(Scenario s) {
		this.scn = s;
	}
	
	@Given("I have end point API URI")
	public void i_have_end_point_API_URI() {
	    
		RequestSpecification _REQS_SPEC =given().baseUri(_CNTXT.getBaseUri());
		_CNTXT.set_REQS_SPEC(_REQS_SPEC);
		scn.write("Base uri is " + _CNTXT.getBaseUri());
		
	}

	@When("I enter uri and submit")
	public void i_enter_uri_and_submit() {
		Response _RESP=_CNTXT.get_REQS_SPEC().delete("/api/users/2");
		_CNTXT.set_RESP(_RESP);
		scn.write("Uri entered is :"+_RESP.asString());
				
	}

	@Then("I should get {int} as response code")
	public void i_should_get_as_response_code(Integer int1) {
		ValidatableResponse _VALIDATABLE_RESP=_CNTXT.get_RESP().then().log().all();
		_CNTXT.set_VALIDATABLE_RESP(_VALIDATABLE_RESP);
		
		_CNTXT.get_VALIDATABLE_RESP().assertThat().statusCode(int1);
		
		scn.write("Status code :"+ _CNTXT.get_RESP().getStatusCode());
	}

	
}
