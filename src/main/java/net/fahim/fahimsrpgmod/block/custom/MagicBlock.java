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

                int random = world.getRandom().nextInt(1000);

                Item reward;

                if (random < 300) {
                    reward = Items.DIRT;            // 30%

                } else if (random < 530) {

                    reward = Items.COAL_BLOCK;      // 23%
                } else if (random < 930) {

                    reward = Items.GOLD_BLOCK;      // 40%
                } else if (random < 990) {

                    reward = Items.DIAMOND_BLOCK;   // 6%
                } else if (random < 999) {

                    reward = Items.NETHERITE_BLOCK; // 0.9%
                } else {

                    reward = Items.BEDROCK;         // 0.1%
                }

                itemEntity.setStack(new ItemStack(reward, itemEntity.getStack().getCount()));
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}