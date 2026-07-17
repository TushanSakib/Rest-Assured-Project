package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import services.UserService;

public class UserAPITest extends BaseTest {
    UserService userService = new UserService();

    @Test
    public void verifyGetUsers(){
        Response response = userService.getUsers();

        Assert.assertEquals(
                200, response.getStatusCode()
        );

    }
}
