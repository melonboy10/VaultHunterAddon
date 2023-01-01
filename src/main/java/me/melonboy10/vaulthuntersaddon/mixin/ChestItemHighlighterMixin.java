package me.melonboy10.vaulthuntersaddon.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.melonboy10.vaulthuntersaddon.VaultHuntersAddon.itemHighlightNames;

@Mixin(AbstractContainerScreen.class)
public abstract class ChestItemHighlighterMixin {

    @Inject(method = "renderSlot", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;enableDepthTest()V", shift = At.Shift.BEFORE))
    public void onRenderItem(PoseStack poseStack, Slot slot , CallbackInfo ci) {
        if (Minecraft.getInstance().screen != null && Minecraft.getInstance().screen.getTitle().toString().matches("(Common)|(Rare)|(Epic)|(Omega)")) {
            if (slot.getItem().getCount() > 1 && itemHighlightNames.contains(slot.getItem().getItem().getRegistryName().toString())) {
                Gui.fill(poseStack, slot.x, slot.y, slot.x + 16, slot.y + 16, 0x80FF0000);
            }
        }
    }

}
