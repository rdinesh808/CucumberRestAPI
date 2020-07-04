package com.api.base;

import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;

public class ApiBase {

	public Faker fake = new Faker();

	//	public ApiBase() {
	//		try {
	//			baseURI = "http://dummy.restapiexample.com/api";
	//		}catch (Exception e) {
	//			System.out.println(e.getMessage());
	//		}
	//	}
	@BeforeClass
	public void setup() {
		try {
//			String basePath = System.getProperty("http:");
//			if(basePath==null){
//				baseURI = "http://google.com";
//			}else {
//				RestAssured.basePath = basePath;
//			}

			String baseHost = System.getProperty("server.host");
			if(baseHost==null){
				baseHost = "http://localhost";
			}else {
				RestAssured.baseURI = baseHost;
			}

			String port = System.getProperty("server.port");
			if (port == null) {
				RestAssured.port = Integer.valueOf(3000);
			}
			else{
				RestAssured.port = Integer.valueOf(port);
			}

		}catch (Exception e) {
			System.out.println(e.getCause());
		}
	}
}