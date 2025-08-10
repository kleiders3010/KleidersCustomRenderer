package com.kleiders.kleidersplayerrenderer.procedures;

import net.minecraft.world.entity.Entity;

import com.kleiders.kleidersplayerrenderer.network.KleidersCustomRendererModVariables;

public class TestOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			KleidersCustomRendererModVariables.PlayerVariables _vars = entity.getData(KleidersCustomRendererModVariables.PLAYER_VARIABLES);
			_vars.dwarf = !entity.getData(KleidersCustomRendererModVariables.PLAYER_VARIABLES).dwarf;
			_vars.syncPlayerVariables(entity);
		}
	}
}
