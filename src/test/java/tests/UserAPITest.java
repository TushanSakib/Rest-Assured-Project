package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.UserService;
import utils.AllureUtils;

public class UserAPITest extends BaseTest {
    UserService userService = new UserService();

    @Test
    public void verifyGetUsers(){
        Response response = userService.getUsers();
        //Allure.addAttachment("Response Body", response.getBody().asString());
        //Allure.addAttachment("Status Code", String.valueOf(response.getStatusCode()));

        AllureUtils.attachResponseBody(
                response.getBody().asString()
        );

        AllureUtils.attachStatusCode(
                response.getStatusCode()
        );


        Assert.assertEquals(
                response.getStatusCode(), 200
        );


    }
}
