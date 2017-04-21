package com.epam.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Mark_Rudak on 4/21/2017.
 */
public class DeleteBookTest extends PreparationSteps {

    @Test
    public void deleteBookById() {
        Map<String, String> bookId = new HashMap<String, String>();
        bookId.put("id", "3");


        given().contentType("application/json").body(bookId).
                when().delete("/book").then().statusCode(200);


        given().when().get("/book").then()
                .body(containsString("Idiot"));

    }
}
