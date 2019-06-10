package com.display;

/**
 * Basic Pretty printer - for custom display on console
 */
public class PrettyPrinter {
    private PrettyPrinter(){

    }
    public static void print(Object object){
        int counter = 0;
        if(object != null && object.getClass().isArray()) {
            Object[] objects = (Object []) object;
            System.out.println("********");
            for(Object anObject : objects){
                System.out.println(String.format("Result : %d", counter));
                System.out.println(anObject);
                counter++;
                System.out.println("********");
            }
        }
        else{
            System.out.println(object);
        }
    }
}
