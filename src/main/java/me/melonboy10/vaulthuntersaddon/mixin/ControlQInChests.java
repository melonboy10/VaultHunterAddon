package me.melonboy10.vaulthuntersaddon.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractContainerMenu.class)
public abstract class ControlQInChests {

    @Redirect(method = "doClick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/Slot;safeTake(IILnet/minecraft/world/entity/player/Player;)Lnet/minecraft/world/item/ItemStack;"))
    private ItemStack modifySafetke(Slot slot, int amount, int maxvalue, Player player) {
        if (Minecraft.getInstance().screen != null && Minecraft.getInstance().screen.getTitle().toString().matches("(Common)|(Rare)|(Epic)|(Omega)")) {
            amount = slot.getItem().getCount();
        }
        return slot.safeTake(amount, maxvalue, player);
    }

}
