package com.epam.test;


import org.junit.Test;


import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Mark_Rudak on 4/21/2017.
 */
public class ReadBookTest extends PreparationSteps {

    @Test
    public void basicGetBooksJsonTest() {

        given().contentType(CONTENT_TYPE_JSON).when().get(CONTENT_PATH).then().statusCode(200);

    }


    @Test
    public void getBooksXmlTest() {

        given().contentType(CONTENT_TYPE_XML).when().get(CONTENT_PATH).then().statusCode(200);
    }


    @Test
    public void verifyNameOfBook() {
        given().when().get(CONTENT_PATH).then()
                .body(containsString("Idiot")).statusCode(200);
    }

    @Test
    public void verifyNameStructured() {
        given().when().get(CONTENT_PATH).then()
                .body("bookName", equalTo("[Idiot, Financier]")).statusCode(200);
    }

    @Test
    public void verifyBookArgs() {
        given()
                .when()
                .get(CONTENT_PATH)
                .then().
                body(containsString("Idiot")).
                body("year", equalTo("1869"))
                .body("pageCount", equalTo(700)).statusCode(200);
    }

    @Test
    public void aBookStoreIsNotEmpty(){


//        String x = given().contentType(CONTENT_TYPE_JSON).when().get("/book").body().toString();
//
//        System.out.println(x);

//        System.out.println(bookStore);
//
//        Assert.assertFalse(bookStore.bookStoreIsEmpty());
    }




}
