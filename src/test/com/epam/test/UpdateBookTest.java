package com.epam.test;

import com.epam.bean.Book;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;


/**
 * Created by Mark_Rudak on 4/21/2017.
 */
public class UpdateBookTest extends PreparationSteps {

    @Test
    public void updateExistingBookById() {

        Book bookForUpdating = Book.returnUpdatableBookForTest();

        given().contentType("application/json").body(bookForUpdating).
                when().put(CONTENT_PATH).then().statusCode(200);


//        given().when().get("/book").then()
//                .body(containsString("Idiot"));

    }

    @Test
    public void updateNotExistingBookById() {

        Map<String, String> bookId = new HashMap<String, String>();
        bookId.put("id", "4");


        given().contentType("application/json").body(bookId).
                when().put(CONTENT_PATH).then().statusCode(404);


    }


}
