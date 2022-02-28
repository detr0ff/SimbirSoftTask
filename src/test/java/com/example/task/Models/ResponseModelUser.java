package com.example.task.Models;

import lombok.Data;

@Data
public class ResponseModelUser {
    User data;

    public ResponseModelUser(User data){
        this.data = data;
    }
    public ResponseModelUser(){}
}