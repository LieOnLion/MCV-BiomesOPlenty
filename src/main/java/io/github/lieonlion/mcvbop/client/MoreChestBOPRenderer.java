package io.github.lieonlion.mcvbop.client;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.client.MoreChestRenderer;
import io.github.lieonlion.mcvbop.MoreChestVariantsBOP;
import io.github.lieonlion.mcvbop.blocks.MoreChestBOPEnum;
import io.github.lieonlion.mcvbop.blocks.MoreChestBOPBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Calendar;
import java.util.Locale;

@OnlyIn(Dist.CLIENT)
public class MoreChestBOPRenderer extends ChestRenderer<MoreChestBOPBlockEntity> {
    public static Material[] single = new Material[MoreChestBOPEnum.VALUES.length];
    public static Material[] left = new Material[MoreChestBOPEnum.VALUES.length];
    public static Material[] right = new Material[MoreChestBOPEnum.VALUES.length];
    private static boolean christmas;
    private static boolean starwarsday;

    static {
        for (MoreChestBOPEnum type : MoreChestBOPEnum.VALUES) {
            single[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH));
            left[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_left");
            right[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_right");
        }
    }

    public MoreChestBOPRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            christmas = true;
        }
        if (calendar.get(2) + 1 == 5 && calendar.get(5) >= 3 && calendar.get(5) <= 5) {
            starwarsday = true;
        }
    }

    @Override
    protected Material getMaterial(MoreChestBOPBlockEntity blockEntity, ChestType chestType) {
        return getChestMaterial(blockEntity, chestType);
    }

    public static Material getChestMaterial(String path) {
        return new Material(Sheets.CHEST_SHEET, new ResourceLocation(MoreChestVariantsBOP.MODID, "entity/chest/" + path));
    }

    private Material getChestMaterial(MoreChestBOPBlockEntity tile, ChestType type) {
        if (christmas) {
            return Sheets.chooseMaterial(tile, type, christmas);
        } else if (starwarsday) {
            return MoreChestRenderer.chooseMaterial(type, MoreChestRenderer.getChestMaterial("starwars_left"), MoreChestRenderer.getChestMaterial("starwars_right"), MoreChestRenderer.getChestMaterial("starwars"));
        } else {
            return MoreChestRenderer.chooseMaterial(type, left[tile.getChestType().ordinal()], right[tile.getChestType().ordinal()], single[tile.getChestType().ordinal()]);
        }
    }
}
