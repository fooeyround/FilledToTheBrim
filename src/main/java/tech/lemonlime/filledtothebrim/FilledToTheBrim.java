/*
 * This file is part of the TemplateMod project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2023  Fallen_Breath and contributors
 *
 * TemplateMod is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TemplateMod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with TemplateMod.  If not, see <https://www.gnu.org/licenses/>.
 */

package tech.lemonlime.filledtothebrim;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.resource.ResourceManager;
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


		//#if MC < 11700
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
