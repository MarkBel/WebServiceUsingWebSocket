package com.epam;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Mark_Rudak on 4/17/2017.
 */
public class BookServiceTest extends PreparingSteps {

    //Scenarios

    //delete then get
    //post then delete and get
    // put then get
      @Test
      public void basicGetBooksTest() {
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

    @Test
    public void aBookAddedOnAShelf() {
        Map<String,String> book = new HashMap<String,String>();
        book.put("id", "3");


        given()
                .contentType("application/json")
                .body(book)
                .when().post("/book").then()
                .statusCode(201);
    }

    @Test
    public void deleteBookById(){
        Map<String,String> bookId = new HashMap<String,String>();
        bookId.put("id", "3");

          given().contentType("application/json").body(bookId).
                  when().delete("/book").then().statusCode(200);
    }


}
