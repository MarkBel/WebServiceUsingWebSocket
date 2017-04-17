package com.epam.handler.command;

import com.epam.bean.Book;
import com.epam.constants.GlobalConstants;
import com.epam.storage.BookStore;
import com.epam.transport.Request;
import com.epam.transport.Response;
import com.epam.utils.jackson.JsonUtils;
import com.epam.utils.xstream.XmlUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class GetBooksImpl implements ICommand {



    @Override
    public void handle(Request rq, Response rp) throws IOException {

        String body = "";

        //If content type is null, default value will be application/json
        String contentType = rq.validateContentType(rq.getContentType());

        List<Book> books = new BookStore().getAllBooks();

        try {
            if (contentType.equals(GlobalConstants.CONTENT_TYPE_XML_VALUE)) {
                body = XmlUtils.parseToXml(books);
            }else{
                body = JsonUtils.toJson(books);
            }
            rp.setStatusCode(GlobalConstants.STATUS_CODE_200_OK);
        }catch (Exception e){
            rp.setStatusCode(GlobalConstants.STATUS_CODE_404);
        }

        rp.setContentType(contentType);
        rp.setContentLength(String.valueOf(body.getBytes().length));
        rp.setBody(body);
        rp.setVersion(rq.getVersion());
        rp.write();
    }

}
