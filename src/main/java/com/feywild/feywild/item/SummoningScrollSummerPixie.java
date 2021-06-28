package com.feywild.feywild.item;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.container.PixieContainer;
import com.feywild.feywild.entity.SummerPixieEntity;
import com.feywild.feywild.quest.QuestMap;
import com.feywild.feywild.util.KeyboardHelper;
import com.feywild.feywild.util.ModUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.scoreboard.Score;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class SummoningScrollSummerPixie extends Item {

    public SummoningScrollSummerPixie() {
        super(new Item.Properties().tab(FeywildMod.FEYWILD_TAB));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        if (!context.getLevel().isClientSide) {

            PlayerEntity player = context.getPlayer();

            SummerPixieEntity entity = new SummerPixieEntity(context.getLevel(), true, context.getClickedPos());
            entity.setTag(entity);

            entity.setPos(context.getClickLocation().x(), context.getClickLocation().y(), context.getClickLocation().z());
            player.sendMessage(new TranslationTextComponent("summer_quest_pixie.feywild.summon_message"), player.getUUID());

            context.getLevel().addFreshEntity(entity);
            context.getPlayer().getItemInHand(context.getHand()).shrink(1);

            //  entity.playSound(ModSoundEvents.SUMMONING_SUMMER_PIXIE.get(), 1, 1);

            /* QUEST */

            Score questId = ModUtil.getOrCreatePlayerScore(player.getName().getString(), QuestMap.Scores.FW_Quest.toString(), player.level, 100);

            if (!QuestMap.getSound(questId.getScore()).equals("NULL"))
                player.level.playSound(null, player.blockPosition(), Objects.requireNonNull(Registry.SOUND_EVENT.get(new ResourceLocation(QuestMap.getSound(questId.getScore())))), SoundCategory.VOICE, 1, 1);

            INamedContainerProvider containerProvider = new INamedContainerProvider() {
                @Override
                public ITextComponent getDisplayName() {
                    return new TranslationTextComponent("screen.feywild.pixie");
                }

                @Nullable
                @Override
                public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {

                    return new PixieContainer(i, playerInventory, playerEntity, entity);
                }
            };

            NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider);

        }

        return ActionResultType.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {

        if (KeyboardHelper.isHoldingShift()) {

            tooltip.add(new TranslationTextComponent("message.feywild.summer_pixie"));
        } else {
            tooltip.add(new TranslationTextComponent("message.feywild.itemmessage"));
        }

        super.appendHoverText(stack, world, tooltip, flag);
    }

}
