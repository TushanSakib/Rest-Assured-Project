package tests;

import base.BaseTest;
import models.request.LoginRequest;
import models.response.LoginResponse;
import org.junit.Assert;
import org.testng.annotations.Test;
import services.AuthService;

public class LoginTest extends BaseTest {

    private final AuthService authService = new AuthService();

    @Test
    public void verifyLogin(){
        LoginRequest request = new LoginRequest();

        request.setEmail("eve.holt@reqres.in");

        request.setPassword("cityslicka");

        LoginResponse response = authService.login(request);

        Assert.assertNotNull(
                response.getToken()
        );
    }
}
