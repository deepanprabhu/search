package com.jxpath;

import org.apache.commons.jxpath.Container;

public class Document {
    private Container documentContainer = null;

    public Container getDocumentContainer(){
        if(null == documentContainer) {
            documentContainer =new JsonContainer();
        }
        return documentContainer;
    }
}
