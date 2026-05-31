package net.fahim.fahimsrpgmod.item.custom;

import net.fahim.fahimsrpgmod.block.ModBlocks;
import net.fahim.fahimsrpgmod.component.ModDataComponentTypes;
import net.fahim.fahimsrpgmod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP=
            new HashMap<>(Map.ofEntries(
                    // Stone types
                    Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
                    Map.entry(Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE),
                    Map.entry(Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_STONE_BRICKS),
                    Map.entry(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS),
                    Map.entry(Blocks.SAND, Blocks.SANDSTONE),
                    Map.entry(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE),
                    Map.entry(Blocks.RED_SAND, Blocks.RED_SANDSTONE),
                    Map.entry(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE),
                    Map.entry(Blocks.GRAVEL, Blocks.COARSE_DIRT),
                    Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                    Map.entry(Blocks.NETHERRACK, Blocks.NETHER_BRICKS),
                    Map.entry(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE),
                    Map.entry(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS),
                    Map.entry(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE),
                    Map.entry(Blocks.BASALT, Blocks.POLISHED_BASALT),
                    Map.entry(Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK),
                    Map.entry(Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR),
                    Map.entry(Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE),
                    Map.entry(Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                    Map.entry(Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES),
                    Map.entry(Blocks.DEEPSLATE_TILES, Blocks.CHISELED_DEEPSLATE),
                    Map.entry(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS),
                    Map.entry(Blocks.PRISMARINE_BRICKS, Blocks.DARK_PRISMARINE),
                    Map.entry(Blocks.SNOW_BLOCK, Blocks.PACKED_ICE),
                    Map.entry(Blocks.PACKED_ICE, Blocks.BLUE_ICE),
                    Map.entry(Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN),
                    Map.entry(Blocks.GOLD_BLOCK, Blocks.BEDROCK),

                    // Dirt/Nature
                    Map.entry(Blocks.DIRT, Blocks.DIRT_PATH),
                    Map.entry(Blocks.GRASS_BLOCK, Blocks.DIRT),
                    Map.entry(Blocks.MYCELIUM, Blocks.DIRT),
                    Map.entry(Blocks.PODZOL, Blocks.DIRT),
                    Map.entry(Blocks.ROOTED_DIRT, Blocks.DIRT),

                    // Logs → Stripped
                    Map.entry(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG),
                    Map.entry(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG),
                    Map.entry(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG),
                    Map.entry(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG),
                    Map.entry(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG),
                    Map.entry(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG),
                    Map.entry(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG),
                    Map.entry(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG),
                    Map.entry(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK),
                    Map.entry(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM),
                    Map.entry(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM),

                    // Wood → Stripped
                    Map.entry(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD),
                    Map.entry(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD),
                    Map.entry(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD),
                    Map.entry(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD),
                    Map.entry(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD),
                    Map.entry(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD),
                    Map.entry(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD),
                    Map.entry(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD),
                    Map.entry(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE),
                    Map.entry(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)

            ));


    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());
                context.getStack().damage(1,((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item->context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), ModSounds.CHISEL_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());

            }
        }

            return ActionResult.SUCCESS;

        }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
          tooltip.add(Text.translatable("tooltip.fahimsrpgmod.chisel.shift_down"));
        }else {
            tooltip.add(Text.translatable("tooltip.fahimsrpgmod.chisel"));
        }
        if(stack.get(ModDataComponentTypes.COORDINATES) !=null) {
            tooltip.add(Text.literal("Last Block Changed at" + stack.get(ModDataComponentTypes.COORDINATES)));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}