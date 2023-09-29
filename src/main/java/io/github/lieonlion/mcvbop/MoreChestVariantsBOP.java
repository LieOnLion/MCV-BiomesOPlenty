package io.github.lieonlion.mcvbop;

import io.github.lieonlion.mcvbop.init.MoreChestBOPInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

@Mod(MoreChestVariantsBOP.MODID)
public class MoreChestVariantsBOP {
    public static final String MODID = "lolmcvbop";

    /*
        most code for this mod is taken from DoctorFTB's Stone Chest
        Copyright (c) 2018
     */

    public MoreChestVariantsBOP() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MoreChestBOPInit.register();

        modEventBus.addListener((BuildCreativeModeTabContentsEvent event) -> {
            if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS || event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
                MoreChestBOPInit.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(event::accept);
            }
        });

        MinecraftForge.EVENT_BUS.register(this);
    }
}