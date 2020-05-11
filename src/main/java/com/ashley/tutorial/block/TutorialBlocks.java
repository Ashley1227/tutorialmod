package com.ashley.tutorial.block;

import com.ashley.tutorial.block.blocks.ClayOvenBlock;
import com.ashley.tutorial.block.blocks.FlourBlock;
import com.ashley.tutorial.item.items.TutorialItemGroups;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TutorialBlocks {


    public static final Block BLOCK_OF_FLOUR = new FlourBlock(FabricBlockSettings.of(Material.SAND).sounds(BlockSoundGroup.SAND).strength(0.2f, 1.0f).breakByTool(FabricToolTags.SHOVELS).build());

    public static final Block CLAY_OVEN = new ClayOvenBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).build());

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("tutorial", "block_of_flour"), BLOCK_OF_FLOUR);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "block_of_flour"), new BlockItem(BLOCK_OF_FLOUR, new Item.Settings().group(TutorialItemGroups.TUTORIAL_ITEMS)));

        Registry.register(Registry.BLOCK, new Identifier("tutorial", "clay_oven"), CLAY_OVEN);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "clay_oven"), new BlockItem(CLAY_OVEN, new Item.Settings().group(TutorialItemGroups.TUTORIAL_ITEMS)));

//        BlockRenderLayerMap.INSTANCE.putBlock(BLOCK_OF_FLOUR, RenderLayer.getCutout());
    }
}
