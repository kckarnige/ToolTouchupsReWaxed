package com.kckarnige.tooltouchupsrewaxed.client.datagen.provider;

import com.kckarnige.tooltouchupsrewaxed.ItemRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.DyeColor;

import java.util.concurrent.CompletableFuture;

public class recipes extends FabricRecipeProvider {
    public recipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShapeless(RecipeCategory.MISC, ItemRegister.DIAMOND_INGOT)
                        .input(Items.GOLD_INGOT, 4)
                        .input(Items.DIAMOND, 4)
                        .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET)
                        .pattern("-#-")
                        .pattern("# #")
                        .input('#', Items.IRON_CHAIN)
                        .input('-', Items.IRON_NUGGET)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_CHAIN))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                        .pattern("# #")
                        .pattern("#-#")
                        .pattern("-#-")
                        .input('#', Items.IRON_CHAIN)
                        .input('-', Items.IRON_NUGGET)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_CHAIN))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                        .pattern("#-#")
                        .pattern("# #")
                        .pattern("- -")
                        .input('#', Items.IRON_CHAIN)
                        .input('-', Items.IRON_NUGGET)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_CHAIN))
                        .offerTo(exporter);


                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                        .pattern("# #")
                        .pattern("- -")
                        .input('#', Items.IRON_CHAIN)
                        .input('-', Items.IRON_NUGGET)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_CHAIN))
                        .offerTo(exporter);
            }
        };
    }


    @Override
    public String getName() {
        return "Some ReWaxed Recipes";
    }
}
