package com.example.task;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

abstract public class BaseTest {
    protected static RequestSpecification requestSpecification = given().baseUri("https://reqres.in/api/users")
            .contentType(ContentType.JSON);
}
