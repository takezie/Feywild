package com.feywild.feywild.events;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.entity.ModEntityTypes;
import com.feywild.feywild.entity.SpringPixieEntity;
import com.feywild.feywild.util.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.*;

@Mod.EventBusSubscriber(modid = FeywildMod.MOD_ID)
public class SpawnData {

    public static List<BiomeDictionary.Type> biomeSpring = Config.SPRING_PIXIE_CONFIG.getBiomes();
    //public static String[] biomeSpring = new String[]{"MAGICAL", "RIVER", "FOREST", "PLAINS"};
    public static List<BiomeDictionary.Type> biomeSummer = Config.SUMMER_PIXIE_CONFIG.getBiomes();
    //public static String[] biomeSummer = new String[]{"LUSH", "MAGICAL", "HOT"};
    public static List<BiomeDictionary.Type> biomeAutumn = Config.AUTUMN_PIXIE_CONFIG.getBiomes();
    //public static String[] biomeAutumn = new String[]{"SWAMP", "MUSHROOM", "MAGICAL", "SPOOKY", "FOREST"};
    public static List<BiomeDictionary.Type> biomeWinter = Config.WINTER_PIXIE_CONFIG.getBiomes();
    //public static String[] biomeWinter = new String[]{"DEAD", "MAGICAL", "SNOWY", "COLD"};

    //Spawn entities on biome load
    @SubscribeEvent
    public static void spawnEntities(BiomeLoadingEvent event)
    {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if (!types.contains(BiomeDictionary.Type.NETHER) && !types.contains(BiomeDictionary.Type.END)
                && !types.contains(BiomeDictionary.Type.OCEAN)) {

            for (BiomeDictionary.Type biomeName : biomeSpring) { //if (types.contains(Type.getType(biomeName))) {
                if (types.contains(biomeName)) {
                    addSpawn(event, ModEntityTypes.SPRING_PIXIE.get(), EntityClassification.CREATURE,
                            Config.SPRING_PIXIE_CONFIG.getWeight(), Config.SPRING_PIXIE_CONFIG.getMin(), Config.AUTUMN_PIXIE_CONFIG.getMax());
                    }
                }

            for (BiomeDictionary.Type biomeName : biomeSummer) {
                if (types.contains(biomeName)) {
                    addSpawn(event, ModEntityTypes.SUMMER_PIXIE.get(), EntityClassification.CREATURE,
                            Config.SUMMER_PIXIE_CONFIG.getWeight(), Config.SUMMER_PIXIE_CONFIG.getMin(),Config.SUMMER_PIXIE_CONFIG.getMax());
                }
            }

            for (BiomeDictionary.Type biomeName : biomeAutumn) {
                if (types.contains(biomeName)) {
                    addSpawn(event, ModEntityTypes.AUTUMN_PIXIE.get(), EntityClassification.CREATURE,
                            Config.AUTUMN_PIXIE_CONFIG.getWeight(),Config.AUTUMN_PIXIE_CONFIG.getMin(),Config.AUTUMN_PIXIE_CONFIG.getMax());
                }
            }

            for (BiomeDictionary.Type biomeName : biomeWinter) {
                if (types.contains(biomeName)) {
                    addSpawn(event, ModEntityTypes.WINTER_PIXIE.get(), EntityClassification.CREATURE,
                            Config.WINTER_PIXIE_CONFIG.getWeight(),Config.WINTER_PIXIE_CONFIG.getMin(), Config.WINTER_PIXIE_CONFIG.getMax());
                }
            }
        }
    }

    private static void addSpawn(BiomeLoadingEvent event, EntityType<? extends Entity> type, EntityClassification classification,int weight, int min, int max)
    {
            MobSpawnInfo.Spawners spawnInfo = new MobSpawnInfo.Spawners(type, weight, min, max);
            event.getSpawns().getSpawner(classification).add(spawnInfo);
    }

    /*check for climate and add
    private static void addSpawnClimate(BiomeLoadingEvent event,Biome.Climate climate, EntityType<? extends Entity> type, EntityClassification classification,int weight, int min, int max)
    {
        if(type.equals(ModEntityTypes.SPRING_PIXIE.get()) && (climate.temperature >=0.6 || climate.temperature <=0.7f)) {
            MobSpawnInfo.Spawners spawnInfo = new MobSpawnInfo.Spawners(type, weight, min, max);
            event.getSpawns().getSpawner(classification).add(spawnInfo);
        }

        if(type.equals(ModEntityTypes.AUTUMN_PIXIE.get()) && (climate.temperature >=0.7 || climate.temperature <=0.8f)) {
            MobSpawnInfo.Spawners spawnInfo = new MobSpawnInfo.Spawners(type, weight, min, max);
            event.getSpawns().getSpawner(classification).add(spawnInfo);
        }

        if(type.equals(ModEntityTypes.SUMMER_PIXIE.get()) && (climate.temperature >=0.8)) {
            MobSpawnInfo.Spawners spawnInfo = new MobSpawnInfo.Spawners(type, weight, min, max);
            event.getSpawns().getSpawner(classification).add(spawnInfo);
        }

        if(type.equals(ModEntityTypes.WINTER_PIXIE.get()) && (climate.temperature <=0.0)) {
            MobSpawnInfo.Spawners spawnInfo = new MobSpawnInfo.Spawners(type, weight, min, max);
            event.getSpawns().getSpawner(classification).add(spawnInfo);
        }
    }*/


    //Register spawning conditions
    public static void registerSpawn(){
        EntitySpawnPlacementRegistry.register(ModEntityTypes.SPRING_PIXIE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModEntityTypes::spawnFey);

        EntitySpawnPlacementRegistry.register(ModEntityTypes.AUTUMN_PIXIE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModEntityTypes::spawnFey);

        EntitySpawnPlacementRegistry.register(ModEntityTypes.SUMMER_PIXIE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModEntityTypes::spawnFey);

        EntitySpawnPlacementRegistry.register(ModEntityTypes.WINTER_PIXIE.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModEntityTypes::spawnFey);
    }


//list consisting of elements from: |SAVANNA, CONIFEROUS, JUNGLE, SPOOKY, DEAD, LUSH,
// NETHER, END, MUSHROOM, MAGICAL, RARE, OCEAN, RIVER, WATER, MESA, FOREST, PLAINS,
// MOUNTAIN, HILLS, SWAMP, SANDY, SNOWY, WASTELAND, BEACH, VOID

}

