package utils;

import models.request.CreateUserRequest;

public class TestDataFactory {
    public static CreateUserRequest createUser() {
        CreateUserRequest request =
                new CreateUserRequest();

        request.setName("Sakib");
        request.setJob("SQA Engineer");

        return request;
    }
}
