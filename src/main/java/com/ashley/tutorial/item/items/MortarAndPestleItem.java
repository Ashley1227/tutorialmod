package com.ashley.tutorial.item.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class MortarAndPestleItem extends Item {
    public MortarAndPestleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient()) {
            world.createExplosion(user, user.getX(), user.getY() - 1, user.getZ(), 16.0f, Explosion.DestructionType.BREAK);
            stack.decrement(1);
        }
        return super.use(world, user, hand);
    }
}
