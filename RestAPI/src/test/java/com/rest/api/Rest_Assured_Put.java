package com.rest.api;

import org.testng.annotations.Test;
import com.api.model.Employee;
import com.rest.assured.model.EmployeeModel;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class Rest_Assured_Put extends EmployeeModel {

	@Test(enabled =  true)
	public void updateemployee() {
		int id = fake.number().numberBetween(1, 25);
		Employee emp = updateexistingemployee(id);

		System.out.println("------Before Update------");
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("data/"+id)
		.then()
		.assertThat()
		.statusCode(200)
		.log().all(); 

		System.out.println("------After Update------");
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("Content-Type","application/json")
		.body(emp)
		.when()
		.put("data/"+id)
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}
}
