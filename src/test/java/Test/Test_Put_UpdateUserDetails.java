package Test;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_Put_UpdateUserDetails {
    @Test
    public void updateAndVerifyUserDetails() {

        JSONObject request = new JSONObject();
        request.put("name", "Mark");
        request.put("job", "Manager");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().statusCode(200);
    }
}