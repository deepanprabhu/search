package com.search.application;

import com.jxpath.Document;
import org.apache.commons.jxpath.JXPathContext;

/**
 * Static Query wrapper class
 */
public class Query {
    static JXPathContext context = JXPathContext.newContext(new Document());
    public static Object query(String queryString){
        return context.getValue(queryString);
    }
}
