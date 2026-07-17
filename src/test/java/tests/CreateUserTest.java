package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import models.request.CreateUserRequest;
import models.response.CreateUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.UserService;

public class CreateUserTest extends BaseTest {

    UserService userService = new UserService();

    @Test
    @Description("Verify the User creation API")
    public void verifyUserCreation(){
        CreateUserRequest request = new CreateUserRequest();
        request.setName("Sakib");
        request.setJob("SQA Engineer");

        CreateUserResponse response = userService.createUser(request);

        Allure.addAttachment("Response Body", response.toString());


        Allure.parameter("Name",response.getName());
        Allure.parameter("Job",response.getJob());
        Allure.parameter("ID",response.getId());

        Allure.addAttachment("Name",response.getName());
        Allure.addAttachment("Job",response.getJob());
        Allure.addAttachment("ID",response.getId());

        attachUserDetailsToAllure(response);


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
