package com.kleiders.kleidersplayerrenderer.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeldenji_armor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("kleiders_custom_renderer", "modeldenji_armor"), "main");
	public final ModelPart Head;
	public final ModelPart LeftArm;
	public final ModelPart RightArm;
	public final ModelPart Body;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;

	public Modeldenji_armor(ModelPart root) {
		this.Head = root.getChild("Head");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.Body = root.getChild("Body");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(54, 60).addBox(0.0F, -8.3F, -28.15F, 0.0F, 6.0F, 21.0F, new CubeDeformation(0.01F)).texOffs(54, 60).addBox(-4.0F, -7.85F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.1F)).texOffs(112, 101)
						.addBox(-3.0F, -7.825F, 4.15F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.11F)).texOffs(54, 119).addBox(-1.0F, -7.775F, 5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(74, 119)
						.addBox(-1.0F, -5.775F, 7.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.01F)),
				PartPose.offset(0.0F, 2.3F, 0.0F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(102, 60).addBox(-4.4536F, -3.85F, -4.5305F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.6F)),
				PartPose.offsetAndRotation(0.0F, -1.7F, -2.4F, 0.1962F, -0.7757F, -0.1383F));
		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(90, 99).addBox(-3.5F, -3.85F, -4.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.9F)),
				PartPose.offsetAndRotation(0.0F, -1.7F, -2.4F, 0.1396F, 0.0F, 0.0F));
		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(78, 60).addBox(-3.5F, -0.6F, -4.5F, 7.0F, 3.0F, 5.0F, new CubeDeformation(-0.8F)),
				PartPose.offsetAndRotation(0.0F, -1.4F, -2.2F, 0.2618F, 0.0F, 0.0F));
		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(108, 94).addBox(-2.7352F, -0.225F, -9.0648F, 5.0F, 2.0F, 5.0F, new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(-4.392F, -1.815F, -0.6513F, 0.3622F, -0.7519F, -0.2533F));
		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(54, 76).addBox(-3.0F, -31.825F, 16.15F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(0.0F, 12.0707F, -27.9614F, -0.6545F, 0.0F, 0.0F));
		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(110, 86).addBox(-1.0F, -28.775F, 3.25F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 26.4766F, 7.0339F, 0.2618F, 0.0F, 0.0F));
		PartDefinition Head_r3 = Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(66, 77).addBox(-2.0F, -35.35F, -10.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(54, 60)
				.addBox(2.0F, -35.35F, -10.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(66, 119).addBox(-4.0F, -35.35F, -10.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition Head_r4 = Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(106, 76).addBox(-1.0F, -32.25F, -2.2811F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.31F)),
				PartPose.offsetAndRotation(-1.2154F, 24.3952F, -1.9171F, 0.1231F, 0.7816F, 0.0869F));
		PartDefinition Head_r5 = Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(79, 69).addBox(-4.0F, -32.25F, -4.8F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(0.0F, 24.0F, 2.6F, 0.0873F, 0.0F, 0.0F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(54, 103).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.27F)).texOffs(86, 109).addBox(-1.0F, 2.0F, 0.0F, 5.0F, 19.0F, 0.0F, new CubeDeformation(0.01F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(70, 103).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.27F)).texOffs(99, 109).addBox(-4.0F, 2.0F, 0.0F, 5.0F, 19.0F, 0.0F, new CubeDeformation(0.01F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(63, 91).addBox(-4.0F, 5.0F, -5.0F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.28F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(94, 83).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.27F)).texOffs(110, 113).addBox(-2.5F, 8.25F, -4.04F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(78, 87).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.27F)).texOffs(110, 107).addBox(-2.5F, 8.25F, -4.04F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
