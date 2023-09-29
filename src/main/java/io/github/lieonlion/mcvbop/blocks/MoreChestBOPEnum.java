package io.github.lieonlion.mcvbop.blocks;

import net.minecraft.world.level.material.MapColor;

public enum MoreChestBOPEnum {
      FIR,
      REDWOOD,
      MAHOGANY,
      JACARANDA,
      PALM,
      WILLOW,
      DEAD,
      MAGIC,
      UMBRAN,
      HELLBARK;

      public static final MoreChestBOPEnum[] VALUES = values();

      public String getId() {
            return this.name().toLowerCase() + "_chest";
      }

      public MapColor getMapColour() {
            return switch (this) {
                  case FIR -> MapColor.TERRACOTTA_WHITE;
                  case REDWOOD -> MapColor.TERRACOTTA_ORANGE;
                  case MAHOGANY -> MapColor.TERRACOTTA_PINK;
                  case JACARANDA -> MapColor.QUARTZ;
                  case PALM -> MapColor.TERRACOTTA_YELLOW;
                  case WILLOW -> MapColor.TERRACOTTA_LIGHT_GREEN;
                  case DEAD -> MapColor.STONE;
                  case MAGIC -> MapColor.COLOR_BLUE;
                  case UMBRAN -> MapColor.TERRACOTTA_BLUE;
                  case HELLBARK -> MapColor.TERRACOTTA_GRAY;
            };
      }
}