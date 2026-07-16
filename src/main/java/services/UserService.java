package services;

import clients.UserClient;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import models.response.CreateUserResponse;

public class UserService {
    UserClient userClient = new UserClient();

    public Response getUsers(){
        return userClient.getUsers();
    }
    public Response getSingleUser(int id){
        return userClient.getSingleUser(id);
    }

    public CreateUserResponse createUser(
            CreateUserRequest request
    ){
        Response response = userClient.createUser(request);
        return response.as(CreateUserResponse.class);
    }
}
