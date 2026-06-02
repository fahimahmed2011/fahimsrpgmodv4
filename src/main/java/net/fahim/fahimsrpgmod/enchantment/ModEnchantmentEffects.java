package net.fahim.fahimsrpgmod.enchantment;

import com.mojang.serialization.MapCodec;
import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.enchantment.custom.LightningStrikerEnchantmetEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<?extends EnchantmentEntityEffect> LIGHTNING_STRIKER
            = registryEnitityEffect("lightning_striker", LightningStrikerEnchantmetEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registryEnitityEffect(String name,
                                                                                     MapCodec<?extends EnchantmentEntityEffect>codec){
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(FahimsRPGMod.MOD_ID,name),codec);
    }



public static void registerModEnchantmentEffects(){
    FahimsRPGMod.LOGGER.info("Registering Mod Enchantment Effects for "+ FahimsRPGMod.MOD_ID);
    }
}
