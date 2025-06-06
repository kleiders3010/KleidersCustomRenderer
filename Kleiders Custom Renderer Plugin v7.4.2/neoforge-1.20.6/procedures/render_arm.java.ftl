{
	ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
	if (ResourceLocation.tryParse(${input$texture}) != null) {
	 _texture = new ResourceLocation(${input$texture});
	}
	Model${field$model} newModel = new Model${field$model}(context.bakeLayer(Model${field$model}.LAYER_LOCATION));
	newModel.LeftArm.copyFrom(playerModel.leftArm);
	newModel.RightArm.copyFrom(playerModel.rightArm);
	if (arm == HumanoidArm.LEFT) {
		newModel.LeftArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, OverlayTexture.NO_OVERLAY);
	} else {
		newModel.RightArm.render(_evt.getPoseStack(), bufferSource.getBuffer(RenderType.entityTranslucentCull(_texture)), packedLight, OverlayTexture.NO_OVERLAY);
	}
}