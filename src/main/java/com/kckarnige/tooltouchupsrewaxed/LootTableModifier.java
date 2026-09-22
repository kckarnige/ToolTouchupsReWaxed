package com.kckarnige.tooltouchupsrewaxed;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetEnchantmentsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;

import static com.kckarnige.tooltouchupsrewaxed.Tooltouchupsrewaxed.SWIFT_STRIKE;

public class LootTableModifier {

    public static void initialize() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

            if (!source.isBuiltin()) {
                return;
            }
            if (
                    key.equals(LootTables.VILLAGE_ARMORER_CHEST) ||
                            key.equals(LootTables.VILLAGE_WEAPONSMITH_CHEST) ||
                            key.equals(LootTables.VILLAGE_TOOLSMITH_CHEST) ||
                            key.equals(LootTables.SIMPLE_DUNGEON_CHEST) ||
                            key.equals(LootTables.TRIAL_CHAMBERS_CORRIDOR_POT) ||
                            key.equals(LootTables.TRIAL_CHAMBERS_CORRIDOR_CHEST) ||
                            key.equals(LootTables.DESERT_PYRAMID_CHEST) ||
                            key.equals(LootTables.UNDERWATER_RUIN_BIG_CHEST) ||
                            key.equals(LootTables.UNDERWATER_RUIN_SMALL_CHEST) ||
                            key.equals(LootTables.BASTION_TREASURE_CHEST) ||
                            key.equals(LootTables.BASTION_BRIDGE_CHEST) ||
                            key.equals(LootTables.BASTION_HOGLIN_STABLE_CHEST) ||
                            key.equals(LootTables.BASTION_OTHER_CHEST) ||
                            key.equals(LootTables.RUINED_PORTAL_CHEST) ||
                            key.equals(LootTables.NETHER_BRIDGE_CHEST)
            ) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(
                                RandomChanceLootCondition.builder(
                                        ConstantLootNumberProvider.create(0.25f)
                                )
                        )
                        .with(
                                ItemEntry.builder(ItemRegister.PLATE_FORGER)
                                        .apply(
                                                SetCountLootFunction.builder(
                                                        UniformLootNumberProvider.create(1, 6)
                                                )
                                        )
                        );
                tableBuilder.pool(pool);
            }
            if (
                    key.equals(LootTables.BASTION_TREASURE_CHEST) ||
                            key.equals(LootTables.BASTION_BRIDGE_CHEST) ||
                            key.equals(LootTables.BASTION_HOGLIN_STABLE_CHEST) ||
                            key.equals(LootTables.BASTION_OTHER_CHEST) ||
                            key.equals(LootTables.RUINED_PORTAL_CHEST) ||
                            key.equals(LootTables.NETHER_BRIDGE_CHEST)
            ) {
                RegistryEntryLookup<Enchantment> enchantments =
                        registries.getOrThrow(RegistryKeys.ENCHANTMENT);

                var swiftStrike =
                        enchantments.getOrThrow(SWIFT_STRIKE);

                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(
                                RandomChanceLootCondition.builder(
                                        ConstantLootNumberProvider.create(0.15f)
                                )
                        )
                        .with(
                                ItemEntry.builder(Items.ENCHANTED_BOOK)
                                        .apply(new SetEnchantmentsLootFunction.Builder()
                                                .enchantment(
                                                        swiftStrike,
                                                        ConstantLootNumberProvider.create(2)
                                                )
                                        )
                        )
                        .with(
                                ItemEntry.builder(Items.GOLDEN_SWORD)
                                        .apply(new SetEnchantmentsLootFunction.Builder()
                                                .enchantment(
                                                        swiftStrike,
                                                        ConstantLootNumberProvider.create(2)
                                                )
                                        )
                        );

                tableBuilder.pool(pool);
            }
        });
    }
}