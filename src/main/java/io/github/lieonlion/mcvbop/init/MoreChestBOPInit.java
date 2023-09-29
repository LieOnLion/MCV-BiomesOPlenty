package io.github.lieonlion.mcvbop.init;

import io.github.lieonlion.mcvbop.MoreChestVariantsBOP;
import io.github.lieonlion.mcvbop.blocks.MoreChestBOPBlock;
import io.github.lieonlion.mcvbop.blocks.MoreChestBOPEnum;
import io.github.lieonlion.mcvbop.blocks.MoreChestBOPBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

public class MoreChestBOPInit {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreChestVariantsBOP.MODID);
    private static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoreChestVariantsBOP.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreChestVariantsBOP.MODID);

    public static RegistryObject<MoreChestBOPBlock>[] chests = new RegistryObject[MoreChestBOPEnum.VALUES.length];
    public static RegistryObject<BlockEntityType<MoreChestBOPBlockEntity>> chest_entity;

    public static void register() {
        for (MoreChestBOPEnum type : MoreChestBOPEnum.VALUES) {
            RegistryObject<MoreChestBOPBlock> chest_block = BLOCKS.register(type.getId(), () -> new MoreChestBOPBlock(type, type.getMapColour()));
            chests[type.ordinal()] = chest_block;

            ITEMS.register(type.getId(), () -> new BlockItem(chest_block.get(), new Item.Properties()));
        }

        chest_entity = TILE_ENTITIES.register("chest_tile", () -> BlockEntityType.Builder.of(MoreChestBOPBlockEntity::new, Arrays.stream(chests).map(RegistryObject::get).toArray(Block[]::new)).build(null));

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
