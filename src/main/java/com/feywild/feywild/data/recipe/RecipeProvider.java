package com.feywild.feywild.data.recipe;

import com.feywild.feywild.block.ModBlocks;
import com.feywild.feywild.block.ModTrees;
import com.feywild.feywild.item.ModItems;
import com.feywild.feywild.tag.ModItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import org.moddingx.libx.annotation.data.Datagen;
import org.moddingx.libx.datagen.provider.recipe.DefaultExtension;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.SmeltingExtension;
import org.moddingx.libx.datagen.provider.recipe.StoneCuttingExtension;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;
import org.moddingx.libx.mod.ModX;

@Datagen
public class RecipeProvider extends RecipeProviderBase implements CraftingExtension, SmeltingExtension,
        DefaultExtension, AltarExtension, AnvilExtension, StoneCuttingExtension, VariantExtension {

    public RecipeProvider(ModX mod, DataGenerator generator) {
        super(mod, generator);
    }

    @Override
    protected void setup() {
        shaped(ModTrees.springTree.getWoodBlock(), 3, "aa", "aa", 'a', ModTrees.springTree.getLogBlock());
        shaped(ModTrees.summerTree.getWoodBlock(), 3, "aa", "aa", 'a', ModTrees.summerTree.getLogBlock());
        shaped(ModTrees.autumnTree.getWoodBlock(), 3, "aa", "aa", 'a', ModTrees.autumnTree.getLogBlock());
        shaped(ModTrees.winterTree.getWoodBlock(), 3, "aa", "aa", 'a', ModTrees.winterTree.getLogBlock());
        shaped(ModTrees.blossomTree.getWoodBlock(), 3, "aa", "aa", 'a', ModTrees.blossomTree.getLogBlock());
        shaped(ModTrees.hexenTree.getWoodBlock(), 3, "aa", "aa", 'a', ModTrees.hexenTree.getLogBlock());

        shapeless(ModTrees.autumnTree.getPlankBlock(), 4, ModItemTags.AUTUMN_LOGS);
        shapeless(ModTrees.springTree.getPlankBlock(), 4, ModItemTags.SPRING_LOGS);
        shapeless(ModTrees.summerTree.getPlankBlock(), 4, ModItemTags.SUMMER_LOGS);
        shapeless(ModTrees.winterTree.getPlankBlock(), 4, ModItemTags.WINTER_LOGS);
        shapeless(ModTrees.blossomTree.getPlankBlock(), 4, ModItemTags.BLOSSOM_LOGS);
        shapeless(ModTrees.hexenTree.getPlankBlock(), 4, ModItemTags.HEXEN_LOGS);

        shaped(ModBlocks.dwarvenAnvil, "fff", " i ", "iii", 'f', ModItems.lesserFeyGem, 'i', Tags.Items.STORAGE_BLOCKS_IRON);
        shapeless(ModItems.feyInkBottle, ModItems.feyDust, Items.INK_SAC, Items.GLASS_BOTTLE, ModItems.mandrake);
        shapeless(ModItems.mandrakePotion, Items.GLASS_BOTTLE, ModItems.mandrake, Items.GHAST_TEAR, ModItems.brilliantFeyGem);
        shapeless(ModItems.summoningScroll, Items.PAPER, ModItems.feyInkBottle, Items.FEATHER);
        shapeless(ModBlocks.feyMushroom, Tags.Items.MUSHROOMS, ModItems.feyDust);

        shapeless(ModBlocks.elvenQuartz, 4, ModItems.rawElvenQuartz, ModItems.rawElvenQuartz, ModItems.rawElvenQuartz, ModItems.rawElvenQuartz);
        shapeless(ModBlocks.elvenSpringQuartz, 4, ModItems.rawSpringElvenQuartz, ModItems.rawSpringElvenQuartz, ModItems.rawSpringElvenQuartz, ModItems.rawSpringElvenQuartz);
        shapeless(ModBlocks.elvenSummerQuartz, 4, ModItems.rawSummerElvenQuartz, ModItems.rawSummerElvenQuartz, ModItems.rawSummerElvenQuartz, ModItems.rawSummerElvenQuartz);
        shapeless(ModBlocks.elvenWinterQuartz, 4, ModItems.rawWinterElvenQuartz, ModItems.rawWinterElvenQuartz, ModItems.rawWinterElvenQuartz, ModItems.rawWinterElvenQuartz);
        shapeless(ModBlocks.elvenAutumnQuartz, 4, ModItems.rawAutumnElvenQuartz, ModItems.rawAutumnElvenQuartz, ModItems.rawAutumnElvenQuartz, ModItems.rawAutumnElvenQuartz);

        shaped(ModItems.magicalHoneyCookie, " a ", "wbw", " a ", 'a', ModItems.honeycomb, 'b', Items.COCOA_BEANS, 'w', Items.WHEAT);
        shapeless(ModItems.feywildLexicon, Items.BOOK, ModItems.feyDust);
        shaped(ModBlocks.summerFeyAltar, "fpf", "pdp", "gxg", 'f', ModItems.feyDust, 'p', Tags.Items.STONE, 'd', Items.DIAMOND, 'g', Tags.Items.INGOTS_IRON, 'x', ModTrees.summerTree.getSapling());
        shaped(ModBlocks.winterFeyAltar, "fpf", "pdp", "gxg", 'f', ModItems.feyDust, 'p', Tags.Items.STONE, 'd', Items.DIAMOND, 'g', Tags.Items.INGOTS_IRON, 'x', ModTrees.winterTree.getSapling());
        shaped(ModBlocks.autumnFeyAltar, "fpf", "pdp", "gxg", 'f', ModItems.feyDust, 'p', Tags.Items.STONE, 'd', Items.DIAMOND, 'g', Tags.Items.INGOTS_IRON, 'x', ModTrees.autumnTree.getSapling());


        shaped(ModBlocks.magicalBrazier, "lbl", "xsx", "gxg", 'l', ModItems.lesserFeyGem, 'b', Items.BOOK, 'x', Items.IRON_INGOT, 's', ModItems.shinyFeyGem, 'g', Items.GOLD_NUGGET);

        smelting(ModItems.lesserFeyGem, ModItems.feyDust, 0.1f, 100);

        stoneCutting(ModItems.greaterFeyGem, ModItems.lesserFeyGem, 2);
        stoneCutting(ModItems.shinyFeyGem, ModItems.greaterFeyGem, 2);
        stoneCutting(ModItems.brilliantFeyGem, ModItems.shinyFeyGem, 2);
        stoneCutting(ModBlocks.summerFeyAltar, ModBlocks.autumnFeyAltar);
        stoneCutting(ModBlocks.summerFeyAltar, ModBlocks.winterFeyAltar);
        stoneCutting(ModBlocks.autumnFeyAltar, ModBlocks.winterFeyAltar);
        stoneCutting(ModBlocks.autumnFeyAltar, ModBlocks.summerFeyAltar);
        stoneCutting(ModBlocks.winterFeyAltar, ModBlocks.summerFeyAltar);
        stoneCutting(ModBlocks.winterFeyAltar, ModBlocks.autumnFeyAltar);

        this.altar(ModTrees.springTree.getSapling().asItem())
                .requires(Items.OAK_SAPLING)
                .requires(Items.OAK_SAPLING)
                .requires(Items.OAK_SAPLING)
                .requires(Items.OAK_SAPLING)
                .requires(ModItems.feyDust)
                .build();

        this.altar(ModTrees.summerTree.getSapling().asItem())
                .requires(Items.BIRCH_SAPLING)
                .requires(Items.BIRCH_SAPLING)
                .requires(Items.BIRCH_SAPLING)
                .requires(Items.BIRCH_SAPLING)
                .requires(ModItems.feyDust)
                .build();

        this.altar(ModTrees.winterTree.getSapling().asItem())
                .requires(Items.SPRUCE_SAPLING)
                .requires(Items.SPRUCE_SAPLING)
                .requires(Items.SPRUCE_SAPLING)
                .requires(Items.SPRUCE_SAPLING)
                .requires(ModItems.feyDust)
                .build();

        this.altar(ModTrees.autumnTree.getSapling().asItem())
                .requires(Items.DARK_OAK_SAPLING)
                .requires(Items.DARK_OAK_SAPLING)
                .requires(Items.DARK_OAK_SAPLING)
                .requires(Items.DARK_OAK_SAPLING)
                .requires(ModItems.feyDust)
                .build();

        this.altar(ModItems.feywildMusicDisc)
                .requires(ItemTags.MUSIC_DISCS)
                .requires(ModTrees.springTree.getSapling())
                .requires(ModTrees.summerTree.getSapling())
                .requires(ModTrees.autumnTree.getSapling())
                .requires(ModTrees.winterTree.getSapling())
                .build();

        this.altar(ModItems.summoningScrollSpringPixie)
                .requires(ModTrees.springTree.getSapling())
                .requires(Blocks.OXEYE_DAISY)
                .requires(Items.WHEAT_SEEDS)
                .requires(Items.EGG)
                .requires(ModItems.summoningScroll)
                .build();

        this.altar(ModItems.summoningScrollSummerPixie)
                .requires(ModTrees.summerTree.getSapling())
                .requires(Blocks.SUNFLOWER)
                .requires(Items.HONEYCOMB)
                .requires(Items.GOLDEN_SWORD)
                .requires(ModItems.summoningScroll)
                .build();

        this.altar(ModItems.summoningScrollAutumnPixie)
                .requires(ModTrees.autumnTree.getSapling())
                .requires(Blocks.CARVED_PUMPKIN)
                .requires(Tags.Items.MUSHROOMS)
                .requires(Items.IRON_HOE)
                .requires(ModItems.summoningScroll)
                .build();

        this.altar(ModItems.summoningScrollWinterPixie)
                .requires(ModTrees.winterTree.getSapling())
                .requires(Items.SNOWBALL)
                .requires(Blocks.ICE)
                .requires(Items.ROTTEN_FLESH)
                .requires(ModItems.summoningScroll)
                .build();

        this.altar(ModItems.summoningScrollBeeKnight)
                .requires(ModItems.summoningScrollSummerPixie)
                .requires(ModItems.honeycomb)
                .requires(Blocks.BEE_NEST)
                .requires(ModItems.greaterFeyGem)
                .requires(ModItems.summoningScroll)
                .build();

        this.altar(ModItems.summoningScrollMandragora)
                .requires(ModItems.magicalHoneyCookie)
                .requires(ModItems.mandrake)
                .requires(ModItems.greaterFeyGem)
                .requires(ModItems.summoningScroll)
                .requires(ModItems.summoningScrollSpringPixie)
                .build();

        this.altar(ModItems.summoningScrollShroomling)
                .requires(Blocks.RED_MUSHROOM_BLOCK)
                .requires(Blocks.MUSHROOM_STEM)
                .requires(ModItems.greaterFeyGem)
                .requires(ModItems.summoningScroll)
                .requires(ModItems.summoningScrollAutumnPixie)
                .build();

        this.altar(ModItems.summoningScrollAllay)
                .requires(ModItems.summoningScroll)
                .requires(ModItems.summoningScrollWinterPixie)
                .requires(ModItems.greaterFeyGem)
                .requires(ModItems.soulGem)
                .requires(Items.SOUL_LANTERN)
                .build();

        this.altar(ModItems.summoningScrollSpringTreeEnt)
                .requires(ModItems.summoningScrollMandragora)
                .requires(ModItems.summoningScroll)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.rawSpringElvenQuartz)
                .requires(ModTrees.springTree.getWoodBlock())
                .build();

        this.altar(ModItems.summoningScrollSummerTreeEnt)
                .requires(ModItems.summoningScrollBeeKnight)
                .requires(ModItems.summoningScroll)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.rawSummerElvenQuartz)
                .requires(ModTrees.summerTree.getWoodBlock())
                .build();

        this.altar(ModItems.summoningScrollWinterTreeEnt)
                .requires(ModItems.summoningScroll)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.rawWinterElvenQuartz)
                .requires(ModTrees.winterTree.getWoodBlock())
                .requires(ModItems.summoningScrollAllay)
                .build();

        this.altar(ModItems.summoningScrollBlossomTreeEnt)
                .requires(ModItems.summoningScrollSpringTreeEnt)
                .requires(ModItems.summoningScrollSummerTreeEnt)
                .requires(ModItems.summoningScroll)
                .requires(Items.GOLDEN_APPLE)
                .requires(Items.PINK_CANDLE)
                .build();

        this.altar(ModItems.summoningScrollHexenTreeEnt)
                .requires(ModItems.summoningScrollWinterTreeEnt)
                .requires(Items.PURPLE_CANDLE)
                .requires(ModItems.summoningScroll)
                .requires(Items.WITHER_SKELETON_SKULL)
                .requires(Items.TOTEM_OF_UNDYING)
                .build();

        this.altar(ModItems.reaperScythe)
                .requires(ModTrees.winterTree.getWoodBlock())
                .requires(ModItems.feyDust)
                .requires(Items.DIAMOND_HOE)
                .requires(Items.PACKED_ICE)
                .requires(Items.SPORE_BLOSSOM)
                .build();

        this.altar(ModItems.soulGem)
                .requires(Items.DIAMOND)
                .requires(ModItems.soulShard)
                .requires(ModItems.soulShard)
                .requires(ModItems.soulShard)
                .requires(ModItems.soulShard)
                .build();

        this.altar(ModItems.feyWingsAutumn)
                .requires(ModItemTags.PIXIE_WING_COMPONENTS)
                .requires(ModItems.summoningScrollAutumnPixie)
                .requires(ModItems.brilliantFeyGem)
                .requires(Items.NETHER_STAR)
                .requires(ModItems.pixieOrb)
                .build();

        this.altar(ModItems.feyWingsSpring)
                .requires(ModItemTags.PIXIE_WING_COMPONENTS)
                .requires(ModItems.summoningScrollSpringPixie)
                .requires(ModItems.brilliantFeyGem)
                .requires(Items.NETHER_STAR)
                .requires(ModItems.pixieOrb)
                .build();

        this.altar(ModItems.feyWingsSummer)
                .requires(ModItemTags.PIXIE_WING_COMPONENTS)
                .requires(ModItems.summoningScrollSummerPixie)
                .requires(ModItems.brilliantFeyGem)
                .requires(Items.NETHER_STAR)
                .requires(ModItems.pixieOrb)
                .build();

        this.altar(ModItems.feyWingsWinter)
                .requires(ModItemTags.PIXIE_WING_COMPONENTS)
                .requires(ModItems.summoningScrollWinterPixie)
                .requires(ModItems.brilliantFeyGem)
                .requires(Items.NETHER_STAR)
                .requires(ModItems.pixieOrb)
                .build();

        this.altar(ModItems.feyWingsLight)
                .requires(ModItemTags.PIXIE_WING_COMPONENTS)
                .requires(ModItems.summoningScrollBlossomTreeEnt)
                .requires(ModItems.brilliantFeyGem)
                .requires(Items.NETHER_STAR)
                .requires(ModItems.pixieOrb)
                .build();

        this.altar(ModItems.feyWingsShadow)
                .requires(ModItemTags.PIXIE_WING_COMPONENTS)
                .requires(ModItems.summoningScrollHexenTreeEnt)
                .requires(ModItems.brilliantFeyGem)
                .requires(Items.NETHER_STAR)
                .requires(ModItems.pixieOrb)
                .build();

        //TODO add feywings Day, Night

        this.gemTransmutation(ModItems.lesserFeyGem, ModItems.greaterFeyGem, 50);
        this.gemTransmutation(ModItems.greaterFeyGem, ModItems.shinyFeyGem, 100);
        this.gemTransmutation(ModItems.shinyFeyGem, ModItems.brilliantFeyGem, 150);

        this.quartzRecipes(ModBlocks.elvenQuartz);
        this.quartzRecipes(ModBlocks.elvenSpringQuartz);
        this.quartzRecipes(ModBlocks.elvenSummerQuartz);
        this.quartzRecipes(ModBlocks.elvenAutumnQuartz);
        this.quartzRecipes(ModBlocks.elvenWinterQuartz);

        this.anvil(ModItems.rawElvenQuartz, 8)
                .requires(ModItems.greaterFeyGem)
                .requires(ModItems.greaterFeyGem)
                .requires(Items.QUARTZ)
                .requires(Items.QUARTZ)
                .requires(Items.WHITE_DYE)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(75)
                .build();

        this.anvil(ModItems.rawSpringElvenQuartz, 8)
                .requires(ModItems.greaterFeyGem)
                .requires(ModItems.greaterFeyGem)
                .requires(Items.QUARTZ)
                .requires(Items.QUARTZ)
                .requires(Items.GREEN_DYE)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(75)
                .build();

        this.anvil(ModItems.rawAutumnElvenQuartz, 8)
                .requires(ModItems.greaterFeyGem)
                .requires(ModItems.greaterFeyGem)
                .requires(Items.QUARTZ)
                .requires(Items.QUARTZ)
                .requires(Items.RED_DYE)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(75)
                .build();

        this.anvil(ModItems.rawSummerElvenQuartz, 8)
                .requires(ModItems.greaterFeyGem)
                .requires(ModItems.greaterFeyGem)
                .requires(Items.QUARTZ)
                .requires(Items.QUARTZ)
                .requires(Items.YELLOW_DYE)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(75)
                .build();

        this.anvil(ModItems.rawWinterElvenQuartz, 8)
                .requires(ModItems.greaterFeyGem)
                .requires(ModItems.greaterFeyGem)
                .requires(Items.QUARTZ)
                .requires(Items.QUARTZ)
                .requires(Items.BLUE_DYE)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(75)
                .build();

        this.anvil(ModItems.runeOfSpring)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.summoningScrollSpringPixie)
                .requires(Items.WRITABLE_BOOK)
                .requires(ModItems.feyInkBottle)
                .schematics(ModItems.schematicsRunestones)
                .mana(1000)
                .build();

        this.anvil(ModItems.runeOfSummer)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.summoningScrollSummerPixie)
                .requires(Items.WRITABLE_BOOK)
                .requires(ModItems.feyInkBottle)
                .schematics(ModItems.schematicsRunestones)
                .mana(1000)
                .build();

        this.anvil(ModItems.runeOfAutumn)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.summoningScrollAutumnPixie)
                .requires(Items.WRITABLE_BOOK)
                .requires(ModItems.feyInkBottle)
                .schematics(ModItems.schematicsRunestones)
                .mana(1000)
                .build();

        this.anvil(ModItems.runeOfWinter)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.shinyFeyGem)
                .requires(ModItems.summoningScrollWinterPixie)
                .requires(Items.WRITABLE_BOOK)
                .requires(ModItems.feyInkBottle)
                .schematics(ModItems.schematicsRunestones)
                .mana(1000)
                .build();

        this.anvil(ModItems.marketRuneStone)
                .requires(ModItems.inactiveMarketRuneStone)
                .schematics(ModItems.schematicsRunestones)
                .mana(1000)
                .build();

        this.anvil(ModBlocks.feyStarBlockGreen.asItem())
                .requires(Items.SAND)
                .requires(Items.SAND)
                .requires(ModItems.rawElvenQuartz)
                .requires(ModItems.rawSpringElvenQuartz)
                .requires(Items.AMETHYST_SHARD)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(150)
                .build();

        this.anvil(ModBlocks.feyStarBlockLightBlue.asItem())
                .requires(Items.SAND)
                .requires(Items.SAND)
                .requires(ModItems.rawWinterElvenQuartz)
                .requires(ModItems.rawSpringElvenQuartz)
                .requires(Items.AMETHYST_SHARD)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(150)
                .build();

        this.anvil(ModBlocks.feyStarBlockBlue.asItem())
                .requires(Items.SAND)
                .requires(Items.SAND)
                .requires(ModItems.rawWinterElvenQuartz)
                .requires(ModItems.rawElvenQuartz)
                .requires(Items.AMETHYST_SHARD)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(150)
                .build();

        this.anvil(ModBlocks.feyStarBlockPurple.asItem())
                .requires(Items.SAND)
                .requires(Items.SAND)
                .requires(ModItems.rawWinterElvenQuartz)
                .requires(ModItems.rawAutumnElvenQuartz)
                .requires(Items.AMETHYST_SHARD)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(150)
                .build();

        this.anvil(ModBlocks.feyStarBlockPink.asItem())
                .requires(Items.SAND)
                .requires(Items.SAND)
                .requires(ModItems.rawSpringElvenQuartz)
                .requires(ModItems.rawSummerElvenQuartz)
                .requires(Items.AMETHYST_SHARD)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(150)
                .build();

        this.anvil(ModBlocks.feyStarBlockOrange.asItem())
                .requires(Items.SAND)
                .requires(Items.SAND)
                .requires(ModItems.rawAutumnElvenQuartz)
                .requires(ModItems.rawElvenQuartz)
                .requires(Items.AMETHYST_SHARD)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(150)
                .build();

        this.anvil(ModBlocks.feyStarBlockYellow.asItem())
                .requires(Items.SAND)
                .requires(Items.SAND)
                .requires(ModItems.rawSummerElvenQuartz)
                .requires(ModItems.rawElvenQuartz)
                .requires(Items.AMETHYST_SHARD)
                .schematics(ModItems.schematicsElvenQuartz)
                .mana(150)
                .build();
    }
}
