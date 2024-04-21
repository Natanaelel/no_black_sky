package net.natte.no_black_sky.mixin.client;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.math.Vec3d;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin {
	
	@Redirect(method = "renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
			at = @At(value = "FIELD", target = "Lnet/minecraft/util/math/Vec3d;y:D", ordinal = 1))
	double getCameraHeight(Vec3d cameraPosition){
		// y must be greater than 63. To be safe I put a number that is known to be much larger than 63.
		return 100_000d;
	}
}