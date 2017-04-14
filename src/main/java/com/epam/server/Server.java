package com.epam.server;

import com.epam.constants.GlobalConstants;
import com.epam.handler.Handler;
import com.epam.handler.*;
import com.epam.logic.*;
import com.epam.session.ClientSession;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class Server{

    private final  static Logger LOGGER = Logger.getLogger(Server.class.getName());

    private final static List<Handler> HANDLERS = new ArrayList<Handler>();

    private ExecutorService pool;
    private int port;
    private int sizeOfTreadPool;


    public Server(int port, int sizeOfTreadPool) {
        this.port = port;
        this.sizeOfTreadPool = sizeOfTreadPool;
    }

    public void start() throws IOException {

        pool = Executors.newFixedThreadPool(sizeOfTreadPool);
        ServerSocket serSocket = new ServerSocket(port);
        while (true) {
            Socket sock = serSocket.accept();
            pool.submit(new ClientSession(sock));
        }
    }


    public static Handler findHandler(Request rq) throws IOException {

        String methodFromRequest = rq.getMethod();
        String pathFromRequest = rq.getPath();

        for (Handler handler : HANDLERS) {
            if (methodFromRequest.equals(handler.getMethod()) && handler.getUri().contains(pathFromRequest)) {
                LOGGER.info("Required handler is found!");
                return handler;
            }
        }
        LOGGER.info("Required handler is not found!");
        return null;
    }

    public static void configureServer(Server server) {
        server.addHandler(GlobalConstants.GET, GlobalConstants.BOOK_PATH, new GetBooksImpl());
        server.addHandler(GlobalConstants.DELETE,GlobalConstants.BOOK_PATH,new DeleteBookImpl());
        server.addHandler(GlobalConstants.POST,GlobalConstants.BOOK_PATH,new AddBookImpl());
        server.addHandler(GlobalConstants.PUT,GlobalConstants.BOOK_PATH,new UpdateBookImpl());
    }

    public void addHandler(String method, String path, IHandler handler) {
        HANDLERS.add(new Handler(method, path, handler));
    }

}
