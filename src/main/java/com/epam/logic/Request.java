package com.epam.logic;

import com.epam.constants.GlobalConstants;
import com.epam.utils.HttpMethodUtils;
import com.epam.utils.SplitUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class Request {

    private String method;
    private String path;
    private String version;
    private int contentLenght = 0;
    private String contentType;
    private String body;

    public Request(BufferedReader bfr) {
        parseRequest(bfr);
    }

    public int getContentLenght() {
        return contentLenght;
    }

    public void setContentLenght(int contentLenght) {
        this.contentLenght = contentLenght;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    private void parseRequest(BufferedReader bfr) {
        List<String> headerValue = null;
        try {
            headerValue = HttpMethodUtils.getHeaderValue(bfr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String value : headerValue) {
            if (value.startsWith(GlobalConstants.GET)) {

                method = GlobalConstants.GET;
                path = SplitUtils.getCertainSplitValueBy(value, GlobalConstants.PATH, GlobalConstants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, GlobalConstants.VERSION, GlobalConstants.SPACE);

            } else if (value.startsWith(GlobalConstants.POST)) {

                method = GlobalConstants.POST;
                path = SplitUtils.getCertainSplitValueBy(value, GlobalConstants.PATH, GlobalConstants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, GlobalConstants.VERSION, GlobalConstants.SPACE);

            }
            else if (value.startsWith(GlobalConstants.DELETE)) {

                method = GlobalConstants.DELETE;
                path = SplitUtils.getCertainSplitValueBy(value, GlobalConstants.PATH, GlobalConstants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, GlobalConstants.VERSION, GlobalConstants.SPACE);

            }
            else if (value.startsWith(GlobalConstants.PUT)) {

                method = GlobalConstants.PUT;
                path = SplitUtils.getCertainSplitValueBy(value, GlobalConstants.PATH, GlobalConstants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, GlobalConstants.VERSION, GlobalConstants.SPACE);

            }
            else if (value.startsWith(GlobalConstants.CONTENT_LENGTH)) {
                contentLenght = Integer.parseInt(SplitUtils.getCertainSplitValueBy(value, GlobalConstants.VALUE,
                        GlobalConstants.COLON_SPLITTER));
            }
            else if (value.startsWith(GlobalConstants.CONTENT_TYPE)) {

                contentType = SplitUtils.getCertainSplitValueBy(value, GlobalConstants.VALUE, GlobalConstants.COLON_SPLITTER);
            }
        }


        if (contentLenght > 0) {
            body = headerValue.get(headerValue.size() - 1);
        }

    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", contentLength=" + contentLenght +
                ", contentType='" + contentType + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
