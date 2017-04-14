package com.epam.handler;

import com.epam.bean.Book;
import com.epam.constants.GlobalConstants;
import com.epam.storage.BookStore;
import com.epam.logic.Request;
import com.epam.logic.Response;
import com.epam.utils.jackson.JsonUtils;
import com.epam.utils.xstream.XmlUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class GetBooksImpl implements IHandler {



    @Override
    public void handle(Request rq, Response rp) throws IOException {

        String body = "";
        String contentType = rq.getContentType();
        rp.setContentType(contentType);
        List<Book> books = new BookStore().getAllBooks();

        if (contentType.equals(GlobalConstants.CONTENT_TYPE_XML_VVALUE)) {
            body = XmlUtils.parseToXml(books);
        }else{
         body = JsonUtils.toJson(books);
        }

        rp.setContentLength(String.valueOf(body.getBytes().length));
        rp.setBody(body);
        rp.setVersion(rq.getVersion());
        rp.setStatusCode(GlobalConstants.STATUS_CODE_200_OK);




        try {
            rp.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
