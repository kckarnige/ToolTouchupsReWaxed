package com.kckarnige.tooltouchupsrewaxed;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static com.kckarnige.tooltouchupsrewaxed.Tooltouchupsrewaxed.MOD_ID;
import static com.kckarnige.tooltouchupsrewaxed.Tooltouchupsrewaxed.LOGGER;

public class ItemRegister {
    public static final Item DIAMOND_INGOT = registerItem("diamond_ingot", new Item.Settings());
    public static final Item PLATE_FORGER = registerUpgradeTemplate("plate_forger", "attribute.name.armor", "item.tooltouchupsrewaxed.descriptor.ingots", new Item.Settings().rarity(Rarity.UNCOMMON));

    private static Item registerItem (String id, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
        return Registry.register(Registries.ITEM, key, new Item(itemSettings.registryKey(key)));
    }
    private static Item registerUpgradeTemplate(String id, String applies_to, String ingredients, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(MOD_ID, id)
        );

        SmithingTemplateItem netherite =
                (SmithingTemplateItem) Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE;

        Item.Settings settings =
                itemSettings.registryKey(key);

        SmithingTemplateItem item = new SmithingTemplateItem(
                Text.translatable(applies_to).formatted(Formatting.BLUE),
                Text.translatable(ingredients).formatted(Formatting.BLUE),
                Text.empty(),
                Text.empty(),
                netherite.getEmptyBaseSlotTextures(),
                netherite.getEmptyAdditionsSlotTextures(),
                settings
        );

        return Registry.register(
                Registries.ITEM,
                key,
                item
        );
    }


    public static void registerModItems () {
        LOGGER.info("Setting the crafting table...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addBefore(Items.NETHERITE_SCRAP,
                    DIAMOND_INGOT
            );
            content.addBefore(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,
                    PLATE_FORGER
            );
        });
    }
}
