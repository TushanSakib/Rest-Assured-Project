package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;
import services.UserService;
import utils.AssertionUtils;

public class DeleteUserTest extends BaseTest {

    UserService userService = new UserService();

    @Test
    public void verifyDeleteUser(){
        Response response = userService.deleteUser(2);

        AssertionUtils.verifyStatusCode(
                response.getStatusCode(),204
        );
    }
}
