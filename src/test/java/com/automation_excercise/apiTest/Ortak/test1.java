package com.automation_excercise.apiTest.Ortak;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class test1 {
    String automationExcersize="https://automationexercise.com";

    @Test
    public void test1() {
        Response response = RestAssured.get(automationExcersize + "/api/productsList");
        System.out.println("response.statusCode() = " + response.statusCode());
        response.prettyPrint();
    }

    @Test
    public void test2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(automationExcersize + "/api/productsList");
        assertEquals(response.statusCode(),200);
        System.out.println("response.contentType() = " + response.contentType());
        response.prettyPrint();
    }



    @Test
    public void test3() {
       RestAssured.given().accept(ContentType.JSON)
                .when().get(automationExcersize + "/api/productsList")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType("text/html; charset=utf-8");
    }

    @Test
    public void test4() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(automationExcersize + "/api/productsList");
        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"text/html; charset=utf-8");
        assertTrue(response.body().asString().contains("Women"));
        response.prettyPrint();
    }

}
