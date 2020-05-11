package com.ashley.tutorial.container.containers;

import net.minecraft.container.Container;
import net.minecraft.container.Slot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

public class ClayOvenContainer extends Container {
	private final Inventory inventory;
	private static final int INVENTORY_SIZE = 27;

	public ClayOvenContainer(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(null, syncId); // Since we didn't create a ContainerType, we will place null here.
		this.inventory = inventory;
		checkContainerSize(inventory, INVENTORY_SIZE);
		inventory.onInvOpen(playerInventory.player);

		// Clay Oven Inventory
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlot(new Slot(inventory, y * 9 + x, 8 + x * 18, 18 + y * 18));
			}
		}

		// Player Inventory (27 storage + 9 hotbar)
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlot(new Slot(playerInventory, y * 9 + x + 9, 8 + x * 18, 84 + y * 18));
			}
		}

		for (int x = 0; x < 9; x++) {
			this.addSlot(new Slot(playerInventory, x, 8 + x * 18, 142));
		}
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUseInv(player);
	}

	// Shift + Player Inv Slot
	@Override
	public ItemStack transferSlot(PlayerEntity player, int invSlot) {
		ItemStack newStack = ItemStack.EMPTY;
		Slot slot = this.slots.get(invSlot);
		if (slot != null && slot.hasStack()) {
			ItemStack originalStack = slot.getStack();
			newStack = originalStack.copy();
			if (invSlot < this.inventory.getInvSize()) {
				if (!this.insertItem(originalStack, this.inventory.getInvSize(), this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.insertItem(originalStack, 0, this.inventory.getInvSize(), false)) {
				return ItemStack.EMPTY;
			}

			if (originalStack.isEmpty()) {
				slot.setStack(ItemStack.EMPTY);
			} else {
				slot.markDirty();
			}
		}

		return newStack;
	}
}
