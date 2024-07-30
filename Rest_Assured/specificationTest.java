package Examples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import java.util.HashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class specificationTest {

		RequestSpecification requestspec;
		ResponseSpecification responsespec;
		int petId;
		@BeforeClass
		public void setUp() {
			//Request specification
			requestspec = new RequestSpecBuilder().
					setBaseUri("https://petstore.swagger.io/v2/pet").
					addHeader("Content-Type", "application/json").
					build();
			//RESPONSE Specification
			responsespec = new ResponseSpecBuilder().
					expectStatusCode(200).
				//	expectBody("status", equalTo("alive")).--->if it is there delete step will fail
					expectResponseTime(lessThanOrEqualTo(3000L))
					.build();
			
		}
		@Test(priority = 1)
		public void postRequest() {
			//Create request body
			Map<String, Object> reqBody = new HashMap<String, Object>();
			reqBody.put("id", 12345);
			reqBody.put("name", "Rocky");
			reqBody.put("status", "alive");
			//send request & save response
			Response response = 
					given().spec(requestspec).body(reqBody).
					when().post();
			//Extract Id from the response
			petId =response.then().extract().path("id");
			//Assertions 
			response.then().spec(responsespec).
			body("name", equalTo("Rocky")).
			body("status", equalTo("alive"));
			
		}
		@Test(priority = 2)
		public void getRequest() {
			//Send request, get request, assert response
			given().spec(requestspec).pathParam("petId",petId).
			when().get("/{petId}").then().
			spec(responsespec).body("status", equalTo("alive"));
			
		}
		@Test(priority = 3)
		public void delRequest() {
			given().spec(requestspec).pathParam("petId",petId).
			when().delete("/{petId}").then().
			spec(responsespec).body("message", equalTo(""+petId));
			
		}

	}

