package com.kckarnige.tooltouchupsrewaxed.client.datagen.provider;

import com.kckarnige.tooltouchupsrewaxed.ItemRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.recipe.TransmuteRecipeResult;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static com.kckarnige.tooltouchupsrewaxed.Tooltouchupsrewaxed.MOD_ID;


public class recipes extends FabricRecipeProvider {
    public recipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeGenerator getRecipeGenerator(RegistryWrapper.@NonNull WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            private void SmithingRecipeGenerator (
                    Boolean pf_required,
                    Item material,
                    Item baseItem,
                    Item result,
                    String category
            ) {

                Ingredient PLATE_ENFORCER = pf_required ? Ingredient.ofItems(ItemRegister.PLATE_FORGER) : null;
                String RecipeID = (Registries.ITEM.getId(result).getPath() + "_smithing").toLowerCase();

                RegistryKey<Recipe<?>> armorRecipeKey = RegistryKey.of(
                        RegistryKeys.RECIPE,
                        Identifier.of(MOD_ID, RecipeID)
                );
                SmithingTransformRecipe armorRecipe = new SmithingTransformRecipe(
                        Optional.ofNullable(PLATE_ENFORCER),
                        Ingredient.ofItems(baseItem),
                        Optional.of(Ingredient.ofItems(material)),
                        new TransmuteRecipeResult(result)
                );
                AdvancementEntry armorAdvancement = exporter.getAdvancementBuilder()
                        .criterion(
                                "has_required_material",
                                conditionsFromItem(material)
                        )
                        .criterion(
                                "has_the_recipe",
                                RecipeUnlockedCriterion.create(armorRecipeKey)
                        )
                        .rewards(
                                AdvancementRewards.Builder.recipe(armorRecipeKey)
                        )
                        .criteriaMerger(
                                AdvancementRequirements.CriterionMerger.OR
                        )
                        .build(
                                Identifier.of(
                                        MOD_ID,
                                        "recipes/" + category + "/" + RecipeID
                                )
                        );
                recipeExporter.accept(armorRecipeKey, armorRecipe, armorAdvancement);
            }

            private void ArmorSetSmithingRecipe(
                    Boolean pf_required,
                    Item material,
                    Item helmet,
                    Item chestplate,
                    Item leggings,
                    Item boots,
                    @Nullable Item from_helmet,
                    @Nullable Item from_chestplate,
                    @Nullable Item from_leggings,
                    @Nullable Item from_boots
            ) {
                SmithingRecipeGenerator(
                        pf_required,
                        material,
                        Objects.requireNonNullElse(from_helmet, Items.CHAINMAIL_HELMET),
                        helmet,
                        "combat"
                );
                SmithingRecipeGenerator(
                        pf_required,
                        material,
                        Objects.requireNonNullElse(from_chestplate, Items.CHAINMAIL_CHESTPLATE),
                        chestplate,
                        "combat"
                );
                SmithingRecipeGenerator(
                        pf_required,
                        material,
                        Objects.requireNonNullElse(from_leggings, Items.CHAINMAIL_LEGGINGS),
                        leggings,
                        "combat"
                );
                SmithingRecipeGenerator(
                        pf_required,
                        material,
                        Objects.requireNonNullElse(from_boots, Items.CHAINMAIL_BOOTS),
                        boots,
                        "combat"
                );
            }

            @Override
            public void generate() {
                createShapeless(RecipeCategory.MISC, ItemRegister.DIAMOND_INGOT)
                        .input(Items.GOLD_INGOT, 4)
                        .input(Items.DIAMOND, 4)
                        .criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, Items.DIAMOND, 7)
                        .input(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, 1)
                        .criterion("has_netherite_template", conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                        .offerTo(exporter, "no_more_upgrade_template");

                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET)
                        .pattern("-#-")
                        .pattern("# #")
                        .input('#', Items.IRON_CHAIN)
                        .input('-', Items.IRON_NUGGET)
                        .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                        .pattern("# #")
                        .pattern("#-#")
                        .pattern("-#-")
                        .input('#', Items.IRON_CHAIN)
                        .input('-', Items.IRON_NUGGET)
                        .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                        .pattern("#-#")
                        .pattern("# #")
                        .pattern("- -")
                        .input('#', Items.IRON_CHAIN)
                        .input('-', Items.IRON_NUGGET)
                        .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                        .pattern("# #")
                        .pattern("- -")
                        .input('#', Items.IRON_CHAIN)
                        .input('-', Items.IRON_NUGGET)
                        .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ItemRegister.PLATE_FORGER, 2)
                        .pattern("=#=")
                        .pattern("=-=")
                        .pattern("===")
                        .input('#', ItemRegister.PLATE_FORGER)
                        .input('=', Items.COPPER_INGOT)
                        .input('-', Items.IRON_INGOT)
                        .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);

                ArmorSetSmithingRecipe(
                        false,
                        Items.COPPER_INGOT,
                        Items.COPPER_HELMET,
                        Items.COPPER_CHESTPLATE,
                        Items.COPPER_LEGGINGS,
                        Items.COPPER_BOOTS,
                        Items.LEATHER_HELMET,
                        Items.LEATHER_CHESTPLATE,
                        Items.LEATHER_LEGGINGS,
                        Items.LEATHER_BOOTS
                );
                ArmorSetSmithingRecipe(
                        true,
                        Items.IRON_INGOT,
                        Items.IRON_HELMET,
                        Items.IRON_CHESTPLATE,
                        Items.IRON_LEGGINGS,
                        Items.IRON_BOOTS,
                        null,
                        null,
                        null,
                        null
                );
                ArmorSetSmithingRecipe(
                        true,
                        Items.GOLD_INGOT,
                        Items.GOLDEN_HELMET,
                        Items.GOLDEN_CHESTPLATE,
                        Items.GOLDEN_LEGGINGS,
                        Items.GOLDEN_BOOTS,
                        Items.LEATHER_HELMET,
                        Items.LEATHER_CHESTPLATE,
                        Items.LEATHER_LEGGINGS,
                        Items.LEATHER_BOOTS
                );
                ArmorSetSmithingRecipe(
                        true,
                        ItemRegister.DIAMOND_INGOT,
                        Items.DIAMOND_HELMET,
                        Items.DIAMOND_CHESTPLATE,
                        Items.DIAMOND_LEGGINGS,
                        Items.DIAMOND_BOOTS,
                        Items.IRON_HELMET,
                        Items.IRON_CHESTPLATE,
                        Items.IRON_LEGGINGS,
                        Items.IRON_BOOTS
                );
            }
        };
    }


    @Override
    public String getName() {
        return "Some ReWaxed Recipes";
    }
}
