package net.fahim.fahimsrpgmod.block.custom;

import net.minecraft.item.Item;
import net.fahim.fahimsrpgmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 6f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == ModItems.RAW_PINK_GARNET) {

                int random = world.getRandom().nextInt(100);

                Item reward;
                if (random < 70) {
                    reward = Items.DIRT;

                } else if (random < 80) {
                    reward = Items.COAL_BLOCK;

                } else if (random < 90) {
                    reward = Items.GOLD_BLOCK;

                } else if (random < 95) {
                    reward = Items.OBSIDIAN;

                } else if (random < 98) {
                    reward = Items.DIAMOND_BLOCK;


                } else {
                reward = Items.NETHERITE_BLOCK;
            }

                itemEntity.setStack(new ItemStack(reward, itemEntity.getStack().getCount()));
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}