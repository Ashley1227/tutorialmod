package com.ashley.tutorial;

import com.ashley.tutorial.block.TutorialBlocks;
import com.ashley.tutorial.block.entity.TutorialBlockEntities;
import com.ashley.tutorial.container.TutorialContainers;
import com.ashley.tutorial.item.TutorialItems;
import com.ashley.tutorial.sound.TutorialSoundEvents;
import net.fabricmc.api.ModInitializer;

public class TutorialMod implements ModInitializer {


	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");

		TutorialBlocks.register();
		TutorialBlockEntities.register();
		TutorialContainers.register();

		TutorialItems.register();

		TutorialSoundEvents.register();
	}
}
