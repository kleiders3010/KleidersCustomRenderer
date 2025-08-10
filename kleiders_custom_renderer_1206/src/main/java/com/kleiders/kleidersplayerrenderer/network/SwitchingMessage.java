
package com.kleiders.kleidersplayerrenderer.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import com.kleiders.kleidersplayerrenderer.procedures.SwitchingOnKeyPressedProcedure;
import com.kleiders.kleidersplayerrenderer.KleidersCustomRendererMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record SwitchingMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<SwitchingMessage> TYPE = new Type<>(new ResourceLocation(KleidersCustomRendererMod.MODID, "key_switching"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SwitchingMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SwitchingMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new SwitchingMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<SwitchingMessage> type() {
		return TYPE;
	}

	public static void handleData(final SwitchingMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			SwitchingOnKeyPressedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		KleidersCustomRendererMod.addNetworkMessage(SwitchingMessage.TYPE, SwitchingMessage.STREAM_CODEC, SwitchingMessage::handleData);
	}
}
