package com.automation_excercise.apiTest.Ortak;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class test2 {
    String automationExcersize="https://automationexercise.com";

    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(automationExcersize + "/api/productsList");
       assertEquals(response.statusCode(),200);
       assertEquals(response.contentType(),"text/html; charset=utf-8");
       assertFalse(response.body().asString().contains("kadın"));
    }

    @Test
    public void test2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(automationExcersize + "/api/productsList");
        System.out.println("response.header(\"Transfer-Encoding\") = " + response.header("Transfer-Encoding"));
        System.out.println("response.header(\"vary\") = " + response.header("vary"));
        System.out.println("response.header(\"referrer-policy\") = " + response.header("referrer-policy"));
    assertEquals(response.header("Transfer-Encoding"),"chunked");
    assertTrue(response.headers().hasHeaderWithName("referrer-policy"));
        System.out.println("response.headers().hasHeaderWithName(\"Data\") = " + response.headers().hasHeaderWithName("Date"));

    }

    @Test
    public void test3() {


        int id=43;
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", id)
                .when().get(automationExcersize + "/api/{id}");
        System.out.println("response.statusCode() = " + response.statusCode());
       // response.prettyPrint();



    }


}
