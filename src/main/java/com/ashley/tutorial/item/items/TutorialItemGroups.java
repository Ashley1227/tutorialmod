package com.ashley.tutorial.item.items;

import com.ashley.tutorial.item.TutorialItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TutorialItemGroups {
    public static final ItemGroup TUTORIAL_ITEMS = FabricItemGroupBuilder.build(
            new Identifier("tutorial", "items"),
            () -> new ItemStack(TutorialItems.FLOUR));
}
