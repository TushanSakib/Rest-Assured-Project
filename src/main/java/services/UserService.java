package services;

import clients.UserClient;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import models.request.UpdateUserRequest;
import models.response.CreateUserResponse;
import models.response.UpdateUserResponse;
import utils.LoggerUtils;

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

        LoggerUtils.info(
                "Response Status: " + response.getStatusCode()
        );

        return response.as(CreateUserResponse.class);
    }

    public UpdateUserResponse updateUser(
            int id,
            UpdateUserRequest request
    ){
        Response response =
                userClient.updateUser(
                        id,request
                );
        return response.as(UpdateUserResponse.class);
    }
}
