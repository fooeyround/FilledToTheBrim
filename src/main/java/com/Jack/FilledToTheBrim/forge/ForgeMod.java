package com.Jack.FilledToTheBrim.forge;

import com.Jack.FilledToTheBrim.FilledToTheBrim;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ForgeMod.MODID)
public class ForgeMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "filledtothebrim";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public ForgeMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);



    }

    private void commonSetup(final FMLCommonSetupEvent event) {



    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {


    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ModEvents {
        @SubscribeEvent
        public static void onCommandRegister(RegisterCommandsEvent event) {

            registerConfigCommand(event.getDispatcher());
        }

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


        }
    }











    public static void registerConfigCommand(CommandDispatcher<CommandSourceStack> dispatcher) {




        dispatcher.register(Commands.literal("FilledToTheBrim").requires(c -> c.hasPermission(4))


                .then(Commands.literal("enable").executes(c -> {
                    FilledToTheBrim.enable();
                    c.getSource().sendSystemMessage(Component.literal("Filled To The Brim §aEnabled§f!"));
                    return 1;
                })).then(Commands.literal("disable").executes(ctx-> {
                    FilledToTheBrim.disable();
                    ctx.getSource().sendSystemMessage(Component.literal("Filled To The Brim §cDisabled§f!"));

                    return 1;
                }))
                .executes(context -> {
                    context.getSource().sendSystemMessage(Component.literal("§cCalled /FilledToTheBrim with no arguments \n§aDo you want to Disable Or Enable The Mod? if so use /FilledToTheBrim [enable | disable]"));
                    return 1;
                }));}






}


