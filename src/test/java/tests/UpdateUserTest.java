package tests;

import base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import models.request.UpdateUserRequest;
import models.response.UpdateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.UserService;

public class UpdateUserTest extends BaseTest {

    UserService userService = new UserService();

    @Test
    public void verifyUserUpdate() throws JsonProcessingException {
        UpdateUserRequest request = new UpdateUserRequest();

        request.setName("Sakib");

        request.setJob("SQA Engineer");

        UpdateUserResponse response =
                userService.updateUser(
                        2,request
                );
        Assert.assertEquals(
                response.getName(),"Sakib"
        );

        Assert.assertEquals(response.getJob(),"SQA Engineer");

        Assert.assertNotNull(response.getUpdatedAt());
    }
}
