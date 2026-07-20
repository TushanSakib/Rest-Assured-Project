package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationManager {

    private RequestSpecificationManager(){}

    public static RequestSpecification getRequestSpecification(){

        RequestSpecBuilder builder =
                new RequestSpecBuilder();

        builder.addHeader(
                "Accept",
                "application/json"
        );

        String apiKey =
                ConfigReader.getProperty("x.api.key");

        if(apiKey != null &&
                !apiKey.isBlank()) {

            builder.addHeader(
                    "x-api-key",
                    apiKey
            );
        }

        return builder.build();
    }
}