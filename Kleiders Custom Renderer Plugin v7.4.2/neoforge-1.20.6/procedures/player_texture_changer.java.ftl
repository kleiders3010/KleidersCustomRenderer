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
	if (_evt instanceof RenderLivingEvent.Pre _pre) {
		${hidebase}  _pre.setCanceled(true); 
	}
		    ${lastline}PlayerRenderer(
					new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(), mc.getEntityModels(), mc.font),
					new ResourceLocation(${input$text}))
					.render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
}