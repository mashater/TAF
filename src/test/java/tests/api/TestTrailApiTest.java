package tests.api;

import configurations.Endpoints;
import configurations.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Project;
import models.ProjectType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestTrailApiTest extends BaseApiTest{

    @Test
    public void getAllProjectsTest(){

        // Setup request Object
        RequestSpecification httpRequest = given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON); // в каком виде будет ответ
        httpRequest.auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword()); // базовая авторизация

        // Setup Response Object
        Response response = httpRequest.request(Method.GET, Endpoints.GET_PROJECTS);


        // Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
    }

    @Test
    public void getAllProjectsShortTest(){
        given()
                //.header(HTTP.CONTENT_TYPE, ContentType.JSON) --добавили в baseApiTest
                //.auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword())
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void addProjectTest(){
        Project newProject = Project.builder()
                .name("WP_Test_01")
                .build();

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\"\n" +
                        "}", newProject.getName()))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);


        //String newProjectName = "WP_Test_01";

        /*given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\"\n" +
                        "}", newProjectName))
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

         */
    }

    @Test
    public void addProject2() {
        Project project = Project.builder()
                .name("WP_Project_02")
                .typeOfProject(ProjectType.SINGLE_SUITE_MODE)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>(); // имя и значение
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        given()
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3() {
        Project project = Project.builder()
                .name("WP_Test_03")
                .typeOfProject(ProjectType.MULTIPLE_SUITE_MODE)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        Project newProject = given()  // создаем
                .body(jsonAsMap)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Project.class); //ответ в объекте

        System.out.println(newProject.toString());
    }
}
