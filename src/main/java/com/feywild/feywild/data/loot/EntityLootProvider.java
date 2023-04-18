package com.feywild.feywild.data.loot;

import com.feywild.feywild.block.ModTrees;
import com.feywild.feywild.block.trees.BaseTree;
import com.feywild.feywild.entity.ModEntities;
import com.feywild.feywild.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.moddingx.libx.annotation.data.Datagen;
import org.moddingx.libx.datagen.provider.loot.EntityLootProviderBase;
import org.moddingx.libx.mod.ModX;

@Datagen
public class EntityLootProvider extends EntityLootProviderBase {

    public EntityLootProvider(ModX mod, DataGenerator generator) {
        super(mod, generator);
    }

    @Override
    protected void setup() {
        this.drops(ModEntities.springPixie, new ItemStack(ModItems.feyDust));
        this.drops(ModEntities.summerPixie, new ItemStack(ModItems.feyDust));
        this.drops(ModEntities.autumnPixie, new ItemStack(ModItems.feyDust));
        this.drops(ModEntities.winterPixie, new ItemStack(ModItems.feyDust));
        this.drops(ModEntities.beeKnight, this.combine(
                this.stack(ModItems.feyDust),
                this.stack(ModItems.honeycomb).with(this.random(0.01f))
        ));
        this.drops(ModEntities.mandragora, this.combine(
                this.stack(ModItems.feyDust),
                this.stack(Items.MELON_SEEDS).with(this.random(0.25f)),
                this.stack(Items.PUMPKIN_SEEDS).with(this.random(0.25f)),
                this.stack(Items.WHEAT_SEEDS).with(this.random(0.25f)),
                this.stack(Items.BEETROOT_SEEDS).with(this.random(0.25f))
        ));

        this.drops(ModEntities.mab, new ItemStack(ModItems.pixieWingTiara));
        this.drops(ModEntities.titania, new ItemStack(ModItems.pixieWingTiara));

        this.drops(ModEntities.dwarfBlacksmith, new ItemStack(ItemStack.EMPTY.getItem()));
        this.drops(ModEntities.dwarfArtificer, new ItemStack(ItemStack.EMPTY.getItem()));
        this.drops(ModEntities.dwarfBaker, new ItemStack(ItemStack.EMPTY.getItem()));
        this.drops(ModEntities.dwarfMiner, new ItemStack(ItemStack.EMPTY.getItem()));
        this.drops(ModEntities.dwarfDragonHunter, new ItemStack(ItemStack.EMPTY.getItem()));
        this.drops(ModEntities.dwarfShepherd, new ItemStack(ItemStack.EMPTY.getItem()));
        this.drops(ModEntities.dwarfToolsmith, new ItemStack(ItemStack.EMPTY.getItem()));

        getTreeEntDrops(ModEntities.springTreeEnt, ModTrees.springTree);
        getTreeEntDrops(ModEntities.summerTreeEnt, ModTrees.summerTree);
        //getTreeEntDrops(ModEntities.autumnTreeEnt, ModTrees.autumnTree);
        getTreeEntDrops(ModEntities.winterTreeEnt, ModTrees.winterTree);
        getTreeEntDrops(ModEntities.blossomTreeEnt, ModTrees.blossomTree);
        getTreeEntDrops(ModEntities.hexenTreeEnt, ModTrees.hexenTree);
    }

    private void getTreeEntDrops(EntityType entityType, BaseTree tree) {
        this.drops(entityType,
                this.combine(this.stack(ModItems.feyDust),
                        this.stack(tree.getWoodBlock()).with(this.random(0.25f)),
                        this.stack(tree.getSapling()).with(this.random(0.25f)),
                        this.stack(tree.getLogBlock()).with(this.random(0.25f)),
                        this.stack(tree.getLeafBlock()).with(this.random(0.25f))
                ));
    }
}
