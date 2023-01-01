package me.melonboy10.vaulthuntersaddon.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import iskallia.vault.core.Version;
import iskallia.vault.core.data.DataObject;
import iskallia.vault.core.data.adapter.Adapter;
import iskallia.vault.core.data.key.FieldKey;
import iskallia.vault.core.data.key.registry.FieldRegistry;
import iskallia.vault.core.data.key.registry.ISupplierKey;
import iskallia.vault.core.vault.time.TickClock;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TickClock.class)
public abstract class TimerScaleMixin extends DataObject<TickClock> implements ISupplierKey<TickClock> {

    @Final
    @Shadow
    public static FieldKey<Integer> DISPLAY_TIME;

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Liskallia/vault/client/gui/helper/FontHelper;drawStringWithBorder(Lcom/mojang/blaze3d/vertex/PoseStack;Ljava/lang/String;FFII)F", shift = At.Shift.BEFORE), remap = false)
    public void beforeTextDraw(PoseStack matrixStack, CallbackInfo ci) {
        float scale = 10 - get(DISPLAY_TIME) / 20f / 10f;
        matrixStack.scale(scale, scale, 1);
    }

}
