package services;

import clients.UserClient;
import io.restassured.response.Response;

public class UserService {
    UserClient userClient = new UserClient();

    public Response getUsers(){
        return userClient.getUsers();
    }
    public Response getSingleUser(int id){
        return userClient.getSingleUser(id);
    }
}
