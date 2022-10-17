package io.github.xniter.wetternether.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.world.level.dimension.DimensionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({DimensionType.class})
abstract class DimensionTypeMixin {

    @Shadow @Final private boolean ultraWarm;

    @Inject(method = "ultraWarm", at = @At(value = "RETURN"), cancellable = true)
    public void wetternether_Ultrawarm(CallbackInfoReturnable<Boolean> paramCallbackInfoReturnable) {
        if (this.ultraWarm) {
            paramCallbackInfoReturnable.setReturnValue(Boolean.FALSE);
        }
    }
}
