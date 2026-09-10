package com.kckarnige.tooltouchupsrewaxed;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.kckarnige.tooltouchupsrewaxed.Tooltouchupsrewaxed.MOD_ID;
import static com.kckarnige.tooltouchupsrewaxed.Tooltouchupsrewaxed.LOGGER;

public class ItemRegister {
    public static final Item DIAMOND_INGOT = registerItem("diamond_ingot", new Item.Settings());

    private static Item registerItem (String id, Item.Settings item) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new Item(item.registryKey(key)));
    }


    public static void registerModItems () {
        LOGGER.info("Setting the crafting table...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addBefore(Items.NETHERITE_SCRAP,
                    DIAMOND_INGOT
            );
        });
    }
}
