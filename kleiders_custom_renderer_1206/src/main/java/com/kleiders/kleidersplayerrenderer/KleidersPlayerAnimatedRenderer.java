/*
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside com.kleiders.kleidersplayerrenderer as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package com.kleiders.kleidersplayerrenderer;

import net.neoforged.fml.ModList;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.EntityModel;

import javax.annotation.Nullable;

import dev.kosmx.playerAnim.impl.IAnimatedPlayer;
import dev.kosmx.playerAnim.core.util.Vec3f;
import dev.kosmx.playerAnim.api.TransformType;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;

@OnlyIn(Dist.CLIENT)
public class KleidersPlayerAnimatedRenderer extends LivingEntityRenderer<AbstractClientPlayer, EntityModel<AbstractClientPlayer>> implements KleidersIgnoreCancel {
	private final ResourceLocation PLAYER_SKIN;

	public KleidersPlayerAnimatedRenderer(EntityRendererProvider.Context context, ResourceLocation skin, EntityModel newmodel) {
		super(context, new PigModel(context.bakeLayer(ModelLayers.PIG)), 0.5F);
		this.PLAYER_SKIN = skin;
		this.model = newmodel;
	}

	@Override
	@Nullable
	protected RenderType getRenderType(AbstractClientPlayer p_115322_, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
		ResourceLocation resourcelocation = this.getTextureLocation(p_115322_);
		return RenderType.entityTranslucentCull(resourcelocation);
	}

	@Override
	public ResourceLocation getTextureLocation(AbstractClientPlayer entity) {
		return PLAYER_SKIN;
	}

	@Override
	public void render(AbstractClientPlayer entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		try {
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		} catch (Exception e) {
			matrixStackIn.popPose();
		}
	}

	@Override
	public Vec3 getRenderOffset(AbstractClientPlayer p_117785_, float p_117786_) {
		return p_117785_.isCrouching() ? new Vec3(0.0D, -0.125D, 0.0D) : super.getRenderOffset(p_117785_, p_117786_);
	}

	@Override
	protected void setupRotations(AbstractClientPlayer p_117802_, PoseStack p_117803_, float p_117804_, float p_117805_, float p_117806_, float p_320048_) {
		float f = p_117802_.getSwimAmount(p_117806_);
		float f1 = p_117802_.getViewXRot(p_117806_);
		if (p_117802_.isFallFlying()) {
			super.setupRotations(p_117802_, p_117803_, p_117804_, p_117805_, p_117806_, p_320048_);
			float f2 = (float) p_117802_.getFallFlyingTicks() + p_117806_;
			float f3 = Mth.clamp(f2 * f2 / 100.0F, 0.0F, 1.0F);
			if (!p_117802_.isAutoSpinAttack()) {
				p_117803_.mulPose(Axis.XP.rotationDegrees(f3 * (-90.0F - f1)));
			}
			Vec3 vec3 = p_117802_.getViewVector(p_117806_);
			Vec3 vec31 = p_117802_.getDeltaMovementLerped(p_117806_);
			double d0 = vec31.horizontalDistanceSqr();
			double d1 = vec3.horizontalDistanceSqr();
			if (d0 > 0.0 && d1 > 0.0) {
				double d2 = (vec31.x * vec3.x + vec31.z * vec3.z) / Math.sqrt(d0 * d1);
				double d3 = vec31.x * vec3.z - vec31.z * vec3.x;
				p_117803_.mulPose(Axis.YP.rotation((float) (Math.signum(d3) * Math.acos(d2))));
			}
		} else if (f > 0.0F) {
			super.setupRotations(p_117802_, p_117803_, p_117804_, p_117805_, p_117806_, p_320048_);
			float f4 = p_117802_.isInWater() || p_117802_.isInFluidType((fluidType, height) -> p_117802_.canSwimInFluidType(fluidType)) ? -90.0F - p_117802_.getXRot() : -90.0F;
			float f5 = Mth.lerp(f, 0.0F, f4);
			p_117803_.mulPose(Axis.XP.rotationDegrees(f5));
			if (p_117802_.isVisuallySwimming()) {
				p_117803_.translate(0.0F, -1.0F, 0.3F);
			}
		} else {
			super.setupRotations(p_117802_, p_117803_, p_117804_, p_117805_, p_117806_, p_320048_);
		}
		if (ModList.get().isLoaded("playeranimator")) {
			var animationPlayer = ((IAnimatedPlayer) p_117802_).playerAnimator_getAnimation();
			animationPlayer.setTickDelta(p_117806_);
			if (animationPlayer.isActive()) {
				//These are additive properties
				Vec3f vec3d = animationPlayer.get3DTransform("body", TransformType.POSITION, Vec3f.ZERO);
				p_117803_.translate(vec3d.getX(), vec3d.getY() + 0.7, vec3d.getZ());
				Vec3f vec3f = animationPlayer.get3DTransform("body", TransformType.ROTATION, Vec3f.ZERO);
				p_117803_.mulPose(Axis.ZP.rotation(vec3f.getZ())); //roll
				p_117803_.mulPose(Axis.YP.rotation(vec3f.getY())); //pitch
				p_117803_.mulPose(Axis.XP.rotation(vec3f.getX())); //yaw
				p_117803_.translate(0, -0.7d, 0);
			}
		}
	}
}
