package com.Jack.FilledToTheBrim;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilledToTheBrim {

    public static final Logger LOGGER = LoggerFactory.getLogger("FilledToTheBrim");

    public static boolean IS_ENABLED = true;



    public static void enable() {
        IS_ENABLED = true;
    }
    public static void disable() {
        IS_ENABLED = false;
    }
    public static void toggleEnabled() {
        IS_ENABLED = !IS_ENABLED;
    }


}