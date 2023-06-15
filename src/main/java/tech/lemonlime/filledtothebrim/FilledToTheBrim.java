/*
 * This file is part of the FilledToTheBrim project, licensed under the MIT License
 *
 * Copyright 2023  Jack
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */



package tech.lemonlime.filledtothebrim;

import net.fabricmc.api.ModInitializer;
//#if MC >= 11600
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
//#endif
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilledToTheBrim implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("FilledToTheBrim");
	public static final String MODID = "filledtothebrim";
	public static String MOD_VERSION = "unknown";
	public static String MOD_NAME = "unknown";


	@Override
	public void onInitialize() {

		LOGGER.info("[Filled To the Brim]: Loading...");

		ModMetadata metadata = FabricLoader.getInstance().getModContainer(MODID).orElseThrow(RuntimeException::new).getMetadata();
		MOD_NAME = metadata.getName();
		MOD_VERSION = metadata.getVersion().getFriendlyString();

		ModTags.registerTags();

		//#if MC < 11600



		//#elseif MC < 11700
		//LEGACY main pack
		FabricLoader.getInstance().getModContainer(MODID).ifPresent(modContainer ->
				ResourceManagerHelper.registerBuiltinResourcePack(
						new Identifier(MODID,"enable_legacy"), modContainer,
						ResourcePackActivationType.DEFAULT_ENABLED));


		//LEGACY magenta pack..
		FabricLoader.getInstance().getModContainer(MODID).ifPresent(modContainer ->
				ResourceManagerHelper.registerBuiltinResourcePack(
						new Identifier(MODID,"disable_magenta_legacy"), modContainer,
						ResourcePackActivationType.NORMAL));



		//#else


		//main pack
		//$$ FabricLoader.getInstance().getModContainer(MODID).ifPresent(modContainer -> ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MODID,"enable"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED));


		//magenta pack..
		//$$ FabricLoader.getInstance().getModContainer(MODID).ifPresent(modContainer -> ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MODID,"disable_magenta"), modContainer, ResourcePackActivationType.NORMAL));


		//1.17+ bundle fix
		//$$ FabricLoader.getInstance().getModContainer(MODID).ifPresent(modContainer -> ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MODID,"bundle_fix"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED));


		//#endif

		LOGGER.info("[Filled To the Brim]: Loaded!");



	}
}
