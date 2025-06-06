RenderLivingEvent _evt = (RenderLivingEvent) event;
Minecraft mc = Minecraft.getInstance();
EntityRenderDispatcher dis = Minecraft.getInstance().getEntityRenderDispatcher();
EntityRendererProvider.Context context = new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(),
			mc.getEntityModels(), mc.font);
Entity _evtEntity = _evt.getEntity();
PlayerRenderer _pr = null;
PoseStack poseStack = _evt.getPoseStack();
if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
	ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/empty.png");
	com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer emptyRenderer = new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context,
		(_evtEntity instanceof AbstractClientPlayer ? ((AbstractClientPlayer) _evtEntity).getModelName().equals("slim") : false), _texture);
	_pr = emptyRenderer;
	emptyRenderer.clearLayers();
	emptyRenderer.render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
}