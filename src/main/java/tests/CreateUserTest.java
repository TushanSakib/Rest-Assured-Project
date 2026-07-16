package tests;

import base.BaseTest;
import models.request.CreateUserRequest;
import models.response.CreateUserResponse;
import org.junit.Test;
import org.testng.Assert;
import services.UserService;

public class CreateUserTest extends BaseTest {

    UserService userService = new UserService();

    @Test
    public void verifyUserCreation(){
        CreateUserRequest request = new CreateUserRequest();
        request.setName("Sakib");
        request.setJob("SQA Engineer");

        CreateUserResponse response = userService.createUser(request);

        Assert.assertEquals(
                response.getName(),"Sakib"
        );

        Assert.assertEquals(
                response.getJob(),
                "SQA Engineer"
        );

        Assert.assertNotNull(
                response.getId()
        );

        Assert.assertNotNull(
                response.getCreatedAt()
        );
    }
}
