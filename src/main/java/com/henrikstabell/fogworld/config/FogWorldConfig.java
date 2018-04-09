package com.henrikstabell.fogworld.config;

import com.google.common.collect.Lists;
import com.henrikstabell.fogworld.FogWorld;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

/**
 * See The repos LICENSE.MD file for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 03/04/2018.
 */
@Config(modid = FogWorld.MODID, name = "fogworld")
@Config.LangKey("fogworld.config.title")
public class FogWorldConfig {

    @Config.Name("Fog Density")
    @Config.Comment("How thick should the fog be?")
    @Config.RequiresWorldRestart
    public static float fogDensity = 0.1F;

    @Config.Name("Fog Color")
    @Config.Comment({"What color should the fog be?", "Expects the color to be in decimal"})
    @Config.RequiresWorldRestart
    public static int fogColor = 16777215;

    @Config.Name("Poison Fog")
    @Config.Comment("Should the fog be poisonous?")
    public static boolean poisonousFog = false;

    @Config.Name("Poison Fog Delay")
    @Config.Comment({"How many ticks before the player takes damage from the poisonous fog?", "Set in ticks; 1 second = 20 ticks"})
    public static int posionTicks = 1200;

    @Config.Name("Poison Fog Damage")
    @Config.Comment("How much damage should the poison fog deal per tick?")
    public static int poisonDamage = 1;

    @Config.Name("Disabled Biomes")
    @Config.Comment({"A list of disabled biomes, add a biome name or ID to this list and the biome will not render with fog.", "Ex. \"ForestHills \" or \"18\" will disable fog in the Forest Hills biome."})
    @Config.RequiresWorldRestart
    public static String[] fogBiomeBlacklist = {};

    @Config.Name("Disabled Dimensions")
    @Config.Comment({"A list of disabled dimensions, add a dimension name or ID to this list and the dimension will not render with fog.", "Ex. \"the_nether\" or \"-1\" will disable fog in the Nether."})
    @Config.RequiresWorldRestart
    public static String[] fogDimensionBlacklist = {};

    // =======================================================
    //                    CONFIG END
    // =======================================================

    public static float getFogDensity(int var1, int var2, int var3) {
        return fogDensity;
    }

    public static int getFogColor(int var1, int var2, int var3) {
        return fogColor;
    }

    public static List<String> getFogBiomeBlacklist() {
        return Lists.newArrayList(fogBiomeBlacklist);
    }

    public static List<String> getFogDimensionBlacklist() {
        return Lists.newArrayList(fogDimensionBlacklist);
    }

    @Mod.EventBusSubscriber(modid = FogWorld.MODID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChangedEvent(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(FogWorld.MODID)) {
                ConfigManager.sync(FogWorld.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
