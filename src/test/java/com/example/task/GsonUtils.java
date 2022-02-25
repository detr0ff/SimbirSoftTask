package com.example.task;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;

public class GsonUtils {
    public static <T>T deserialize(String jsonString, Class cls){
        Gson gson = new Gson();
        Type listType = TypeToken.getParameterized(cls).getType();
        return (T)gson.fromJson(jsonString, listType);
    }

    public static <T> List<T> deserializeList(String jsonString, Class cls){
        Gson gson = new Gson();
        Type listType = TypeToken.getParameterized(Array.class, cls).getType();
        return (List<T>) gson.fromJson(jsonString, listType);
    }
}


