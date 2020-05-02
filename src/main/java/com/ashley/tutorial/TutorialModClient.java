package com.ashley.tutorial;

import com.ashley.tutorial.client.gui.screen.ClayOvenScreen;
import com.ashley.tutorial.container.containers.ClayOvenContainer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class TutorialModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		System.out.println("FOSNR");
		ScreenProviderRegistry.INSTANCE.<ClayOvenContainer>registerFactory(
				new Identifier("tutorial:clay_oven"),
				(container) -> new ClayOvenScreen(container, MinecraftClient.getInstance().player.inventory,
				new TranslatableText("container.tutorial.clay_oven"))
		);
	}
}
