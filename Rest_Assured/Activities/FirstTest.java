package Examples;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {
	@Test(priority = 1)
	public void getRequestWithQueryparam() {
		//send request & save response
		Response respone = 
				given()
				    .baseUri("https://petstore.swagger.io/v2/pet")
				    .header("Content-Type", "application/json")
				    .queryParam("status","alive")
			  	.when()
			  	    .get("/findByStatus");
		

		//print response headers
		System.out.println(respone.getHeaders());
		//print the response body
		System.out.println(respone.getBody().asString());
		System.out.println(respone.getBody().asPrettyString());
		// extract values from response
		String petStatus =respone.then().extract().path("[0].status");
		//TestNG Assertions
		Assert.assertEquals(petStatus, "alive");
		
		//Restassured asertion
		respone.then().statusCode(200).body("[0].status", equalTo("alive"));
		
	}
	@Test(priority = 2)
	public void getRequestWithPathparam() {
		given()
	      .baseUri("https://petstore.swagger.io/v2/pet")
	      .header("Content-Type", "application/json")
	      .pathParam("petId", 77232)
	      .log().all()
	   .when()
	      .get("/{petId}")
	   .then()
	      .statusCode(200)
	      .body("name", equalTo("Riley"))
	      .body("status", equalTo("alive"))
	      .log().all();
		
	}

}
