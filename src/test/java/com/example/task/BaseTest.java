package com.example.task;

import com.example.task.Config.Config;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

abstract public class BaseTest {
    protected static RequestSpecification requestSpecification = given().baseUri(Config.getProperty("baseUrl"))
            .contentType(ContentType.JSON);
}
