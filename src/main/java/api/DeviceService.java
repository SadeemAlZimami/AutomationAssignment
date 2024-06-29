package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeviceService {

    public Response addDevice(Device device) {
        return given()
                .contentType(ContentType.JSON)
                .body(device)
                .when()
                .post(Endpoints.ADD_DEVICE)
                .then()
                .extract()
                .response();
    }
}
