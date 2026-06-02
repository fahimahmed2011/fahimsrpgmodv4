package net.fahim.fahimsrpgmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.component.ModDataComponentTypes;
import net.fahim.fahimsrpgmod.enchantment.ModEnchantmentEffects;
import net.fahim.fahimsrpgmod.item.ModItemGroups;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.fahim.fahimsrpgmod.potion.ModPotions;
import net.fahim.fahimsrpgmod.sound.ModSounds;
import net.fahim.fahimsrpgmod.util.HammerUsageEvent;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fahim.fahimsrpgmod.effect.ModEffects;

public class FahimsRPGMod implements ModInitializer {
	public static final String MOD_ID = "fahimsrpgmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registeritemgroups();
		ModItems.registerModitems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		ModEnchantmentEffects.registerModEnchantmentEffects();



		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,500);


		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});

	}
}