package com.littlecircleoo.sodiumoptionsmodcompatextra.integration.ryoamiclights;

import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;
import org.thinkingstudio.ryoamiclights.RyoamicLights;

public class RyoamicLightsOptionsStorage implements OptionStorage<Object> {

    public static final OptionStorage<?> INSTANCE = new RyoamicLightsOptionsStorage();

    @Override
    public Object getData() {
        return new Object();
    }

    @Override
    public void save() {
        RyoamicLights.get().config.save();
    }

}