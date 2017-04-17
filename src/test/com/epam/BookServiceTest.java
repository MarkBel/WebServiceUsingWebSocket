package com.epam;

import org.junit.Test;


import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Mark_Rudak on 4/17/2017.
 */
public class BookServiceTest extends PreparingSteps {


      @Test
      public void basicGetTest() {
         given().when().get("/book").then().statusCode(200);
      }

}
