package com.epam.handler.command;

import com.epam.transport.Request;
import com.epam.transport.Response;

import java.io.IOException;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public interface ICommand {

    void handle(Request rq, Response rp) throws IOException;

}
