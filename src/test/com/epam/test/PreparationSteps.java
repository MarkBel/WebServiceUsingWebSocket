package com.epam.test;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Mark_Rudak on 4/17/2017.
 */
public class PreparationSteps {

    protected static final String CONTENT_TYPE_JSON = "application/json";
    protected static final String CONTENT_TYPE_XML = "application/xml";
    protected static final String CONTENT_PATH = "/book";


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
