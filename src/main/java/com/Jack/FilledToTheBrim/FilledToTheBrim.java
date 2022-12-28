package com.Jack.FilledToTheBrim;





import static net.minecraft.server.command.CommandManager.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilledToTheBrim implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("FilledToTheBrim");
    //Maybe a Main Toggle in the Future?
    //TODAY IS THE FUTURE
    public static boolean IS_ENABLED = true;




    @Override
    public void onInitialize() {
        LOGGER.info("[Filled To the Brim]: Loaded!");


        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {



            dispatcher.register(literal("FilledToTheBrim").requires(c -> c.hasPermissionLevel(4))


                .then(literal("enable").executes(c -> {
                IS_ENABLED = true;
                c.getSource().sendMessage(Text.literal("Filled To The Brim §aEnabled§f!"));
                    return 1;
                })).then(literal("disable").executes(c-> {
                    IS_ENABLED = false;
                    c.getSource().sendMessage(Text.literal("Filled To The Brim §cDisabled§f!"));

                    return 1;
                }))
                .executes(context -> {
                    // For versions below 1.19, replace "Text.literal" with "new LiteralText".
                    context.getSource().sendMessage(Text.literal("§cCalled /FilledToTheBrim with no arguments \n§aDo you want to Disable Or Enable The Mod? if so use /FilledToTheBrim [enable | disable]"));
                    return 1;
                }));});



    }
}



