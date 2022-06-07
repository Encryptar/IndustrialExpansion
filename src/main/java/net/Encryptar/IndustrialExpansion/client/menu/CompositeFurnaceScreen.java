package net.Encryptar.IndustrialExpansion.client.menu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.Encryptar.IndustrialExpansion.IndustrialExpansion;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CompositeFurnaceScreen extends AbstractContainerScreen<CompositeFurnaceMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(IndustrialExpansion.MODID, "gui/cfurnacegui.png");

    public CompositeFurnaceScreen(CompositeFurnaceMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.isCrafting()) {
            blit(pPoseStack, x + 110, y + 35, 177, 14, menu.getScaledProgress(), 16);
        }
        if(menu.isLit()){
            blit(pPoseStack, x + 18, y + 25 + 14 - menu.getScaledLitTime(), 176, 14-menu.getScaledLitTime(), 14, menu.getScaledLitTime());
        }

    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }

}
