package com.epam.logic;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.epam.constants.GlobalConstants;
import jdk.nashorn.internal.ir.RuntimeNode;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class Response {


    private OutputStream os;
    private String version;
    private String statusCode;
    private String server;
    private String date;
    private String contentType;
    private String contentLength;
    private String body;

    public Response(OutputStream outputStream) {
        this.os = outputStream;
    }

    public static void createResponse(Response resp, Request rq) {

        System.out.println("1");
        String body = "";
        resp.setVersion(rq.getVersion());
        System.out.println("2");
        resp.setContentLength(String.valueOf(body.getBytes().length));
        System.out.println("3");
        resp.setBody(body);
        resp.setContentType(rq.getContentType());



        try {
            resp.write();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void write() throws IOException {

        Map<String, String> responseMap = new LinkedHashMap<String, String>();

        responseMap.put(version, statusCode);

        System.out.println("5");
        responseMap.put(GlobalConstants.SERVER, GlobalConstants.SERVER_VALUE);

        System.out.println("6");
        if (!contentLength.isEmpty()) {
            responseMap.put(GlobalConstants.CONTENT_TYPE, contentType + "\r\n");
        }
        System.out.println("7");
        if (!contentLength.isEmpty()) {
            responseMap.put(GlobalConstants.CONTENT_LENGTH, contentLength + "\r\n");
        }

        System.out.println("8");
        responseMap.put(GlobalConstants.CONNECTION, GlobalConstants.CONNECTION_VALUE);

        if (!body.isEmpty()) {
            responseMap.put(GlobalConstants.BODY, body);
        }

        System.out.println("9");
        String response = "";

        for (Map.Entry<String, String> pair : responseMap.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (key.equals(GlobalConstants.BODY)) {
                response += value;
            } else
            {
                response += key + value;
            }
        }
        os.write(response.getBytes());
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Response{" +
                "os=" + os +
                ", version='" + version + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", server='" + server + '\'' +
                ", date='" + date + '\'' +
                ", contentType='" + contentType + '\'' +
                ", contentLength='" + contentLength + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
