package com.jxpath;

import org.apache.commons.jxpath.Container;

public class Document {
    private Container document = null;

    public Container getDocument(){
        if(null == document) {
            document =new JsonContainer();
        }
        return document;
    }
}
