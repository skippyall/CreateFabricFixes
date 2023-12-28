package io.github.skippyall.createfabricfixes;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFabricFixes implements ModInitializer {
	public static final String ID = "createfabricfixes";
	public static final String NAME = "Create Fabric Fixes";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Create Fabric Fixes!");
	}

}
