package com.epam.handler.command;

import com.epam.logic.Request;
import com.epam.logic.Response;

import java.io.IOException;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public interface ICommand {

    void handle(Request rq, Response rp) throws IOException;

}
