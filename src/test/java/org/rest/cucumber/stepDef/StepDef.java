package org.rest.cucumber.stepDef;

import org.rest.cucumber.resources.APIResources;
import org.rest.cucumber.resources.TestDataPayload;
import org.rest.cucumber.utility.BaseClass;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

import io.cucumber.java.en.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDef extends BaseClass {

	TestDataPayload payload = new TestDataPayload();
	APIResources res;
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;

	@Given("{string} API request sent with body as {string} {string} {string}")
	public void api_request_sent_with_body_as(String method, String para1, String para2, String para3)
			throws Exception {

		switch (method) {
		case "Add":
			reqSpec = given().spec(ReqSpect()).body(payload.testDataA(para1, para2, para3));
			break;

		case "Update":
			reqSpec = given().spec(ReqSpect()).body(payload.testDataU(place_id, para2, keyUrl));
			break;
			
		case "Delete":
			reqSpec = given().spec(ReqSpect()).body(payload.testDataD(place_id));
			break;
			
		default:
			System.out.println("No option found for " + method);
			break;
		}

	}

	@When("Resource URL sent for {string} using http method as {string}")
	public void resource_url_sent_for_using_http_method_as(String resource, String method) {

		res = APIResources.valueOf(resource);
		System.out.println(res.setResource());

		if (method.equalsIgnoreCase("POST"))
			resp = reqSpec.when().post(res.setResource());
		else if (method.equalsIgnoreCase("GET"))
			resp = reqSpec.when().get(res.setResource());
		else if (method.equalsIgnoreCase("PUT"))
			resp = reqSpec.when().put(res.setResource());
		else if (method.equalsIgnoreCase("DELETE"))
			resp = reqSpec.when().delete(res.setResource());

	}

	@Then("Verify the Status code is {int}")
	public void verify_the_status_code_is(int statusCode) {
		resSpec = respSpec(resp, statusCode);
		Assert.assertEquals(BaseClass.statusCode, statusCode);
	}

	@Then("Get {string} from the Response Body")
	public void get_from_the_response_body(String key) {

		switch (key) {
		case "place_id":
			place_id = getBodyValue(resp, key);
			break;

		case "address":
			address = getBodyValue(resp, key);
			break;

		case "msg":
			msg = getBodyValue(resp, key);
			break;
			
		case "status":
			status = getBodyValue(resp, key);
			break;

		default:
			System.out.println("No option found for " + key);
			break;
		}

	}

	@When("API request sent with parameter as {string}")
	public void api_request_sent_with_parameter_as(String param) throws Exception {

		Utility util = Utility.valueOf(param);
//		System.out.println(param + ": " + util.getValue());

		reqSpec = given().spec(ReqSpect()).queryParam(param, util.getValue());

	}

	@Then("Verify {string} and {string} were same")
	public void verify_and_were_same(String actual, String expected) throws Exception {

		switch (actual) {
		case "address":
			actual = address;
			break;

		case "msg":
			actual = msg;
			break;

		case "status":
			actual = status;
			break;
			
		default:
			System.out.println("No option found for " + actual);
			break;

		}

		Assert.assertEquals(actual, expected);
	}

}
