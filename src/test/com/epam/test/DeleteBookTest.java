package com.epam.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by Mark_Rudak on 4/21/2017.
 */
public class DeleteBookTest extends PreparationSteps {

    /**
     * Delete book and to check that book successfully deleted
     */
    @Test
    public void existingBookIsDeletedTest() {
        Map<String, String> bookId = new HashMap<String, String>();
        bookId.put("id", "1");


        given().body(bookId).
                when().delete(CONTENT_PATH).then().statusCode(200);


        given().when().get(CONTENT_PATH).then()
                .body(not("Idiot")).statusCode(200);

    }

    /**
     * Trying to delete nonExisting book
     */
    @Test
    public void nonExistingBookIsDeletedTest() {
        Map<String, String> bookId = new HashMap<String, String>();
        bookId.put("id", "4");


        given().body(bookId).
                when().delete(CONTENT_PATH).then().statusCode(404);
    }
}
