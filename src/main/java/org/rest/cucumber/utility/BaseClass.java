package org.rest.cucumber.utility;

import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {

	public static RequestSpecification req;
	public static ResponseSpecification res;
	public static Response resp;
	public static int statusCode;
	public static String place_id;
	public static String address;
	public static String msg;
	public static String status;
	public static String keyUrl = "qaclick123";

	public enum Utility {

		place_id(BaseClass.place_id);

		private String key;

		Utility(String key) {
			this.key = key;
		}

		public String getValue() {
			return this.key;
		}
	}

	public RequestSpecification ReqSpect() throws Exception {

		if (req == null) {
			PrintStream ps = new PrintStream(new FileOutputStream("log.txt"));
			req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.addQueryParam("key", keyUrl).addFilter(RequestLoggingFilter.logRequestTo(ps))
					.addFilter(ResponseLoggingFilter.logResponseTo(ps)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public ResponseSpecification respSpec(Response resp, int status) {
		res = new ResponseSpecBuilder().expectStatusCode(status).expectHeader("Server", "Apache/2.4.52 (Ubuntu)")
				.build();
		statusCode = resp.getStatusCode();
		return res;
	}

	public String getBodyValue(Response resp, String key) {

		String body = resp.then().extract().body().asString();
		JsonPath js = new JsonPath(body);
		
		String val = js.get(key);
		System.out.println(key + ": " + val);
		
		return val;
	}

}
