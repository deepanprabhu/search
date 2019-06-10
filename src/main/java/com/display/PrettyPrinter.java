package com.display;

import java.util.Iterator;

/**
 * Basic Pretty printer - for custom display on console
 */
public class PrettyPrinter {
    private PrettyPrinter() {

    }

    /**
     * Customize this method to change object display
     */
    public static void print(Iterator iterator) {
        int count = 0;

        while (iterator.hasNext()) {
            System.out.println("***** Result Start ********");
            System.out.println(iterator.next());
            System.out.println("***** Result End ********");
            count++;
        }
        System.out.println("No of Results - " + count);
    }
}
