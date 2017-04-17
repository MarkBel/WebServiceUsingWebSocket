package com.epam;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Mark_Rudak on 4/17/2017.
 */
public class PreparingSteps {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");

        if (port == null) {
            RestAssured.port = Integer.valueOf(9191);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }
}
