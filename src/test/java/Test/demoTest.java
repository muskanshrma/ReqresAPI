package Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class demoTest {

    @Test(priority = 1)
    public void IteratingHeaders()
    { RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        Headers allHeaders = response.headers();
        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }

    @Test
    public void GetBookHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);

        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);

        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
    }
}