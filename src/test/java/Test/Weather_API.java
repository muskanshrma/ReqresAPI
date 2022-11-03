package Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Weather_API {

    @Test
    public void GetCurrentWeather() {
        RestAssured.baseURI = "http://api.weatherapi.com/v1";
        given()
                .header("key", " 9479fffa44284caa96e125352220311")
                .contentType(ContentType.JSON)
                .queryParam("q", "Solan")
                .get("/current.json")
                .then().assertThat().
                statusCode(200).
                log().all();
    }

    @Test
    public void GetForecast() {
        RestAssured.baseURI = "http://api.weatherapi.com/v1";
        given()
                .header("key", " 9479fffa44284caa96e125352220311")
                .queryParam("q", "Chandigarh")
                .contentType(ContentType.JSON)
                .get("/forecast.json")
                .then().assertThat().
                statusCode(200).
                log().all();
    }
}