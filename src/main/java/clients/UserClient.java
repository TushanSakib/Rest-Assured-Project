package clients;

import endpoints.Routes;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.request.CreateUserRequest;
import models.request.UpdateUserRequest;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient {
    public Response getUsers(){
        return given()
                .spec(getRequestSpec())
                .when()
                .get(Routes.GET_USERS);
    }
    public Response getSingleUser(int id){
        return given()
                .spec(getRequestSpec())
                .pathParam("id",id)
                .when()
                .get(Routes.GET_SINGLE_USER);
    }

    public Response createUser(
            CreateUserRequest request
    ){
        return given()
                .spec(getRequestSpec())
                .body(request)
                .when()
                .post(Routes.CREATE_USER);
    }

    public Response updateUser(
            int id,
            UpdateUserRequest request
    ){
            return given()
                    .spec(getRequestSpec())
                    .contentType(ContentType.JSON)
                    .pathParam("id",id)
                    .body(request)
                    .when()
                    .put(Routes.UPDATE_USER);

    }

    public Response deleteUser(int id){
        return given()
                .spec(getRequestSpec())
                .pathParam("id",id)
                .when()
                .delete(Routes.DELETE_USER);
    }
}
