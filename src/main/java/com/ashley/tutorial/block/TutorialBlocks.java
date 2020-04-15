package com.ashley.tutorial.block;

import com.ashley.tutorial.item.TutorialItemGroups;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TutorialBlocks {

    public static final Block BLOCK_OF_FLOUR = new Block(FabricBlockSettings.of(Material.SAND).sounds(BlockSoundGroup.SAND).build());

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("tutorial","block_of_flour"), BLOCK_OF_FLOUR);
        Registry.register(Registry.ITEM, new Identifier("tutorial","block_of_flour"), new BlockItem(BLOCK_OF_FLOUR, new Item.Settings().group(TutorialItemGroups.TUTORIAL_ITEMS)));
    }
}
