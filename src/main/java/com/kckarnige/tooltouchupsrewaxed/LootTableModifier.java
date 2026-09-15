package com.kckarnige.tooltouchupsrewaxed;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetEnchantmentsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;

import static com.kckarnige.tooltouchupsrewaxed.Tooltouchupsrewaxed.SWIFT_STRIKE;

public class LootTableModifier {

    public static void initialize() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

            if (!source.isBuiltin()) {
                return;
            }

            // All four Bastion chest loot tables
            if (
                    key.equals(LootTables.BASTION_TREASURE_CHEST) ||
                            key.equals(LootTables.BASTION_BRIDGE_CHEST) ||
                            key.equals(LootTables.BASTION_HOGLIN_STABLE_CHEST) ||
                            key.equals(LootTables.BASTION_OTHER_CHEST)
            ) {

                RegistryEntryLookup<Enchantment> enchantments =
                        registries.getOrThrow(RegistryKeys.ENCHANTMENT);

                var swiftStrike =
                        enchantments.getOrThrow(SWIFT_STRIKE);

                LootPool.Builder pool = LootPool.builder()

                        // Try once per chest
                        .rolls(ConstantLootNumberProvider.create(1))

                        // 10% chance
                        .conditionally(
                                RandomChanceLootCondition.builder(
                                        ConstantLootNumberProvider.create(0.10f)
                                )
                        )

                        // Golden Sword
                        .with(
                                ItemEntry.builder(Items.GOLDEN_SWORD)

                                        // Swift Strike I
                                        .apply(
                                                new SetEnchantmentsLootFunction.Builder()
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