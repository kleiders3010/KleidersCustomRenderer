<#assign hidebase = "">
<#if field$hide_base == "false">
<#assign hidebase = "//">
</#if>

<#assign lastline = "">
<#if field$last_line == "Both">
<#assign lastline = "new com.kleiders.kleidersplayerrenderer.Classic">
<#elseif field$last_line == "Internal">
<#assign lastline = "new com.kleiders.kleidersplayerrenderer.Internal">
<#else>
<#assign lastlin = "new com.kleiders.kleidersplayerrenderer.External">
</#if>

if (_evt.getRenderer() instanceof PlayerRenderer) {
if (_evt instanceof RenderLivingEvent.Pre) {
		${hidebase}  _evt.setCanceled(true); 
	}

${lastline}PlayerRenderer(_evt.getRenderer().getRenderManager(),
		new ResourceLocation(${input$text})).render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
		_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
}