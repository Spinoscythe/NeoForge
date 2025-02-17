/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ItemExistsCondition implements ICondition {
    public static MapCodec<ItemExistsCondition> CODEC = RecordCodecBuilder.mapCodec(
            builder -> builder
                    .group(
                            ResourceLocation.CODEC.fieldOf("item").forGetter(ItemExistsCondition::getItem))
                    .apply(builder, ItemExistsCondition::new));

    private final ResourceLocation item;

    public ItemExistsCondition(String location) {
        this(ResourceLocation.parse(location));
    }

    public ItemExistsCondition(String namespace, String path) {
        this(ResourceLocation.fromNamespaceAndPath(namespace, path));
    }

    public ItemExistsCondition(ResourceLocation item) {
        this.item = item;
    }

    @Override
    public boolean test(IContext context) {
        return BuiltInRegistries.ITEM.containsKey(item);
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }

    public ResourceLocation getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "item_exists(\"" + item + "\")";
    }
}
