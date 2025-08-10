
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.kleiders.kleidersplayerrenderer.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.kleiders.kleidersplayerrenderer.client.model.Modeldenji_armor;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class KleidersCustomRendererModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeldenji_armor.LAYER_LOCATION, Modeldenji_armor::createBodyLayer);
	}
}
