package com.epam.test;

import com.epam.bean.Book;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


/**
 * Created by Mark_Rudak on 4/21/2017.
 */
public class UpdateBookTest extends PreparationSteps {

    /**
     * Update book and to check that book successfully updated
     */
    @Test
    public void updateExistingBookById() {

        Book bookForUpdating = Book.returnUpdatableBookForTest();

        given().contentType("application/json").body(bookForUpdating).
                when().put(CONTENT_PATH).then().statusCode(200);


        given().when().get("/book").then()
                .body(containsString(bookForUpdating.toString()));

    }

    /**
     * Trying to update non existing book
     */
    @Test
    public void updateNonExistingBookById() {

        Map<String, String> bookId = new HashMap<String, String>();
        bookId.put("id", "4");


        given().contentType("application/json").body(bookId).
                when().put(CONTENT_PATH).then().statusCode(404);


    }


}
