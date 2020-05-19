package com.parser;

import com.apis.ApisEndpoint;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Deserilization;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiUtility {

    public ApiUtility(){

    }
    public static String getResponse(String postNumber){
        Response response=when().get(String.format(ApisEndpoint.endpoint1,postNumber)).
                then().contentType(ContentType.JSON).extract().response();
        String usernames = response.jsonPath().getString("data.first_name");
        System.out.println("Response after hitting the APIs is:-  "+usernames);
        return  usernames;
    }
    public static void getResponseFromUnknownApi(){
        Deserilization getResponse=given().contentType(ContentType.JSON).expect().defaultParser(Parser.JSON).
                when().get(String.format(ApisEndpoint.endpoint2)).as(Deserilization.class);

        System.out.println("reponse is:="+getResponse.getTotal());
        System.out.println("reponse is:="+getResponse.getPer_page());
        System.out.println("reponse is:="+getResponse.getPage());

        return ;

    }

}
