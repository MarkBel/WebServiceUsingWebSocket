package com.epam.test;

import com.epam.bean.Book;
import org.junit.Test;

import java.awt.*;
import java.util.*;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Mark_Rudak on 4/21/2017.
 */
public class ReadBookTest extends PreparationSteps {

    @Test
    public void basicGetBooksTest() {
//        java.util.List<Book> list = new ArrayList<Book>();
//
//        list = given().when().get("/book").then().body(list);
        given().when().get("/book").then().statusCode(200);
    }

    @Test
    public void verifyNameOfBook() {
        given().when().get("/book").then()
                .body(containsString("Idiot"));
    }

    @Test
    public void verifyNameStructured() {
        given().when().get("/book").then()
                .body("bookName",equalTo("[Idiot,Financier]"));
    }

    @Test
    public void verifyBookArgs() {
        given().when().get("/book").then().
                body(containsString("Idiot")).
                body("year",equalTo("1869"))
                .body("pageCount",equalTo(700));
    }

}
