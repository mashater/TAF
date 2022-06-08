package tests.api;

import configurations.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    @BeforeTest
    public void setupEnv(){
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()  // одинаковое начало в каждом тесте, изменили гивен
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword());

    }
}
