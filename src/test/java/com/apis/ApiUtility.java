package com.apis;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class ApiUtility {

    public ApiUtility(){

    }
    public static String getResponse(String postNumber){
        Response response=when().get(String.format("https://reqres.in/api/users/%s",postNumber)).
                then().contentType(ContentType.JSON).extract().response();
        String usernames = response.jsonPath().getString("data.first_name");
        System.out.println("Response after hitting the APIs is:-  "+usernames);
        return  usernames;
    }

}
