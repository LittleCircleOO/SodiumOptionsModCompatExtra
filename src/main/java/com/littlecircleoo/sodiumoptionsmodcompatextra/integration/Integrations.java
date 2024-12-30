package com.littlecircleoo.sodiumoptionsmodcompatextra.integration;

import com.littlecircleoo.sodiumoptionsmodcompatextra.integration.chunksfadein.ChunksFadeInOptionPage;
import com.littlecircleoo.sodiumoptionsmodcompatextra.integration.cit.CITOptionPage;
import com.littlecircleoo.sodiumoptionsmodcompatextra.integration.lambdynlights.LambDynLightsOptionPage;
import com.littlecircleoo.sodiumoptionsmodcompatextra.integration.ryoamiclights.RyoamicLightsOptionPage;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import net.fabricmc.loader.api.FabricLoader;
import toni.sodiumoptionsapi.api.OptionGUIConstruction;

import java.util.List;

public class Integrations {
    public static void init() {
        OptionGUIConstruction.EVENT.register(Integrations::event);
    }

    private static void event(List<OptionPage> event) {
        if (ModListUtil.isModLoaded("chunksfadein")) {
            event.add(new ChunksFadeInOptionPage());
        }

        if (ModListUtil.isModLoaded("lambdynlights")) {
            event.add(new LambDynLightsOptionPage());
        }

        if (ModListUtil.isModLoaded("ryoamiclights")) {
            event.add(new RyoamicLightsOptionPage());
        }

        if (ModListUtil.isModLoaded("citresewn")) {
            event.add(new CITOptionPage());
        }
    }
}

class ModListUtil {
    public static boolean isModLoaded(String id){
        return FabricLoader.getInstance().isModLoaded(id);
    }
}
