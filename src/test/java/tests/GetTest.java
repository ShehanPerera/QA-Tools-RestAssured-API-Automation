package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetTest {

    @Test
    public void getAllUsersTest1() {

        Response response = RestAssured.get("http://127.0.0.1:3000/users");
        int statusCode = response.statusCode();
        double timeSpent = response.getTime();

        Assert.assertEquals(statusCode, 200, "Verify Status Code");
        double timeExpect = 600.00;
        boolean time = false;
        if (timeSpent <= timeExpect) time = true;
        Assert.assertTrue(time, "Verify time not higher than 600 ms");
    }

    @Test
    public void getUserFromID3() {

        given().
                get("http://127.0.0.1:3000/users/3").
                then().
                assertThat().
                statusCode(200).
                body("usertype", equalTo("notadmin")).log().all();
    }
}
