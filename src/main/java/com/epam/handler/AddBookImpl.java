package com.epam.handler;

import com.epam.bean.Book;
import com.epam.constants.GlobalConstants;
import com.epam.storage.BookStore;
import com.epam.logic.Request;
import com.epam.logic.Response;
import com.epam.utils.jackson.JsonUtils;
import com.epam.utils.xstream.XmlUtils;
import com.sun.javaws.jnl.XMLUtils;

import java.io.IOException;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class AddBookImpl implements IHandler {

    @Override
    public  void handle(Request rq, Response rp) throws IOException {

        Book bookAdded = null;
        String contentType = rq.getContentType();
        rp.setContentType(contentType);
        try {
            if (contentType.equals(GlobalConstants.CONTENT_TYPE_XML_VVALUE)) {
                bookAdded = XmlUtils.parseFromXml(rq.getBody());
            }else{
                bookAdded = JsonUtils.fromJson(rq.getBody(), Book.class);
            }
            BookStore.addBook(bookAdded);
            rp.setStatusCode(GlobalConstants.STATUS_CODE_201);
        } catch (Exception ex) {
            rp.setStatusCode(GlobalConstants.STATUS_CODE_400);
        }
        rp.createResponse(rp,rq);
    }
}
