package io.github.lieonlion.mcvbop.blocks;

import io.github.lieonlion.mcvbop.init.MoreChestBOPInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class MoreChestBOPBlock extends ChestBlock {
    private final MoreChestBOPEnum chestType;

    public MoreChestBOPBlock(MoreChestBOPEnum chestType, MapColor colour) {
        super(Properties.copy(Blocks.CHEST).mapColor(colour), () -> MoreChestBOPInit.chest_entity.get());
        this.chestType = chestType;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreChestBOPBlockEntity(this.chestType, pos, state);
    }
}