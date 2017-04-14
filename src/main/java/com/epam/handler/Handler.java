package com.epam.handler;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public  class Handler {

    private String method;
    private String uri;
    private IHandler iHandler;

    public Handler(String method, String uri, IHandler iHandler) {
        this.method = method;
        this.uri = uri;
        this.iHandler = iHandler;
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

    public IHandler getiHandler() {
        System.out.println("Handler Found");
        return iHandler;
    }

    public void setiHandler(IHandler iHandler) {
        this.iHandler = iHandler;
    }



}
