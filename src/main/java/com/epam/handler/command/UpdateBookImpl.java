package com.epam.handler.command;

import com.epam.bean.Book;
import com.epam.constants.GlobalConstants;
import com.epam.transport.Request;
import com.epam.transport.Response;
import com.epam.storage.BookStore;
import com.epam.utils.jackson.JsonUtils;

import java.io.IOException;

/**
 * Created by Mark_Rudak on 4/13/2017.
 */
public class UpdateBookImpl implements ICommand {

    @Override
    public void handle(Request rq, Response rp) throws IOException {

        Book bookUpdated = null;
        try {
            bookUpdated = JsonUtils.fromJson(rq.getBody(), Book.class);
            BookStore.updateBook(bookUpdated);
            rp.setStatusCode(GlobalConstants.STATUS_CODE_200_OK);
        } catch (Exception ex) {
            rp.setStatusCode(GlobalConstants.STATUS_CODE_404);
        }
        rp.createResponse(rp,rq);
    }
}
