package net.fahim.fahimsrpgmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fahim.fahimsrpgmod.datagen.*;
import net.fahim.fahimsrpgmod.enchantment.ModEnchantments;
import net.fahim.fahimsrpgmod.trim.ModTrimMaterials;
import net.fahim.fahimsrpgmod.trim.ModTrimPatterns;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class FahimsRPGModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
         FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		 pack.addProvider(ModBlockTagProvider::new);
		 pack.addProvider(ModItemTagProvider::new);
		 pack.addProvider(ModLootTableProvider::new);
		 pack.addProvider(ModModelProvider::new);
		 pack.addProvider(ModRecipeProvider::new);

		 pack.addProvider(ModRegistryDataGenerator::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
     registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
     registryBuilder.addRegistry(RegistryKeys.TRIM_PATTERN, ModTrimPatterns::bootstrap);
	 registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);

	}
}
