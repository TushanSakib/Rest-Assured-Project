package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;
npublic class BaseClient {
    protected RequestSpecification getRequestSpec(){
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setContentType("application/json");
        String apiKey = ConfigReader.getProperty("x.api.key");
        if(apiKey != null && !apiKey.isEmpty()){
            builder.addHeader("x-api-key", apiKey);
        }
        return builder.build();
    }
}

