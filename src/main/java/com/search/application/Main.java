package com.search.application;

import com.data.loader.JsonLoader;
import com.display.PrettyPrinter;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        try {
            if (args.length == 0 || args.length > 2) {
                System.out.println("Usage: help");
            } else if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                System.out.println("Usage: search <search-query-xpath>");
                System.out.println(JsonLoader.getResourceFileAsString("schema.txt"));
            } else if (args.length == 2 && args[0].equalsIgnoreCase("search")) {
                PrettyPrinter.print(Query.query(args[1]));
            } else {
                System.out.println("Usage: help");
                System.out.println("Usage: search <search-query-xpath>");
            }
        } catch (Exception error) {
            System.out.println(error);
            System.out.println("Program has an Error - " + error);
        }
    }
}
