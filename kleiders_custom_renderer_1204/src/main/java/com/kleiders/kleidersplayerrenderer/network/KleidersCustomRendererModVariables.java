package com.kleiders.kleidersplayerrenderer.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;
import java.util.ArrayList;

import com.kleiders.kleidersplayerrenderer.KleidersCustomRendererMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KleidersCustomRendererModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, KleidersCustomRendererMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		KleidersCustomRendererMod.addNetworkMessage(PlayerVariablesSyncMessage.ID, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handleData);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.dwarf = original.dwarf;
			if (!event.isWasDeath()) {
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public boolean dwarf = false;

		@Override
		public CompoundTag serializeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("dwarf", dwarf);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			dwarf = nbt.getBoolean("dwarf");
		}

		public void syncPlayerVariables(Entity entity) {
			if (!entity.level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(entity.level().players())) {
					if (entityiterator instanceof ServerPlayer serverPlayer)
						PacketDistributor.PLAYER.with(serverPlayer).send(new PlayerVariablesSyncMessage(this, entity.getId()));
				}
			}
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data, int target) implements CustomPacketPayload {
		public static final ResourceLocation ID = new ResourceLocation(KleidersCustomRendererMod.MODID, "player_variables_sync");

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this(new PlayerVariables(), buffer.readInt());
			this.data.deserializeNBT(buffer.readNbt());
		}

		@Override
		public void write(final FriendlyByteBuf buffer) {
			buffer.writeInt(target());
			buffer.writeNbt(data.serializeNBT());
		}

		@Override
		public ResourceLocation id() {
			return ID;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final PlayPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.workHandler().submitAsync(() -> Minecraft.getInstance().player.level().getEntity(message.target()).getData(PLAYER_VARIABLES).deserializeNBT(message.data.serializeNBT())).exceptionally(e -> {
					context.packetHandler().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
