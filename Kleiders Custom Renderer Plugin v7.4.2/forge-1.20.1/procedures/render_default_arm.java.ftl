{
	ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
	if (ResourceLocation.tryParse(${input$texture}) != null) {
	 _texture = new ResourceLocation(${input$texture});
	}
	PlayerModel<AbstractClientPlayer> newModel = new PlayerModel<>(context.bakeLayer(${input$slim} ? ModelLayers.PLAYER_SLIM : ModelLayers.PLAYER), ${input$slim});
	newModel.leftArm.copyFrom(playerModel.leftArm);
	newModel.rightArm.copyFrom(playerModel.rightArm);
	if (arm == HumanoidArm.LEFT) {
		newModel.leftArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, OverlayTexture.NO_OVERLAY);
	} else {
		newModel.rightArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, OverlayTexture.NO_OVERLAY);
	}
}