package com.Jack.FilledToTheBrim;




import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilledToTheBrim implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("FilledToTheBrim");
    //Maybe a Main Toggle in the Future?
    public static boolean IS_ENABLED = true;




    @Override
    public void onInitialize() {
        LOGGER.info("[Filled To the Brim]: Loaded!");

    }
}



