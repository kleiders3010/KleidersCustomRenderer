package com.kleiders.kleidersplayerrenderer.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RenderNameTagEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class TestProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onEventTriggered(RenderLivingEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onNameTagRender(RenderNameTagEvent event) {
		if (event.getEntity() instanceof Player) {
			EntityRenderer<?> renderer = event.getEntityRenderer();
			if (renderer instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel) {
				event.setResult(Event.Result.DENY);
			}
		}
	}

	private static void execute(@Nullable Event event) {
		RenderLivingEvent _evt = (RenderLivingEvent) event;
		Minecraft mc = Minecraft.getInstance();
		EntityRenderDispatcher dis = Minecraft.getInstance().getEntityRenderDispatcher();
		EntityRendererProvider.Context context = new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(), mc.getEntityModels(), mc.font);
		Entity _evtEntity = _evt.getEntity();
		PlayerRenderer _pr = null;
		if (_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel) {
			if (_evtEntity.getId() == Minecraft.getInstance().player.getId() && Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
				if (Minecraft.getInstance().screen == null) {
					event.setCanceled(true);
				}
			}
		}
		/*if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
			ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/empty.png");
			com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer emptyRenderer = new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context,
					(_evtEntity instanceof AbstractClientPlayer ? ((AbstractClientPlayer) _evtEntity).getModelName().equals("slim") : false), _texture);
			_pr = emptyRenderer;
			emptyRenderer.clearLayers();
			emptyRenderer.render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
		}
		if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
			_evt.setCanceled(true);
		}
		_evt.getPoseStack().pushPose();
		_evt.getPoseStack().scale(2f, 2f, 2f);
		if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
			ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
			if (ResourceLocation.tryParse((_evtEntity instanceof AbstractClientPlayer ? ((AbstractClientPlayer) _evtEntity).getSkinTextureLocation().toString() : "kleiders_custom_renderer:textures/entities/default.png")) != null) {
				_texture = new ResourceLocation((_evtEntity instanceof AbstractClientPlayer ? ((AbstractClientPlayer) _evtEntity).getSkinTextureLocation().toString() : "kleiders_custom_renderer:textures/entities/default.png"));
			}
			new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, (_evtEntity instanceof AbstractClientPlayer ? ((AbstractClientPlayer) _evtEntity).getModelName().equals("slim") : false), _texture)
					.render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
		}
		if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
			ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
			if (ResourceLocation.tryParse("ERROR") != null) {
				_texture = new ResourceLocation("ERROR");
			}
			Modeldenji_armor newModel = new Modeldenji_armor(context.bakeLayer(Modeldenji_armor.LAYER_LOCATION));
			newModel.LeftLeg.copyFrom(_pr.getModel().leftLeg);
			newModel.RightLeg.copyFrom(_pr.getModel().rightLeg);
			newModel.LeftArm.copyFrom(_pr.getModel().leftArm);
			newModel.RightArm.copyFrom(_pr.getModel().rightArm);
			newModel.Body.copyFrom(_pr.getModel().body);
			newModel.Head.copyFrom(_pr.getModel().head);
			_evt.getPoseStack().pushPose();
			_evt.getPoseStack().scale(0.9375F, 0.9375F, 0.9375F);
			new com.kleiders.kleidersplayerrenderer.KleidersPlayerAnimatedRenderer(context, _texture, newModel).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
					_evt.getMultiBufferSource(), _evt.getPackedLight());
			_evt.getPoseStack().popPose();
		}
		_evt.getPoseStack().popPose();
		*/
	}
}
