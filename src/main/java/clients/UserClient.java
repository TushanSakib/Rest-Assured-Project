package clients;

import endpoints.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class UserClient {
    public Response getUsers(){
        return given()
                .when()
                .get(Routes.GET_USERS);
    }
    public Response getSingleUser(int id){
        return given()
                .pathParam("id",id)
                .when()
                .get(Routes.GET_SINGLE_USER);
    }

    public Response createUser(
            CreateUserRequest request
    ){
        return given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post(Routes.CREATE_USER);
    }
}
