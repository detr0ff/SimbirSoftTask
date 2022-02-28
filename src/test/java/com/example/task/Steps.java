package com.example.task;

import com.example.task.Models.ResponseModelAllUsers;
import com.example.task.Models.ResponseModelUser;
import com.example.task.Models.User;
import com.google.gson.JsonElement;
import io.restassured.specification.RequestSpecification;

import java.lang.constant.Constable;
import java.util.List;

public class Steps {
    public static List<User> getAllUsers(RequestSpecification requestSpecification){
        return requestSpecification.get()
                .then()
                .statusCode(200)
                .extract()
                .as(ResponseModelAllUsers.class)
                .getData();
    }

    public static User getUserBuId(RequestSpecification requestSpecification, int id){
        return requestSpecification.get(String.valueOf(id))
                .then()
                .statusCode(200)
                .extract()
                .as(ResponseModelUser.class)
                .getData();
    }

    public static User getUserByName(RequestSpecification requestSpecification, String name, String last_name){
        boolean check = false;
        int i = 1;
        User user = null;
        while (!check || i>100){
            user = getUserBuId(requestSpecification, i);
            if (user.getFirst_name().equals(name) && user.getLast_name().equals(last_name)){
                check = true;
            }
            i++;
        }
        return user;
    }
}




