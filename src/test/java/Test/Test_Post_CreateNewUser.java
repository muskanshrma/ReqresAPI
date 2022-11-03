package Test;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_Post_CreateNewUser {
    @Test
    public void createAndVerifyUser() {

        JSONObject request = new JSONObject();
        request.put("name", "Mark");
        request.put("job", "Director");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().statusCode(201 );
    }
}