package com.search.application;

import com.jxpath.Document;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathNotFoundException;

import java.util.Iterator;

/**
 * Static Query wrapper class
 */
public class Query {

    static JXPathContext context = JXPathContext.newContext(new Document());

    /**
     * This method takes a query and returns the resultSet
     *
     * @param queryString
     * @return resultSet as Object
     */
    public static Iterator query(String queryString) {
        try {
            context.getValue(queryString);
            return context.iterate(queryString);
        } catch (JXPathNotFoundException exception) {
            System.out.println("Your search query seems invalid - Please retry with right query" +
                    "\nSome reasons are \n1) Wrong xpath operator,\n2) Non existent attribute in schema");
        }
        return null;
    }
}
