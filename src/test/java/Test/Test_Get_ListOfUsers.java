package Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class Test_Get_ListOfUsers {

    @Test
    public void verifyStatusCodeForGetUserDetailsRequest() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void getBody() {

        given().get("https://reqres.in/api/users?page=2").then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                body("data.id[1]", equalTo(8)).
                body("data.first_name", hasItems("Michael","Lindsay")).
                log().all();
    }
}