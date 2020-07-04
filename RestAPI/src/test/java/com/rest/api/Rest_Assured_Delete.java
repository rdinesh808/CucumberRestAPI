package com.rest.api;

import com.api.base.ApiBase;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

public class Rest_Assured_Delete extends ApiBase {
	
	@Test(enabled = true)
	public void Delete_01() {
		given()
		.when()
		.delete("data/25")
		.then()
		.statusCode(200)
		.log()
		.all();
	}

}
