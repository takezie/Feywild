package com.feywild.feywild.quest.task;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.ForgeRegistries;

public class AnimalPetTask extends RegistryTaskType<EntityType<?>, Entity> {
    
    public static final AnimalPetTask INSTANCE = new AnimalPetTask();

    protected AnimalPetTask() {
        super("type", ForgeRegistries.ENTITY_TYPES);
    }

    @Override
    public Class<Entity> testType() {
        return Entity.class;
    }

    @Override
    public boolean checkCompleted(ServerPlayer player, ResourceKey<EntityType<?>> element, Entity match) {
        return element.location().equals(ForgeRegistries.ENTITY_TYPES.getKey(match.getType()));
    }
}
