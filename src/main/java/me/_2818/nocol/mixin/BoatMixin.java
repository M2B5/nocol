package me._2818.nocol.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BoatEntity.class)
public abstract class BoatMixin {
    @Inject(method = "collidesWith", at = @At("HEAD"), cancellable = true)
    void canCollideHook(Entity other, CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(false);
        ci.cancel();
    }
}