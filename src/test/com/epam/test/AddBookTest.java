package com.epam.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Mark_Rudak on 4/21/2017.
 */
public class AddBookTest extends PreparationSteps {


    @Test
    public void aBookAddedOnAShelf() {
        Map<String,String> book = new HashMap<String,String>();
        book.put("id", "3");


        given()
                .contentType("application/json")
                .body(book)
                .when().post("/book").then()
                .statusCode(201);

//        given().when().get("/book").then()
//                .body(containsString("null"));

    }

}
