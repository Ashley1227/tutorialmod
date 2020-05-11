package com.ashley.tutorial.client.gui.screen;

import com.ashley.tutorial.container.containers.ClayOvenContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ClayOvenScreen extends ContainerScreen<ClayOvenContainer> {

	private static final Identifier TEXTURE = new Identifier("minecraft","textures/gui/container/shulker_box.png");

	public ClayOvenScreen(ClayOvenContainer container, PlayerInventory playerInventory, Text name) {
		super(container, playerInventory, name);
		this.containerHeight = 114 + 3 * 18;
	}
	@Override
	protected void drawForeground(int mouseX, int mouseY) {
		super.drawForeground(mouseX, mouseY);
		this.font.draw(this.title.asFormattedString(), 8.0F, 6.0F, 0x404040);
		this.font.draw(this.playerInventory.getDisplayName().asFormattedString(), 8.0F, (float)(this.containerHeight - 96 + 2), 0x404040);
	}
	@Override
	protected void drawBackground(float delta, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(TEXTURE);
		int x = (this.width  - this.containerWidth ) / 2;
		int y = (this.height - this.containerHeight) / 2;
		//        x, y, u, v, width,               height
		this.blit(x, y, 0, 0, this.containerWidth, this.containerHeight);
	}
}
