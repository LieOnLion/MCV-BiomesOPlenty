package io.github.lieonlion.mcvbop.blocks;

import io.github.lieonlion.mcvbop.init.MoreChestBOPInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MoreChestBOPBlockEntity extends ChestBlockEntity {
    private MoreChestBOPEnum chestType;

    public MoreChestBOPBlockEntity(BlockPos pos, BlockState state) {
        this(MoreChestBOPEnum.FIR, pos, state);
    }

    public MoreChestBOPBlockEntity(MoreChestBOPEnum chestType, BlockPos pos, BlockState state) {
        super(MoreChestBOPInit.chest_entity.get(), pos, state);
        this.chestType = chestType;
    }

    public MoreChestBOPEnum getChestType() {
        return chestType;
    }
}
