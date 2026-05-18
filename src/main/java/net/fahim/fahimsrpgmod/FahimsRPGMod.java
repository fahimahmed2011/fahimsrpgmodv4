package net.fahim.fahimsrpgmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.item.ModItemGroups;
import net.fahim.fahimsrpgmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FahimsRPGMod implements ModInitializer {
	public static final String MOD_ID = "fahimsrpgmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registeritemgroups();
		ModItems.registerModitems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,500);

	}
}