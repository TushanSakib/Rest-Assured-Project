package utils;

import models.request.CreateUserRequest;
import models.request.UpdateUserRequest;

public class TestDataFactory {
    public static CreateUserRequest createUser() {
        CreateUserRequest request =
                new CreateUserRequest();

        request.setName(
                FakerUtils.getFullName()
        );
        request.setJob(
                FakerUtils.getJobTitle()
        );

        return request;
    }

    public static UpdateUserRequest updateUser(){
        UpdateUserRequest request = new UpdateUserRequest();

        request.setName(
                FakerUtils.getFullName()
        );

        request.setJob(
                FakerUtils.getJobTitle()
        );
        return request;
    }
}
