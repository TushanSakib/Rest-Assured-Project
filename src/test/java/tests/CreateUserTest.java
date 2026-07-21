package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import models.request.CreateUserRequest;
import models.response.CreateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.UserService;
import utils.AllureUtils;

public class CreateUserTest extends BaseTest {

    UserService userService = new UserService();

    @Test
    @Description("Verify the User creation API")
    public void verifyUserCreation(){
        CreateUserRequest request = new CreateUserRequest();
        request.setName("Sakib");
        request.setJob("SQA Engineer");

        CreateUserResponse response = userService.createUser(request);

        AllureUtils.attachCreateUserResponse(response);


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

    private void attachUserDetailsToAllure(CreateUserResponse response){
        String details = String.format(
        """
        Name       : %s           \s
        Job        : %s
        ID         : %s
        Created At : %s
       \s""",
                response.getName(),
                response.getJob(),
                response.getId(),
                response.getCreatedAt()
        );
        Allure.addAttachment("User Details", details);
    }
}
