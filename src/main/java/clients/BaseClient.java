package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseClient {
    protected RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }
}

