package com.search.application;

import com.display.PrettyPrinter;
import com.jxpath.Document;
import org.apache.commons.jxpath.JXPathContext;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args)throws FileNotFoundException {
        JXPathContext context = JXPathContext.newContext(new Document());
        PrettyPrinter.print(context.getValue("document/users[position() < 3]"));
    }
}
