package com.littlecircleoo.sodiumoptionsmodcompatextra;

import com.littlecircleoo.sodiumoptionsmodcompatextra.integration.Integrations;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class Sodiumoptionsmodcompatextra implements ModInitializer, ClientModInitializer {

    @Override
    public void onInitialize() {
    }

    @Override
    public void onInitializeClient() {
        Integrations.init();
    }
}
