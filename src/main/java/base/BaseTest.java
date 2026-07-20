package base;

import io.restassured.RestAssured;
import listeners.TestListeners;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigReader;

@Listeners(TestListeners.class)
public class BaseTest {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = ConfigReader.getProperty("base.url");

    }

}
