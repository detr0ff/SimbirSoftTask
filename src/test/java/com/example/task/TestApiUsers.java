package com.example.task;

import com.example.task.Config.Config;
import com.example.task.Utils.PropertyReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestApiUsers {

    @Test
    public void getAllUsers(){
        boolean check = Steps.getAllUsers(BaseTest.requestSpecification)
                .stream()
                .filter(user -> user.getFirst_name().equals(Config.getProperty("testFirstName1")))
                .filter(user -> user.getLast_name().equals(Config.getProperty("testLastName1")))
                .anyMatch(user -> user.getEmail().equals(Config.getProperty("testEmail1")));
        Assertions.assertTrue(check, "Почта не совпадает");
    }

    @Test
    public void getUserByName(){
        String email = Steps.getUserByName(BaseTest.requestSpecification, Config.getProperty("testFirstName2"), Config.getProperty("testLastName2"))
                .getEmail();
        Assertions.assertEquals(email, Config.getProperty("testEmail2"), "Почты не совпадют");
    }
}
