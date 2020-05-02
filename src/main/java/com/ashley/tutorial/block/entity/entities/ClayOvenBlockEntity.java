package com.ashley.tutorial.block.entity.entities;

import com.ashley.tutorial.block.entity.TutorialBlockEntities;
import com.ashley.tutorial.container.containers.ClayOvenContainer;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.container.Container;
import net.minecraft.container.ShulkerBoxContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Tickable;

public class ClayOvenBlockEntity extends LootableContainerBlockEntity implements Tickable {
	private DefaultedList<ItemStack> inventory;
	private static final int INVENTORY_SIZE = 27;

	public boolean on = false;
	public int cookedness = 0;

	public ClayOvenBlockEntity() {
		super(TutorialBlockEntities.CLAY_OVEN);
		this.inventory = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);
	}

	@Override
	public void tick() {
		if(!world.isClient) {
			if (on) {
				cookedness++;
				markDirty();
			}
			System.out.println(cookedness);
		}
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		tag.putBoolean("on", on);
		tag.putInt("cookedness", cookedness);

		if (!this.serializeLootTable(tag)) {
			Inventories.toTag(tag, this.inventory);
		}

		return super.toTag(tag);
	}
	@Override
	public void fromTag(CompoundTag tag) {
		super.fromTag(tag);
		on = tag.getBoolean("on");
		cookedness = tag.getInt("cookedness");

		this.inventory = DefaultedList.ofSize(this.getInvSize(), ItemStack.EMPTY);
		if (!this.deserializeLootTable(tag)) {
			Inventories.fromTag(tag, this.inventory);
		}
	}

	// new stuff
	@Override
	protected Text getContainerName() {
		return new TranslatableText("container.tutorial.clay_oven");
	}

	@Override
	public Container createContainer(int syncId, PlayerInventory playerInventory) {
		return new ClayOvenContainer(syncId, playerInventory, (Inventory) this);
	}

	@Override
	protected DefaultedList<ItemStack> getInvStackList() {
		return this.inventory;
	}

	@Override
	protected void setInvStackList(DefaultedList<ItemStack> list) {
		this.inventory = list;
	}

	@Override
	public int getInvSize() {
		return this.INVENTORY_SIZE;
	}
}
