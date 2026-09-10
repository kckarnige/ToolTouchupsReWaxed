package com.kckarnige.tooltouchupsrewaxed.client.datagen.provider;

import com.kckarnige.tooltouchupsrewaxed.utils.Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class blockTags extends FabricTagProvider.BlockTagProvider {
    public blockTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        builder(Tags.NEEDS_COPPER_TOOL)
                .add(Registries.BLOCK.getKey(Blocks.IRON_ORE).orElseThrow())
                .add(Registries.BLOCK.getKey(Blocks.DEEPSLATE_IRON_ORE).orElseThrow());

        builder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(Tags.NEEDS_COPPER_TOOL);

        builder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addOptionalTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .setReplace(true);
    }
}
