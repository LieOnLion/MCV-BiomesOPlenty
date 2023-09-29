package io.github.lieonlion.mcvbop.client;

import io.github.lieonlion.mcvbop.MoreChestVariantsBOP;
import io.github.lieonlion.mcvbop.init.MoreChestBOPInit;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = MoreChestVariantsBOP.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreChestBOPClient {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void doClientStuff(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(MoreChestBOPInit.chest_entity.get(), MoreChestBOPRenderer::new);
    }
}