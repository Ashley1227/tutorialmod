package com.ashley.tutorial.item;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class TutorialItems {
    public static final Item FLOUR = new Item(new Item.Settings().group(TutorialItemGroups.TUTORIAL_ITEMS).maxCount(64).rarity(Rarity.COMMON));

    public static final Item MORTAR_AND_PESTLE = new MortarAndPestleItem(new Item.Settings().group(TutorialItemGroups.TUTORIAL_ITEMS).maxCount(1).rarity(Rarity.COMMON));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("tutorial", "flour"), FLOUR);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "mortar_and_pestle"), MORTAR_AND_PESTLE);
    }
}
