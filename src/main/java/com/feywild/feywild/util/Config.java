package com.feywild.feywild.util;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.events.SpawnData;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.File;
import java.util.Arrays;
import java.util.Set;


public class Config {

    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    //CONFIG VARIABLES
    public static ForgeConfigSpec.IntValue FEY_DUST_DURATION;

    public static MobConfig SPRING_PIXIE_CONFIG;
    public static MobConfig SUMMER_PIXIE_CONFIG;
    public static MobConfig AUTUMN_PIXIE_CONFIG;
    public static MobConfig WINTER_PIXIE_CONFIG;
    public static MobConfig DWARF_CONFIG;

    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        setFeyDustDuration(SERVER_BUILDER, CLIENT_BUILDER);
        setMobConfigs(SERVER_BUILDER, CLIENT_BUILDER);


        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();


    }

    //CONFIG METHOD
    private static void setFeyDustDuration(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER){

        FEY_DUST_DURATION = CLIENT_BUILDER.comment("How long fey dust effect lasts")
                .defineInRange("fey_dust_duration", 15, 0, 180);
    }

    private static void setMobConfigs(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER){

        SPRING_PIXIE_CONFIG = new MobConfig ("Spring Pixie", 40, 1 , 1,
                Arrays.asList("MAGICAL", "RIVER", "FOREST", "PLAINS"));
        SUMMER_PIXIE_CONFIG = new MobConfig ("Summer Pixie", 40, 1, 1,
                Arrays.asList("LUSH", "MAGICAL", "HOT"));
        AUTUMN_PIXIE_CONFIG = new MobConfig("Autumn Pixie", 40, 1, 1,
                Arrays.asList("SWAMP", "MUSHROOM", "MAGICAL", "SPOOKY", "FOREST"));
        WINTER_PIXIE_CONFIG = new MobConfig("Winter Pixie", 40,1,1,
                Arrays.asList("DEAD", "MAGICAL", "SNOWY", "COLD"));
        DWARF_CONFIG = new MobConfig("Dwarf", 1,1,3,Arrays.asList("ALL"));

        SPRING_PIXIE_CONFIG.apply(CLIENT_BUILDER);
        SUMMER_PIXIE_CONFIG.apply(CLIENT_BUILDER);
        AUTUMN_PIXIE_CONFIG.apply(CLIENT_BUILDER);
        WINTER_PIXIE_CONFIG.apply(CLIENT_BUILDER);
        DWARF_CONFIG.apply(CLIENT_BUILDER);

    }



    //LOAD
    public static void loadConfigFile(ForgeConfigSpec config, String path){

        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path))
        .sync().autosave().writingMode(WritingMode.REPLACE).build();

        file.load();
        config.setConfig(file);

    }

}
