<#assign lastline = "">
<#if field$last_line == "false">
<#assign lastline = "//">
</#if>

if (_evt.getRenderer() instanceof PlayerRenderer) {
if (_evt instanceof RenderLivingEvent.Pre) {
${lastline}  _evt.setCanceled(true); 
}
new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(
		_evt.getRenderer().getRenderManager(), new ResourceLocation(${input$text}),
		new ${field$model}()).render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
				_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
}