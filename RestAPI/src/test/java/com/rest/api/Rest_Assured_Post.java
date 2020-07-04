package com.rest.api;

import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;
import org.testng.annotations.*;
import com.api.base.Payload;
import com.api.model.Employee;
import com.rest.assured.model.EmployeeModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Rest_Assured_Post extends EmployeeModel {

	// given() --- all input details
	// when() --- submit the API
	// then() --- validate the response

	@Test(enabled = true)
	public void Post_01() {
		int id = fake.number().numberBetween(26, 100);
		Employee emp = generatenewemployee(id);
		String res = given()
		.log()
		.all()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("Content-Type","application/json")
		.body(emp)
		.when()
		.post("data")
		.then()
		.assertThat()
		.statusCode(201)
		//.body("data.id", hasItem(id))
		.log()
		.all()
		.extract()
		.response()
		.asString();
		
		JsonPath js = new JsonPath(res);
		String s1 = js.getString("employee_name");
		System.out.println("Name is : " + s1);
	}




	//	@Test
	//	public void RA_get_01() {
	//		
	//		JSONObject obj = new JSONObject();
	//		obj.put("title", "API");
	//		obj.put("author", "REST");
	//		
	//		RestAssured.baseURI = "http://localhost:3000/";
	//		String responce = given()
	//		.log()
	//		.all()
	//		//.queryParams("id", "2")
	//		.header("Content-Type", "application/json")
	//		.body(obj.toJSONString())
	//		.when()
	//		.post("/posts")
	//		.then()
	//		.assertThat()
	//		.statusCode(201)
	//		.log()
	//		.all()
	//		.body("author", equalTo("REST"))
	//		.header("Expires", equalTo("-1"))
	//		.header("Connection", "keep-alive")
	//		.extract()
	//		.response()
	//		.asString();
	//		System.out.println(responce);
	//		JsonPath jp = new JsonPath(responce);
	//		String s1 = jp.getString("place_id");
	//		System.out.println(s1);
	//	}
}