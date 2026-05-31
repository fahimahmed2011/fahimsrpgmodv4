package net.fahim.fahimsrpgmod.util;

import net.fahim.fahimsrpgmod.item.custom.KaupenBowItem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

public class KaupenBowHudRenderer {

    public static void register() {
        HudRenderCallback.EVENT.register((drawContext, tickDeltaManager) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;

            ItemStack stack = client.player.getActiveItem();
            if (!(stack.getItem() instanceof KaupenBowItem)) return;

            float progress = KaupenBowItem.drawProgress;
            if (progress <= 0f) return;

            int screenWidth = client.getWindow().getScaledWidth();
            int screenHeight = client.getWindow().getScaledHeight();

            // Max bar height is 40% of screen height
            int maxBarHeight = (int) (screenHeight * 0.2f);
            int barHeight = (int) (maxBarHeight * progress);

            int alpha = (int) (255 * progress);
            int color = (alpha << 24); // black with dynamic alpha

            // Top bar
            drawContext.fill(0, 0, screenWidth, barHeight, color);
            // Bottom bar
            drawContext.fill(0, screenHeight - barHeight, screenWidth, screenHeight, color);
        });
    }
}