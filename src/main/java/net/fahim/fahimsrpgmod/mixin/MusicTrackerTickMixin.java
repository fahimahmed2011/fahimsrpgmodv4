package net.fahim.fahimsrpgmod.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.client.sound.SoundInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MusicTracker.class)
public class MusicTrackerTickMixin {

    @Shadow private int timeUntilNextSong;
    @Shadow private SoundInstance current;

    private float lastMusicVolume = -1f;

    @Inject(method = "tick", at = @At("HEAD"))
    private void forceRestart(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        float currentVolume = client.options.getSoundVolume(net.minecraft.sound.SoundCategory.MUSIC);

        // Detect volume going from 0 back up
        if (lastMusicVolume == 0f && currentVolume > 0f) {
            this.current = null;
            this.timeUntilNextSong = 0;
        }

        lastMusicVolume = currentVolume;
    }
}