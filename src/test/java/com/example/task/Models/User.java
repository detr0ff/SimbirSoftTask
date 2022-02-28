package com.example.task.Models;

import lombok.Data;

@Data
public class User {
    int id;
    String email;
    String first_name;
    String last_name;
    String avatar;

    public User(int id, String email, String first_name, String last_name, String avatar){
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }
    public User(){}
}
