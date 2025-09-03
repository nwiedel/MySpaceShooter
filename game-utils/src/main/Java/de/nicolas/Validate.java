package de.nicolas;

public class Validate {

    private static final String DEFAULT_IS_NULL_MESSAGE =  "Das validierte Objekt ist null!";

    private Validate(){}

    public static <T> void notNull(T object){
        notNull(object, DEFAULT_IS_NULL_MESSAGE);
    }

    public static <T> void notNull(T object, String message){
        if (object == null){
            throw new NullPointerException(message);
        }
    }
}
