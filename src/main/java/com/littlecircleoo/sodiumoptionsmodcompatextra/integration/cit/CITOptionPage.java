package com.littlecircleoo.sodiumoptionsmodcompatextra.integration.cit;

import com.google.common.collect.ImmutableList;

import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.ControlValueFormatter;
import me.jellysquid.mods.sodium.client.gui.options.control.SliderControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import shcm.shsupercm.fabric.citresewn.config.CITResewnConfig;

import toni.sodiumoptionsapi.api.OptionIdentifier;
import toni.sodiumoptionsapi.util.IOptionGroupIdAccessor;

import java.util.ArrayList;
import java.util.List;

public class CITOptionPage extends OptionPage {

    public static final OptionIdentifier<Void> ID = OptionIdentifier.create(new ResourceLocation("citresewn", "textures"));

    public CITOptionPage() {
        super(Component.translatable("options.sodiumoptionsmodcompatextra.cit.textures"), create());
        ((IOptionGroupIdAccessor)this).sodiumOptionsAPI$setId(ID);
    }

    private static ImmutableList<OptionGroup> create() {
        final List<OptionGroup> groups = new ArrayList<>();

        groups.add(
                OptionGroup.createBuilder()
                        .add(
                                OptionImpl.createBuilder(boolean.class, CITOptionsStorage.INSTANCE)
                                        //.setId(new Identifier("citresewn", "enabled"))
                                        .setName(Component.translatable("config.citresewn.enabled.title"))
                                        .setTooltip(Component.translatable("config.citresewn.enabled.tooltip"))
                                        .setControl(TickBoxControl::new)
                                        .setBinding((options, value) -> CITResewnConfig.INSTANCE.enabled = value,
                                                (options) -> CITResewnConfig.INSTANCE.enabled)
                                        .build()
                        )
                        .add(
                                OptionImpl.createBuilder(boolean.class, CITOptionsStorage.INSTANCE)
                                        //.setId(new Identifier("citresewn", "mute_errors"))
                                        .setName(Component.translatable("config.citresewn.mute_errors.title"))
                                        .setTooltip(Component.translatable("config.citresewn.mute_errors.tooltip"))
                                        .setControl(TickBoxControl::new)
                                        .setBinding((options, value) -> CITResewnConfig.INSTANCE.mute_errors = value,
                                                (options) -> CITResewnConfig.INSTANCE.mute_errors)
                                        .build()
                        )
                        .add(
                                OptionImpl.createBuilder(boolean.class, CITOptionsStorage.INSTANCE)
                                        //.setId(new Identifier("citresewn", "mute_warns"))
                                        .setName(Component.translatable("config.citresewn.mute_warns.title"))
                                        .setTooltip(Component.translatable("config.citresewn.mute_warns.tooltip"))
                                        .setControl(TickBoxControl::new)
                                        .setBinding((options, value) -> CITResewnConfig.INSTANCE.mute_warns = value,
                                                (options) -> CITResewnConfig.INSTANCE.mute_warns)
                                        .build()
                        ).add(
                                OptionImpl.createBuilder(int.class, CITOptionsStorage.INSTANCE)
                                        //.setId(new Identifier("citresewn", "cache"))
                                        .setName(Component.translatable("config.citresewn.cache_ms.title"))
                                        .setTooltip(Component.translatable("config.citresewn.cache_ms.tooltip"))
                                        .setControl(option -> new SliderControl(option, 0, 100, 1, CacheMsValueFormatter.INSTANCE))
                                        .setBinding((option, value) -> CITResewnConfig.INSTANCE.cache_ms = value,
                                                option -> (int) CITResewnConfig.INSTANCE.cache_ms)
                                        .build()
                        ).add(
                                OptionImpl.createBuilder(boolean.class, CITOptionsStorage.INSTANCE)
                                        //.setId(new Identifier("citresewn", "broken_paths"))
                                        .setName(Component.translatable("config.citresewn.broken_paths.title"))
                                        .setTooltip(Component.translatable("config.citresewn.broken_paths.tooltip"))
                                        .setControl(TickBoxControl::new)
                                        .setBinding((options, value) -> CITResewnConfig.INSTANCE.broken_paths = value,
                                                (options) -> CITResewnConfig.INSTANCE.broken_paths)
                                        .build()
                        )
                        .build()
        );

        return ImmutableList.copyOf(groups);
    }

    private static class CacheMsValueFormatter implements ControlValueFormatter {

        private final static CacheMsValueFormatter INSTANCE = new CacheMsValueFormatter();

        @Override
        public Component format(int ticks) {
            if (ticks <= 1) {
                return Component.translatable("config.citresewn.cache_ms.ticks." + ticks).withStyle(ChatFormatting.AQUA);
            } else {
                ChatFormatting color = ChatFormatting.DARK_RED;
                if (ticks <= 40) {
                    color = ChatFormatting.RED;
                }
                if (ticks <= 20) {
                    color = ChatFormatting.GOLD;
                }
                if (ticks <= 10) {
                    color = ChatFormatting.DARK_GREEN;
                }
                if (ticks <= 5) {
                    color = ChatFormatting.GREEN;
                }
                return Component.translatable("config.citresewn.cache_ms.ticks.any", ticks).withStyle(color);
            }
        }

    }


}