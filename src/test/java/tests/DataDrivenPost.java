package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DataDrivenPost {

    @DataProvider(name="userlist")
    public Object[][] dataforPost(){

        Object[][] data = new Object[2][4];
        data[0][0] = "datauser1";
        data[0][1] = "password";
        data[0][2] = "datauser";
        data[0][3] = "datauser1name";

        data[1][0] = "datauser2";
        data[1][1] = "password";
        data[1][2] = "datauser";
        data[1][3] = "datauser2name";

        return data;
    }


    @Test(dataProvider = "userlist")
    public void createUser(String  username,String password,String usertype, String name){

        JSONObject requestParams = new JSONObject();
        requestParams.put("username", username);
        requestParams.put("password", password);
        requestParams.put("name", name);
        requestParams.put("usertype", usertype);
        given().request().
                header("Content-Type", "application/json").
                body(requestParams.toJSONString()).
                post("http://127.0.0.1:3000/users").
                then().statusCode(201).
                body("usertype", equalTo("datauser"));

    }
}
