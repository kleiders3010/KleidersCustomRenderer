package com.kleiders.kleidersplayerrenderer.procedures;

import net.minecraft.world.entity.Entity;

import com.kleiders.kleidersplayerrenderer.network.KleidersCustomRendererModVariables;

public class SwitchingOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			KleidersCustomRendererModVariables.PlayerVariables _vars = entity.getData(KleidersCustomRendererModVariables.PLAYER_VARIABLES);
			_vars.dwarfing = !entity.getData(KleidersCustomRendererModVariables.PLAYER_VARIABLES).dwarfing;
			_vars.syncPlayerVariables(entity);
		}
	}
}
