package com.ashley.tutorial;

import com.ashley.tutorial.item.TutorialItems;
import net.fabricmc.api.ModInitializer;

public class TutorialMod implements ModInitializer {


    @Override
    public void onInitialize() {
        System.out.println("Hello Fabric world!");

        TutorialItems.register();

    }
}
