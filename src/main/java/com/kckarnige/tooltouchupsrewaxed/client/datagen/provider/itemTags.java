package com.kckarnige.tooltouchupsrewaxed.client.datagen.provider;

import static com.kckarnige.tooltouchupsrewaxed.ItemRegister.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class itemTags extends FabricTagProvider.ItemTagProvider {
    public itemTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup wrapperLookup) {
        // Tools
        builder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(Registries.ITEM.getKey(DIAMOND_INGOT).orElseThrow());
    }
}
