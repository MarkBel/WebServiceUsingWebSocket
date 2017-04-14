package com.epam.runner;

import com.epam.server.Server;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class Runner {

    private final static Logger  LOGGER = Logger.getLogger(Runner.class.getName());
    private final static Integer PORT = 9191;
    private final static Integer POOL_SIZE = 10;

    public static void main(String[] args) throws IOException {

        Server server = new Server(PORT,POOL_SIZE);
        Server.configureServer(server);
        server.start();

    }



}
