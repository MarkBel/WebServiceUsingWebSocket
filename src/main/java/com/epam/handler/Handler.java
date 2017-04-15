package com.epam.handler;

import com.epam.handler.command.ICommand;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public  class Handler {

    private String method;
    private String uri;
    private ICommand iCommand;

    public Handler(String method, String uri, ICommand iCommand) {
        this.method = method;
        this.uri = uri;
        this.iCommand = iCommand;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public ICommand getiCommand() {
        System.out.println("Handler Found");
        return iCommand;
    }

    public void setiCommand(ICommand iCommand) {
        this.iCommand = iCommand;
    }



}
