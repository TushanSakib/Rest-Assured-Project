package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationManager {
    private ResponseSpecificationManager(){}

    public static ResponseSpecification successResponse(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}
