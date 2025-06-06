if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
	ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
	if (ResourceLocation.tryParse(${input$text}) != null) {
	 _texture = new ResourceLocation(${input$text});
	}
	Model${field$model} newModel = new Model${field$model}(context.bakeLayer(Model${field$model}.LAYER_LOCATION));
	newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
	newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
	newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
	newModel.RightArm.copyFrom(_pr.getModel().rightArm);
	newModel.Body.copyFrom(_pr.getModel().body);
	newModel.Head.copyFrom(_pr.getModel().head);
	poseStack.pushPose();
	poseStack.scale(0.9375F, 0.9375F, 0.9375F);
	new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context,
			_texture,
			newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(),
					_evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
	poseStack.popPose();
}