package com.jxpath;

import org.apache.commons.jxpath.Container;

/**
 * Basic document class - JXPath query's doc retrives this document container
 */
public class Document {
    private Container doc = null;

    public Container getDoc() {
        if (null == doc) {
            doc = new JsonContainer();
        }
        return doc;
    }
}
