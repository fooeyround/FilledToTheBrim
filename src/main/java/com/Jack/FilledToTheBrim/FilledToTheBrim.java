package com.Jack.FilledToTheBrim;




import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilledToTheBrim implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("FilledToTheBrim");
    //Maybe a Main Toggle in the Future?
    public static boolean IS_ENABLED = true;




    @Override
    public void onInitialize() {
        LOGGER.info("[Filled To the Brim]: Loaded!");

    }
}



