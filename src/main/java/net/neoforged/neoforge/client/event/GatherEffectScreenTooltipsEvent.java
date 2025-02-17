/*
 * Copyright (c) NeoForged and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.neoforged.neoforge.client.event;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.Event;

/**
 * This event is called when an {@link EffectRenderingInventoryScreen} draws the tooltip lines for a hovered {@link MobEffectInstance}.
 * It can be used to modify the tooltip.
 * <p>
 * This event is only fired on the {@linkplain Dist#CLIENT physical client}.
 */
public class GatherEffectScreenTooltipsEvent extends Event {
    protected final EffectRenderingInventoryScreen<?> screen;
    protected final MobEffectInstance effectInst;
    protected final List<Component> tooltip;

    public GatherEffectScreenTooltipsEvent(EffectRenderingInventoryScreen<?> screen, MobEffectInstance effectInst, List<Component> tooltip) {
        this.screen = screen;
        this.effectInst = effectInst;
        this.tooltip = new ArrayList<>(tooltip);
    }

    /**
     * @return The screen which will be rendering the tooltip lines.
     */
    public EffectRenderingInventoryScreen<?> getScreen() {
        return this.screen;
    }

    /**
     * @return The effect whose tooltip is being drawn.
     */
    public MobEffectInstance getEffectInstance() {
        return this.effectInst;
    }

    /**
     * @return A mutable list of tooltip lines.
     */
    public List<Component> getTooltip() {
        return this.tooltip;
    }
}
