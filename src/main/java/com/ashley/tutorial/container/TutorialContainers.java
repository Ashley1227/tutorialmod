package com.ashley.tutorial.container;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TutorialContainers {
	public static void register() {
		ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier("tutorial", "clay_oven"), (syncId, identifier, player, buf) -> {
			final World world = player.world;
			final BlockPos pos = buf.readBlockPos();
			return world.getBlockState(pos)
					.createContainerFactory(world, pos)
					.createMenu(syncId, player.inventory, player);
		});
	}
}
