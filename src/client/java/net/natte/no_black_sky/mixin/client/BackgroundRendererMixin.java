package net.natte.no_black_sky.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.util.math.Vec3d;

@Mixin(BackgroundRenderer.class)
public abstract class BackgroundRendererMixin {
    @ModifyExpressionValue(method = "render(Lnet/minecraft/client/render/Camera;FLnet/minecraft/client/world/ClientWorld;IF)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;getPos()Lnet/minecraft/util/math/Vec3d;", ordinal = 3))
    private static Vec3d getCameraPos(Vec3d originalCamerapos){
		// y must be greater than or equal to 32. To be safe I put a number that is known to be much larger than 32.
        return new Vec3d(0, 100_000, 0);
    }
}
