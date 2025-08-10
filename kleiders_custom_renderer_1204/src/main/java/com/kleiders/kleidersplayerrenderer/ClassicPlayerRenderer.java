
/**
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

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.layers.SpinAttackEffectLayer;
import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.ParrotOnShoulderLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.Deadmau5EarsLayer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.CapeLayer;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import net.minecraft.client.renderer.entity.layers.ArrowLayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.HumanoidArmorModel;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;

@OnlyIn(Dist.CLIENT)
public class ClassicPlayerRenderer extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> implements KleidersIgnoreCancel {
	private final ResourceLocation PLAYER_SKIN;

	public ClassicPlayerRenderer(EntityRendererProvider.Context context, ResourceLocation skin) {
		this(context, false, skin);
	}

	public ClassicPlayerRenderer(EntityRendererProvider.Context context, boolean useSmallArms, ResourceLocation skin) {
		super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), useSmallArms), 0.5F);
		this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidArmorModel(context.bakeLayer(useSmallArms ? ModelLayers.PLAYER_SLIM_INNER_ARMOR : ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidArmorModel(context.bakeLayer(useSmallArms ? ModelLayers.PLAYER_SLIM_OUTER_ARMOR : ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new PlayerItemInHandLayer<>(this, context.getItemInHandRenderer()));
		this.addLayer(new ArrowLayer<>(context, this));
		this.addLayer(new Deadmau5EarsLayer(this));
		this.addLayer(new CapeLayer(this));
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ElytraLayer<>(this, context.getModelSet()));
		this.addLayer(new ParrotOnShoulderLayer<>(this, context.getModelSet()));
		this.addLayer(new SpinAttackEffectLayer<>(this, context.getModelSet()));
		this.addLayer(new BeeStingerLayer<>(this));
		this.PLAYER_SKIN = skin;
	}

	public void render(AbstractClientPlayer entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		this.setModelProperties(entityIn);
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	public Vec3 getRenderOffset(AbstractClientPlayer entityIn, float partialTicks) {
		return entityIn.isCrouching() ? new Vec3(0.0D, -0.125D, 0.0D) : super.getRenderOffset(entityIn, partialTicks);
	}

	private void setModelProperties(AbstractClientPlayer clientPlayer) {
		PlayerModel<AbstractClientPlayer> playermodel = this.getModel();
		if (clientPlayer.isSpectator()) {
			playermodel.setAllVisible(false);
			playermodel.head.visible = true;
			playermodel.hat.visible = true;
		} else {
			playermodel.setAllVisible(true);
			playermodel.hat.visible = clientPlayer.isModelPartShown(PlayerModelPart.HAT);
			playermodel.jacket.visible = clientPlayer.isModelPartShown(PlayerModelPart.JACKET);
			playermodel.leftPants.visible = clientPlayer.isModelPartShown(PlayerModelPart.LEFT_PANTS_LEG);
			playermodel.rightPants.visible = clientPlayer.isModelPartShown(PlayerModelPart.RIGHT_PANTS_LEG);
			playermodel.leftSleeve.visible = clientPlayer.isModelPartShown(PlayerModelPart.LEFT_SLEEVE);
			playermodel.rightSleeve.visible = clientPlayer.isModelPartShown(PlayerModelPart.RIGHT_SLEEVE);
			playermodel.crouching = clientPlayer.isCrouching();
			HumanoidModel.ArmPose bipedmodel$armpose = getArmPose(clientPlayer, InteractionHand.MAIN_HAND);
			HumanoidModel.ArmPose bipedmodel$armpose1 = getArmPose(clientPlayer, InteractionHand.OFF_HAND);
			if (bipedmodel$armpose.isTwoHanded()) {
				bipedmodel$armpose1 = clientPlayer.getOffhandItem().isEmpty() ? HumanoidModel.ArmPose.EMPTY : HumanoidModel.ArmPose.ITEM;
			}
			if (clientPlayer.getMainArm() == HumanoidArm.RIGHT) {
				playermodel.rightArmPose = bipedmodel$armpose;
				playermodel.leftArmPose = bipedmodel$armpose1;
			} else {
				playermodel.rightArmPose = bipedmodel$armpose1;
				playermodel.leftArmPose = bipedmodel$armpose;
			}
		}
	}

	private static HumanoidModel.ArmPose getArmPose(AbstractClientPlayer p_241741_0_, InteractionHand p_241741_1_) {
		ItemStack itemstack = p_241741_0_.getItemInHand(p_241741_1_);
		if (itemstack.isEmpty()) {
			return HumanoidModel.ArmPose.EMPTY;
		} else {
			if (p_241741_0_.getUsedItemHand() == p_241741_1_ && p_241741_0_.getUseItemRemainingTicks() > 0) {
				UseAnim useaction = itemstack.getUseAnimation();
				if (useaction == UseAnim.BLOCK) {
					return HumanoidModel.ArmPose.BLOCK;
				}
				if (useaction == UseAnim.BOW) {
					return HumanoidModel.ArmPose.BOW_AND_ARROW;
				}
				if (useaction == UseAnim.SPEAR) {
					return HumanoidModel.ArmPose.THROW_SPEAR;
				}
				if (useaction == UseAnim.CROSSBOW && p_241741_1_ == p_241741_0_.getUsedItemHand()) {
					return HumanoidModel.ArmPose.CROSSBOW_CHARGE;
				}
			} else if (!p_241741_0_.swinging && itemstack.getItem() == Items.CROSSBOW && CrossbowItem.isCharged(itemstack)) {
				return HumanoidModel.ArmPose.CROSSBOW_HOLD;
			}
			return HumanoidModel.ArmPose.ITEM;
		}
	}

	public ResourceLocation getTextureLocation(AbstractClientPlayer entity) {
		return PLAYER_SKIN;
	}

	protected void scale(AbstractClientPlayer entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
		float f = 0.9375F;
		matrixStackIn.scale(0.9375F, 0.9375F, 0.9375F);
	}

	public void renderRightHand(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, AbstractClientPlayer playerIn) {
		this.renderHand(matrixStackIn, bufferIn, combinedLightIn, playerIn, (this.model).rightArm, (this.model).rightSleeve);
	}

	public void renderLeftHand(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, AbstractClientPlayer playerIn) {
		this.renderHand(matrixStackIn, bufferIn, combinedLightIn, playerIn, (this.model).leftArm, (this.model).leftSleeve);
	}

	private void renderHand(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, AbstractClientPlayer playerIn, ModelPart rendererArmIn, ModelPart rendererArmwearIn) {
		PlayerModel<AbstractClientPlayer> playermodel = this.getModel();
		this.setModelProperties(playerIn);
		playermodel.attackTime = 0.0F;
		playermodel.crouching = false;
		playermodel.swimAmount = 0.0F;
		playermodel.setupAnim(playerIn, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		rendererArmIn.xRot = 0.0F;
		rendererArmIn.render(matrixStackIn, bufferIn.getBuffer(RenderType.entitySolid(playerIn.getSkin().texture())), combinedLightIn, OverlayTexture.NO_OVERLAY);
		rendererArmwearIn.xRot = 0.0F;
		rendererArmwearIn.render(matrixStackIn, bufferIn.getBuffer(RenderType.entityTranslucent(playerIn.getSkin().texture())), combinedLightIn, OverlayTexture.NO_OVERLAY);
	}

	protected void setupRotations(AbstractClientPlayer p_117802_, PoseStack p_117803_, float p_117804_, float p_117805_, float p_117806_) {
		float f = p_117802_.getSwimAmount(p_117806_);
		float f1 = p_117802_.getViewXRot(p_117806_);
		if (p_117802_.isFallFlying()) {
			super.setupRotations(p_117802_, p_117803_, p_117804_, p_117805_, p_117806_);
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
			super.setupRotations(p_117802_, p_117803_, p_117804_, p_117805_, p_117806_);
			float f4 = p_117802_.isInWater() || p_117802_.isInFluidType((fluidType, height) -> p_117802_.canSwimInFluidType(fluidType)) ? -90.0F - p_117802_.getXRot() : -90.0F;
			float f5 = Mth.lerp(f, 0.0F, f4);
			p_117803_.mulPose(Axis.XP.rotationDegrees(f5));
			if (p_117802_.isVisuallySwimming()) {
				p_117803_.translate(0.0F, -1.0F, 0.3F);
			}
		} else {
			super.setupRotations(p_117802_, p_117803_, p_117804_, p_117805_, p_117806_);
		}
	}
}
