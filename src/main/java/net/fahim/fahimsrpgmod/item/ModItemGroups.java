package net.fahim.fahimsrpgmod.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fahim.fahimsrpgmod.FahimsRPGMod;
import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup PINK_GARNET_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FahimsRPGMod.MOD_ID,"pinm_garnet_items"),
            FabricItemGroup.builder().icon(() ->new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.fahimsrpgmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.PINK_GARNET);
                    }).build());

    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FahimsRPGMod.MOD_ID,"pinm_garnet_blocks"),
            FabricItemGroup.builder().icon(() ->new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.fahimsrpgmod.pink_garnet_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModItems.CHISEL);



                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());


    public static void registeritemgroups() {
        FahimsRPGMod.LOGGER.info("registering Item Groups for" + FahimsRPGMod.MOD_ID);

    }
}







