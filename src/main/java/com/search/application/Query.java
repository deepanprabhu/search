package com.search.application;

import com.jxpath.Document;
import org.apache.commons.jxpath.JXPathContext;

/**
 * Static Query wrapper class
 */
public class Query {

    static JXPathContext context = JXPathContext.newContext(new Document());

    /**
     * This method takes a query and returns the resultSet
     * @param queryString
     * @return resultSet as Object
     */
    public static Object query(String queryString){
        return context.getValue(queryString);
    }
}
