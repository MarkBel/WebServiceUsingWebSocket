package com.epam.runner;

import com.epam.server.Server;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class Runner {

    private static final Integer PORT = 9191;
    private static final Integer POOL_SIZE = 10;

    public static void main(String[] args) throws IOException {

        BasicConfigurator.configure();// Configure log4j

        Server server = new Server(PORT, POOL_SIZE);
        Server.configureServer(server);
        server.start();

    }


}
