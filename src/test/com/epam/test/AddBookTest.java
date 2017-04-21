package com.epam.test;

import com.epam.bean.Book;
import com.epam.utils.xstream.XmlUtils;

import org.junit.Test;



import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Mark_Rudak on 4/21/2017.
 */
public class AddBookTest extends PreparationSteps {

@Test
    public void aBookJsonAddedOnAShelf() {

        Book bookBean = Book.createBookForTest();
        given()
                .contentType(CONTENT_TYPE_JSON)
                .body(bookBean)
                .when().post(CONTENT_PATH).then()
                .statusCode(201);

        given().when().get("/book").then()
                .body(containsString("\"id\":3,\"bookName\":\"Harry Potter and Philosophy Stone\"")).statusCode(200);

    }

    @Test
    public void aBookXmlAddedOnAShelf() {


        Book bookBean = Book.createBookForTest();
        String xmlObject = XmlUtils.parseToXmlBook(bookBean);


        given()
                .contentType(CONTENT_TYPE_XML)
                .body(xmlObject)
                .when()
                .post(CONTENT_PATH).then()
                .statusCode(201);

        given().when().get("/book").then().
                body(containsString("\"id\":3,\"bookName\":\"Harry Potter and Philosophy Stone\"")).statusCode(200);
    }

}
