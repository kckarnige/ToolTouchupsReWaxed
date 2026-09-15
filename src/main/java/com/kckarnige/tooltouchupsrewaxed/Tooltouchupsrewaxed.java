package com.kckarnige.tooltouchupsrewaxed;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tooltouchupsrewaxed implements ModInitializer {

    public static final String MOD_ID = "tooltouchupsrewaxed";
    public static final Logger LOGGER = LoggerFactory.getLogger("Tool Touch-Ups: ReWaxed");
    public static final RegistryKey<Enchantment> SWIFT_STRIKE =
            RegistryKey.of(
                    RegistryKeys.ENCHANTMENT,
                    Identifier.of(MOD_ID, "swift_strike")
            );
    @Override
    public void onInitialize() {
        ItemRegister.registerModItems();
        LootTableModifier.initialize();
        AttributeModifier.initialize();
    }
}
