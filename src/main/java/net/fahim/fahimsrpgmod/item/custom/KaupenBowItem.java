package net.fahim.fahimsrpgmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class KaupenBowItem extends BowItem {

    public static float drawProgress = 0f;

    public KaupenBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        super.usageTick(world, user, stack, remainingUseTicks);
        if (world.isClient()) {
            int usedTicks = getMaxUseTime(stack, user) - remainingUseTicks;
            drawProgress = Math.min(usedTicks / 20f, 1f);
        }
    }
    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
        if (world.isClient()) {
            drawProgress = 0f;
        }
    }
}