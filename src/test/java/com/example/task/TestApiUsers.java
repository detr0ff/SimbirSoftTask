package com.example.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestApiUsers {

    @Test
    public void getAllUsers(){
        boolean check = Steps.getAllUsers(BaseTest.requestSpecification)
                .stream()
                .filter(user -> user.getFirst_name().equals("George"))
                .filter(user -> user.getLast_name().equals("Bluth"))
                .anyMatch(user -> user.getEmail().equals("george.bluth@reqres.in"));
        Assertions.assertTrue(check, "Почта не совпадает");
    }

    @Test
    public void getUser(){
        String email = Steps.getUserByName(BaseTest.requestSpecification, "Michael", "Lawson")
                .getEmail();
        Assertions.assertEquals(email, "michael.lawson@reqres");
    }
}
