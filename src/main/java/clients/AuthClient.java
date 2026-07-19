package clients;

import endpoints.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.LoginRequest;

import static io.restassured.RestAssured.given;

public class AuthClient extends BaseClient{

    public Response login(LoginRequest request){
        return given()
                .spec(getRequestSpec())
                .contentType(ContentType.JSON)
                .body(request)
                .log().all()
                .when()
                .post(Routes.LOGIN);
    }
}
