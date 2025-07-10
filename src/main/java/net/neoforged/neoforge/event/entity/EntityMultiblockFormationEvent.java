/*
 * Copyright (c) NeoForged and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.neoforged.neoforge.event.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import org.jetbrains.annotations.ApiStatus;

public class EntityMultiblockFormationEvent extends EntityEvent {
    private final BlockPattern.BlockPatternMatch blockPatternMatch;
    private final Level level;
    private final BlockPos blockPos;
    private final PathfinderMob mob;

    @ApiStatus.Internal
    public EntityMultiblockFormationEvent(PathfinderMob mob, BlockPattern.BlockPatternMatch blockPatternMatch, Level level, BlockPos blockPos) {
        super(mob);
        this.blockPatternMatch = blockPatternMatch;
        this.level = level;
        this.blockPos = blockPos;
        this.mob = mob;
    }

    public BlockPattern.BlockPatternMatch getBlockPatternMatch() {
        return blockPatternMatch;
    }

    public Level getLevel() {
        return level;
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }

    public PathfinderMob getMob() {
        return mob;
    }
}
