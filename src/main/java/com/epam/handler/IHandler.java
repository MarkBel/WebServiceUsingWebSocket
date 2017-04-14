package com.epam.handler;

import com.epam.logic.Request;
import com.epam.logic.Response;

import java.io.IOException;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public interface IHandler {

    void handle(Request rq, Response rp) throws IOException;

}
