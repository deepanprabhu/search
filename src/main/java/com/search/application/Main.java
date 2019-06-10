package com.search.application;

import com.google.gson.Gson;
import com.jxpath.Document;
import org.apache.commons.jxpath.JXPathContext;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args)throws FileNotFoundException {
        JXPathContext context = JXPathContext.newContext(new Document());
        context.getValue("document/tickets");
        System.out.println("Hi");
    }
}
