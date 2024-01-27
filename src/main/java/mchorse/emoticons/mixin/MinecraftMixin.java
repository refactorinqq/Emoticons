package mchorse.emoticons.mixin;

import mchorse.emoticons.EmoticonsMod;
import mchorse.emoticons.PlayerModelManager;
import mchorse.emoticons.ui.ScreenEmoteWheel;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author refactoring
 */
@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "runTick", at = @At("RETURN"))
    public void mchorse$runTick(CallbackInfo ci) {
        if(EmoticonsMod.INSTANCE.keyBinding.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new ScreenEmoteWheel());
        }
    }

    @Inject(method = "startGame", at = @At("RETURN"))
    public void mchorse$startGame(CallbackInfo ci) {
        PlayerModelManager.get();
    }
}
