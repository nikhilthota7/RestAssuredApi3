package contextdto;

import cucumber.api.Scenario;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ContextDI {

	
	private String baseUri="https://reqres.in/";
	private RequestSpecification _REQS_SPEC;
	private Response _RESP;
	private ValidatableResponse _VALIDATABLE_RESP;
	private Scenario scn;
	public String getBaseUri() {
		return baseUri;
	}
	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}
	public RequestSpecification get_REQS_SPEC() {
		return _REQS_SPEC;
	}
	public void set_REQS_SPEC(RequestSpecification _REQS_SPEC) {
		this._REQS_SPEC = _REQS_SPEC;
	}
	public Response get_RESP() {
		return _RESP;
	}
	public void set_RESP(Response _RESP) {
		this._RESP = _RESP;
	}
	public ValidatableResponse get_VALIDATABLE_RESP() {
		return _VALIDATABLE_RESP;
	}
	public void set_VALIDATABLE_RESP(ValidatableResponse _VALIDATABLE_RESP) {
		this._VALIDATABLE_RESP = _VALIDATABLE_RESP;
	}
	public Scenario getScn() {
		return scn;
	}
	public void setScn(Scenario scn) {
		this.scn = scn;
	}
	
	
	
	
	
	
}
