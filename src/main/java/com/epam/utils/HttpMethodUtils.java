package com.epam.utils;

import com.epam.constants.GlobalConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class HttpMethodUtils {

    private static final Integer bufferSize = 1024;

    public static List<String> getHeaderValue(BufferedReader rq) throws IOException {

        List<String> headerValue = new ArrayList<String>();
        String strForReadHeader = "";

        while ((strForReadHeader = rq.readLine()) != null) {
            headerValue.add(strForReadHeader);
            if (strForReadHeader.isEmpty()) {
                break;
            }
        }

        int contentLeng = getContentLength(headerValue);
        if (contentLeng > 0) {
            headerValue.add(getPostBody(rq, contentLeng));
        }
        return headerValue;
    }

    private static int getContentLength(List<String> headerValue) {
        int contentLength = 0;
        for (String header : headerValue) {
            if (header.contains(GlobalConstants.CONTENT_LENGTH)) {
                contentLength = Integer.parseInt(SplitUtils.getLastSplit(header, GlobalConstants.COLON_SPLITTER));
            }
        }
        return contentLength;
    }

    private static String getPostBody(BufferedReader rq, int contentLeng) throws IOException {

        StringWriter postRequest = new StringWriter();
        char[] buffer = new char[bufferSize];
        int charToWrite = 0;
        while ((charToWrite = rq.read(buffer)) != -1) {
            postRequest.write(buffer, 0, charToWrite);
            if (charToWrite == contentLeng) {
                break;
            }
        }
        return postRequest.toString();
    }
}
