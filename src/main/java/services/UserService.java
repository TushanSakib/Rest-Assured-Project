package services;

import clients.UserClient;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    ) throws JsonProcessingException {
        Response response =
                userClient.updateUser(
                        id,request
                );
        LoggerUtils.info("Response Status: " + response.getStatusCode());
        LoggerUtils.info("Response Body: " + response.getBody().asString());
        if(response.getStatusCode() >=200 && response.getStatusCode()<300){
            return response.as(UpdateUserResponse.class);
        } else {
            throw new RuntimeException("Update failed: " + response.getStatusCode() + " body: " + response.getBody().asString());
        }
    }

    public Response deleteUser(int id){
        Response response = userClient.deleteUser(id);

        LoggerUtils.info(
                "Delete Status : "
                +response.getStatusCode()
        );
        return response;
    }
}
