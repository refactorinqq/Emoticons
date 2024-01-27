package mchorse.emoticons.mixin;

import mchorse.emoticons.AnimatorController;
import mchorse.emoticons.EmoteControllerManager;
import mchorse.emoticons.PlayerModelManager;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author refactoring
 */
@Mixin(EntityPlayer.class)
public class EntityPlayerMixin {
    @Unique
    public AnimatorController controller;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void ae$init(CallbackInfo ci) {
        controller = new AnimatorController(PlayerModelManager.get().steve, PlayerModelManager.get().steveConfig);
        EmoteControllerManager.controllers.put((EntityPlayer) (Object) this, controller);
    }

    @Inject(method = "onUpdate", at = @At("RETURN"))
    public void ae$onUpdate(CallbackInfo ci) {
        controller.update((EntityPlayer) (Object) this);
    }
}