package services;

import clients.AuthClient;
import io.restassured.response.Response;
import models.request.LoginRequest;
import models.response.LoginResponse;

public class AuthService {

    private final AuthClient authClient= new AuthClient();

    public LoginResponse login(LoginRequest request){
        Response response = authClient.login(request);

        return response.as(LoginResponse.class);
    }
}
