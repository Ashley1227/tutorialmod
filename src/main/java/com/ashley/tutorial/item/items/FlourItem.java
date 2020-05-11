package com.ashley.tutorial.item.items;

import com.ashley.tutorial.sound.TutorialSoundEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;

public class FlourItem extends Item {
	public FlourItem(Settings settings) {
		super(settings);
	}

	@Override
	public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
		super.onStoppedUsing(stack, world, user, remainingUseTicks);
		world.playSound(user.getX(), user.getY(), user.getZ(), TutorialSoundEvents.COUGH, SoundCategory.PLAYERS, 10f, 1f, false);
	}
}
