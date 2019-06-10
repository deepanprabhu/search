package com.search.application;

import com.data.loader.JsonLoader;
import com.display.PrettyPrinter;
import org.apache.commons.jxpath.JXPathNotFoundException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        try {
            if (args.length == 0 || args.length > 2) {
                System.out.println("Usage: help");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                System.out.println("Usage: search <search-query-xpath>");
                System.out.println(JsonLoader.getResourceFileAsString("schema.txt"));
            } else if (args.length == 2 && args[0].equalsIgnoreCase("search")) {
                try {
                    PrettyPrinter.print(Query.query(args[1]));
                }
                catch(JXPathNotFoundException exception){
                    System.out.println("Your search query seems invalid - Please retry with right query");
                }
            } else {
                System.out.println("Usage: help");
                System.out.println("Usage: search <search-query-xpath>");
            }
        }
        catch(Exception error){
            System.out.println(error);
            System.out.println("Unhandled Exception - " + error.getMessage());
        }
    }
}
