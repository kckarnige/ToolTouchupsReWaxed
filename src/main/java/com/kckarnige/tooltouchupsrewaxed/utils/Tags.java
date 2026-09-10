package com.kckarnige.tooltouchupsrewaxed.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static com.kckarnige.tooltouchupsrewaxed.Tooltouchupsrewaxed.MOD_ID;
public class Tags {

    public static final TagKey<Block> NEEDS_COPPER_TOOL = createBlockTag("needs_copper_tool");


    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name));
    }
    private static TagKey<Item> createItemTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
    }
}
