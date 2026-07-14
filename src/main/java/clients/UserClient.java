package clients;

import endpoints.Routes;
import io.restassured.response.Response;

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
}
