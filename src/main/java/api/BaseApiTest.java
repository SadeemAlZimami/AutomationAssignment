package api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;


public abstract class BaseApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.restful-api.dev";
    }
}
