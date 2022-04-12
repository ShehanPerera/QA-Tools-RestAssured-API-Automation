package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostTest {

    @Test
    public void createRestUser(){

        JSONObject requestParams = new JSONObject();
        requestParams.put("username", "RestUser");
        requestParams.put("password", "123");
        requestParams.put("name", "REST");
        requestParams.put("usertype", "restuser");
        given().request().
                header("Content-Type", "application/json").
                body(requestParams.toJSONString()).
                post("http://127.0.0.1:3000/users").
                then().statusCode(201).
                body("usertype", equalTo("restuser"));

    }
}
