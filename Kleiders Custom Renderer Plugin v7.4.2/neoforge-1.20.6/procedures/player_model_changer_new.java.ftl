<#assign lastline = "">
<#if field$last_line == "false">
<#assign lastline = "//">
</#if>

if (_evt.getRenderer() instanceof PlayerRenderer) {
	if (_evt instanceof RenderLivingEvent.Pre _pre) {
		${lastline}  _pre.setCanceled(true); 
	}
	new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(context,
			new ResourceLocation(${input$text}),
			new Model${field$model}(context.bakeLayer(Model${field$model}.LAYER_LOCATION))).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(),
					_evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
}