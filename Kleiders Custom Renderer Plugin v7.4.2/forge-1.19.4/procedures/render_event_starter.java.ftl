RenderLivingEvent _evt = (RenderLivingEvent) event;
Minecraft mc = Minecraft.getInstance();
EntityRenderDispatcher dis = Minecraft.getInstance().getEntityRenderDispatcher();
EntityRendererProvider.Context context = new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(),
			mc.getEntityModels(), mc.font);
Entity _evtEntity = _evt.getEntity();