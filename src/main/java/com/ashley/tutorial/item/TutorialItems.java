package com.ashley.tutorial.item;

import com.ashley.tutorial.item.items.MortarAndPestleItem;
import com.ashley.tutorial.item.items.TutorialItemGroups;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class TutorialItems {
    public static final Item FLOUR = new Item(new Item.Settings()
            .group(TutorialItemGroups.TUTORIAL_ITEMS)
            .maxCount(64)
            .rarity(Rarity.COMMON)
            .food(new FoodComponent.Builder()
                    .hunger(1)
                    .saturationModifier(1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300),1f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    );

    public static final Item MORTAR_AND_PESTLE = new MortarAndPestleItem(new Item.Settings()
            .group(TutorialItemGroups.TUTORIAL_ITEMS)
            .maxCount(1)
            .rarity(Rarity.COMMON)
            .recipeRemainder(Items.BOWL)
    );

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("tutorial", "flour"), FLOUR);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "mortar_and_pestle"), MORTAR_AND_PESTLE);
    }
}
