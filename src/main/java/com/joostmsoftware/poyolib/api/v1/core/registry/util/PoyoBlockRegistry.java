package com.joostmsoftware.poyolib.api.v1.core.registry.util;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

@SuppressWarnings("unused")
public class PoyoBlockRegistry {
    /**
     * Creates a simple crop block
     * @param color the MapColor you want for the block.
     * @return a crop block.
     */
    public static Block createCropBlock(MapColor color) {
        return new CropBlock(AbstractBlock.Settings.create().mapColor(color).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY));
    }
}
