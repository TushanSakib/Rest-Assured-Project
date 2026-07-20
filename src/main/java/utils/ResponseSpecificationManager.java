package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationManager {

    private ResponseSpecificationManager(){}

    public static ResponseSpecification success200(){

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification success201(){

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }

    public static ResponseSpecification success204(){

        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }

    public static ResponseSpecification badRequest400(){

        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
}