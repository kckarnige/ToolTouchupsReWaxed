package com.kckarnige.tooltouchupsrewaxed.client.datagen.provider;

import com.kckarnige.tooltouchupsrewaxed.ItemRegister;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class models extends FabricModelProvider {

    public models(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ItemRegister.DIAMOND_INGOT, Models.GENERATED);
        itemModelGenerator.register(ItemRegister.PLATE_FORGER, Models.GENERATED);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }
}
