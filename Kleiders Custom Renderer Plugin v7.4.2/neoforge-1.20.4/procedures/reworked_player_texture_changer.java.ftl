if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
	ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
	if (ResourceLocation.tryParse(${input$texture}) != null) {
	 _texture = new ResourceLocation(${input$texture});
	}
	new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, ${input$slim}, _texture)
			.render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
}