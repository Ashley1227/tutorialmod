package com.ashley.tutorial.block.entity;

import com.ashley.tutorial.block.TutorialBlocks;
import com.ashley.tutorial.block.entity.entities.ClayOvenBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class TutorialBlockEntities {

//	public static BlockEntityType<ClayOvenBlockEntity> CLAY_OVEN = BlockEntityType.Builder.create(ClayOvenBlockEntity::new, TutorialBlocks.CLAY_OVEN).build(null);
	public static BlockEntityType<ClayOvenBlockEntity> CLAY_OVEN;

	public static void register() {
//		Registry.register(Registry.BLOCK_ENTITY_TYPE, "tutorial:clay_oven", CLAY_OVEN);
		CLAY_OVEN = Registry.register(Registry.BLOCK_ENTITY_TYPE, "tutorial:clay_oven", BlockEntityType.Builder.create(ClayOvenBlockEntity::new, TutorialBlocks.CLAY_OVEN).build(null));

	}
}
