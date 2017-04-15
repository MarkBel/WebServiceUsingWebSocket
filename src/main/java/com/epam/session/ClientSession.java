package com.epam.session;

import com.epam.handler.Handler;
import com.epam.logic.Request;
import com.epam.logic.Response;
import com.epam.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class ClientSession implements Runnable{

    private Request rq;
    private Response rp;
    private Socket socket;

    public ClientSession(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            rq = new Request(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            System.out.println(rq);
            rp = new Response(socket.getOutputStream());
            Handler requiredHandl =   Server.findHandler(rq);
            System.out.println("Handler");
            requiredHandl.getiCommand().handle(rq, rp);
            this.socket.close();
        }   catch (IOException e) {
            System.out.println(rp);
        }
    }
}
