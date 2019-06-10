package com.search.application;

import com.display.PrettyPrinter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        if (args.length == 0 || args.length > 2) {
            System.out.println("Usage: help");
        } else if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
            System.out.println("Usage: search <search-query-xpath>");
            System.out.println(new String(Files.readAllBytes(Paths.get(Main.class.getClassLoader().getResource("schema.txt").toURI())), StandardCharsets.US_ASCII));
        } else if (args.length == 1 && args[0].equalsIgnoreCase("search")) {
            PrettyPrinter.print(Query.query(args[1]));
        } else {
            System.out.println("Usage: help");
        }
    }
}
