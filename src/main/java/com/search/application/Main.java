package com.search.application;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Usage: help");
        } else if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
            System.out.println("Usage: search <search-query-xpath>");
        }
    }
}
