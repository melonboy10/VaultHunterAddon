package me.melonboy10.vaulthuntersaddon.mixin;

import iskallia.vault.client.gui.helper.UIHelper;
import iskallia.vault.core.vault.time.TickClock;
import iskallia.vault.core.vault.time.TickTimer;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TickTimer.class)
public abstract class TimerTitleMixin extends TickClock {

    @Inject(method = "tickClient", at = @At(value = "RETURN"), remap = false)
    public void onTickClient(CallbackInfo ci) {
        if (get(DISPLAY_TIME) % 300 == 0) {
            Minecraft.getInstance().gui.setSubtitle(new TextComponent(UIHelper.formatTimeString(Math.abs(get(DISPLAY_TIME))) + " remaining"));
            Minecraft.getInstance().gui.setTitle(new TextComponent(""));
        }
    }
}
