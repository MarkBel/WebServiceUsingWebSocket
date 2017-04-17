package com.epam.utils.xstream;

import com.epam.bean.Book;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.util.List;

/**
 * Created by Mark_Rudak on 4/14/2017.
 */
public class XmlUtils {

    public static String parseToXml(List books)
    {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("Books",List.class);
        return xstream.toXML(books);
    }

    public static Book parseFromXml(String xml)
    {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("Book", Book.class);
        return (Book)xstream.fromXML(xml);
    }

}
