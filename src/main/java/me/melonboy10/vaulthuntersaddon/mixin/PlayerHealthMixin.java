package me.melonboy10.vaulthuntersaddon.mixin;

import me.melonboy10.vaulthuntersaddon.RedVignette;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LocalPlayer.class)
public abstract class PlayerHealthMixin extends LivingEntity {

    protected PlayerHealthMixin(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }

    @Override
    public void setHealth(float newHealth) {
        super.setHealth(newHealth);
        RedVignette.setHealth((float) (((this.getMaxHealth() * 0.5) - newHealth) / this.getMaxHealth()));
        //                                   20            -       19        /        10
    }
}
