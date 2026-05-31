package net.fahim.fahimsrpgmod.mixin;

import net.fahim.fahimsrpgmod.sound.ModSounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.Registries;
import net.minecraft.sound.MusicSound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MusicTrackerMixin {

    @Inject(method = "getMusicType", at = @At("HEAD"), cancellable = true)
    private void replaceMusic(CallbackInfoReturnable<MusicSound> cir) {
        cir.setReturnValue(new MusicSound(
                Registries.SOUND_EVENT.getEntry(ModSounds.BACKGROUND_MUSIC),
                0, 0, true
        ));
    }
}