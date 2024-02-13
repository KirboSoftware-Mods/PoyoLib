package com.kirbosoftware.poyolib.api.world.entity.npc;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * The {@code VillagerTradeHelper} class provides utility methods for modifying trades of villagers.
 * These methods can be used to customize the trades offered by villagers based on their profession and tier.
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * // Modify trades using a consumer
 * VillagerTradeHelper.modifyTrades(VillagerProfession.FARMER, 1, tradeList -> {
 *     // Add or modify trades in the provided list
 *     tradeList.add(new VillagerTrades.ItemListing(...));
 *     // Additional trade modifications...
        * });
        *
        * // Modify a specific trade using an ItemListing factory
        * VillagerTradeHelper.modifyTrades(VillagerProfession.FISHERMAN, 2, 0, new VillagerTrades.ItemListing(...));
        * }
        * </pre>
        *
        * <p>Note: It is important to handle trades carefully to avoid unintended consequences.</p>
        */
@SuppressWarnings("unused")
public class VillagerTradeHelper {

    /**
     * Modifies the trades for a specific villager profession and tier using a consumer.
     *
     * @param profession The villager's profession.
     * @param tier       The tier of the trades to be modified.
     * @param factory    A consumer providing a list of {@code ItemListing} to be added or modified.
     */
    public static void modifyTrades(VillagerProfession profession, int tier, Consumer<List<VillagerTrades.ItemListing>> factory) {
        List<VillagerTrades.ItemListing> list = new ArrayList<>();
        factory.accept(list);
        VillagerTrades.ItemListing[] originalEntries = VillagerTrades.TRADES.get(profession).get(tier);
        VillagerTrades.ItemListing[] modifiedEntries = list.toArray(new VillagerTrades.ItemListing[0]);
        System.arraycopy(modifiedEntries, 0, originalEntries, 0, modifiedEntries.length);
    }

    /**
     * Modifies a specific trade for a given villager profession, tier, and trade ID.
     *
     * @param profession The villager's profession.
     * @param tier       The tier of the trade to be modified.
     * @param tradeId    The ID of the trade within the specified tier.
     * @param factory    The {@code ItemListing} to replace the existing trade.
     */
    public static void modifyTrades(VillagerProfession profession, int tier, int tradeId, VillagerTrades.ItemListing factory) {
        VillagerTrades.TRADES.get(profession).get(tier)[tradeId] = factory;
    }
}