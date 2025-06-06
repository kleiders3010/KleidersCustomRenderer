<#assign lastline = "">
<#if field$last_line == "false">
<#assign lastline = "//">
</#if>

if (!(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer) && _evt.getEntity() instanceof MobEntity) {
if (_evt instanceof RenderLivingEvent.Pre) {
${lastline}  _evt.setCanceled(true); 
}
new com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer(
		_evt.getRenderer().getRenderManager(), new ResourceLocation(${input$text}),
		new ${field$model}()).render((MobEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
				_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
}