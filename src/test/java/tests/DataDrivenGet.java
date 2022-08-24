package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DataDrivenGet {

    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void createRequestSpec() {
        requestSpecification = new RequestSpecBuilder().setBaseUri("http://127.0.0.1:3000/users").build();
        responseSpecification =
                new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

    @DataProvider(name = "viewusers")
    public Object[][] dataforPost() {
        return new Object[][]{
                {"1", "admin"},
                {"3", "admin2"}
        };
    }


    @Test(dataProvider = "viewusers")
    public void getUsersById(String id, String username) {

        given().
                spec(requestSpecification).
                pathParam("id", id).
                when().
                get("{id}").
                then().
                spec(responseSpecification).and().
                assertThat().
                body("username", equalTo(username));

    }

}
