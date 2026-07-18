package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;
import utils.RequestSpecificationManager;

public class BaseClient {
    protected RequestSpecification getRequestSpec(){
        return RequestSpecificationManager.getRequestSpecification();
    }
}
