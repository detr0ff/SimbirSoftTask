package com.example.task.Models;

import lombok.Data;
import java.util.List;

@Data
public class ResponseModelAllUsers {
    List<User> data;

    public ResponseModelAllUsers(List<User> data){
        this.data = data;
    }

    public ResponseModelAllUsers(){}
}
