if (_evt.getRenderer() instanceof LivingEntityRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
	if (_evt instanceof RenderLivingEvent.Pre _pre) {
		_pre.setCanceled(true);
	}
}