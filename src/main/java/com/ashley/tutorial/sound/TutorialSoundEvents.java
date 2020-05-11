package com.ashley.tutorial.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TutorialSoundEvents {

	public static SoundEvent COUGH = new SoundEvent(new Identifier("tutorial", "cough"));

	public static void register() {
		Registry.register(Registry.SOUND_EVENT, COUGH.getId(), COUGH);
	}
}
