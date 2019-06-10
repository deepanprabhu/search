package com.jxpath;

import org.apache.commons.jxpath.Container;

public class Document {
    private Container doc = null;

    public Container getDoc(){
        if(null == doc) {
            doc =new JsonContainer();
        }
        return doc;
    }
}
