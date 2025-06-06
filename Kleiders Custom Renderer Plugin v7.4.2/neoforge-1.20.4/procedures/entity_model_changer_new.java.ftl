<#assign lastline = "">
<#if field$last_line == "false">
<#assign lastline = "//">
</#if>

if (!(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer) && _evt.getEntity() instanceof Mob) {
	if (_evt instanceof RenderLivingEvent.Pre _pre) {
		${lastline}  _pre.setCanceled(true); 
	}
	new com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer(context,
			new ResourceLocation(${input$text}),
			new Model${field$model}(context.bakeLayer(Model${field$model}.LAYER_LOCATION))).render((Mob) _evt.getEntity(), _evt.getEntity().getYRot(),
					_evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
}