package com.rest.api;

import io.restassured.http.ContentType;
import org.testng.annotations.*;
import com.api.base.ApiBase;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.*;
import java.util.Random;

public class Rest_Assured_Get extends ApiBase {

	@Test(enabled = false)
	public void a_print_json() {
		try {
			FileOutputStream fos = new FileOutputStream(new File("./Json/JsonData.json"));
			String res = given()
					.contentType(ContentType.JSON)
					.when()
					.get("/v1/employees")
					.then()
					.statusCode(200)
					.log()
					.all()
					.extract()
					.response()
					.asString();
			byte b[] = res.getBytes();
			fos.write(b);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled = false)
	public void get_01() {
		given().log().all()
		.contentType(ContentType.JSON)
		.when()
		.get("/v1/employees")
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}

	@Test(enabled = false)
	public void get_02() {
		given().log().all()
		.contentType(ContentType.JSON)
		.when()
		.get("/v1/employees")
		.then()
		.assertThat()
		.statusCode(200)
		.body("data.employee_name", hasItem("Paul Byrd"))
		.log()
		.all();
	}

	@Test(enabled = false)
	public void get_03() {
		given().log().all()
		.contentType(ContentType.JSON)
        .when()
        .get("v1/employees")
        .then()
        .assertThat()
        .statusCode(200)
        .body("data.employee_name[21]", equalTo("Yuri Berry"))
        .log()
        .all();
	}
	
	@Test(enabled = false)
	public void get_04() {
		int a = new Random().nextInt(23);
		given()
		.log()
		.all()
		.get("data/"+a)
		.then()
		.log()
		.all();
	}

	@Test(enabled = true)
	public void get_05() {
		int a = new Random().nextInt(23);
		given()
		.param("id",a)
		.log()
		.all()
		.get("data")
		.then()
		.log()
		.all();
	}
}