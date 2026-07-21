package utils;

import io.qameta.allure.Allure;
import models.response.CreateUserResponse;
import models.response.UpdateUserResponse;

public class AllureUtils {

    private AllureUtils(){}

    public void attachText(
            String title,
            String content
    ){
        Allure.addAttachment(
                title,
                content
        );
    }

    public static void attachParameter(
            String name,
            String value
    ){
        Allure.parameter(
                name,
                value
        );
    }

    public static void attachCreateUserResponse(
            CreateUserResponse response
    ){
        String details = String.format(
                """
                        Name       : %s
                        Job        : %s
                        ID         : %s
                        Created At : %s
                        """,
                response.getName(),
                response.getJob(),
                response.getId(),
                response.getCreatedAt()
        );
        Allure.addAttachment(
                "Create User Response",
                details
        );
    }

    public static void attachUpdateUserResponse(
            UpdateUserResponse response
    ){
        String details = String.format(
                """
                        Name          : %s
                        Job           : %s
                        Updated At    : %s
                        """,
                response.getName(),
                response.getJob(),
                response.getUpdatedAt()
        );
        Allure.addAttachment(
                "Update User Response",
                details
        );
    }

    public static void attachResponseBody(
            String responseBody
    ){
        Allure.addAttachment(
                "Response Body",
                responseBody
        );
    }

    public static void attachStatusCode(
            int statusCode
    ){
        Allure.addAttachment(
                "Statuc Code",
                String.valueOf(statusCode)
        );
    }
}
