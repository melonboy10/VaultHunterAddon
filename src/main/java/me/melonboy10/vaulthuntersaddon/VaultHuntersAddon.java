package me.melonboy10.vaulthuntersaddon;

import com.mojang.logging.LogUtils;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("vaulthuntersaddon")
public class VaultHuntersAddon {

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final ArrayList<String> itemHighlightNames = new ArrayList<>(Arrays.asList("the_vault:knowledge_star_essence"));

    public VaultHuntersAddon() {
        MinecraftForge.EVENT_BUS.register(this);
        OverlayRegistry.registerOverlayTop("HealthVignette", new RedVignette());
    }

}
