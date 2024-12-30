package com.littlecircleoo.sodiumoptionsmodcompatextra.integration.lambdynlights;

import me.jellysquid.mods.sodium.client.gui.options.storage.OptionStorage;

import dev.lambdaurora.lambdynlights.LambDynLights;

public class LambDynLightsOptionsStorage implements OptionStorage<Object> {

    public static final OptionStorage<?> INSTANCE = new LambDynLightsOptionsStorage();

    @Override
    public Object getData() {
        return new Object();
    }

    @Override
    public void save() {
        LambDynLights.get().config.save();
    }

}