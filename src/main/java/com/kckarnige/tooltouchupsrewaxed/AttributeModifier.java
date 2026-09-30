package com.kckarnige.tooltouchupsrewaxed;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import static com.kckarnige.tooltouchupsrewaxed.Tooltouchupsrewaxed.MOD_ID;

public class AttributeModifier {
    public static void initialize() {

        DefaultItemComponentEvents.MODIFY.register(context -> {
            addAttribute(
                    context,
                    Items.NETHERITE_HELMET,
                    AttributeModifierSlot.HEAD,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_helmet"),
                    -0.05,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.NETHERITE_CHESTPLATE,
                    AttributeModifierSlot.CHEST,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_chestplate"),
                    -0.05,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.NETHERITE_LEGGINGS,
                    AttributeModifierSlot.LEGS,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_leggings"),
                    -0.05,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.NETHERITE_BOOTS,
                    AttributeModifierSlot.FEET,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_boots"),
                    -0.05,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );

            addAttribute(
                    context,
                    Items.DIAMOND_HELMET,
                    AttributeModifierSlot.HEAD,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_helmet"),
                    -0.025,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.DIAMOND_CHESTPLATE,
                    AttributeModifierSlot.CHEST,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_chestplate"),
                    -0.025,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.DIAMOND_LEGGINGS,
                    AttributeModifierSlot.LEGS,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_leggings"),
                    -0.025,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.DIAMOND_BOOTS,
                    AttributeModifierSlot.FEET,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_boots"),
                    -0.025,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );

            addAttribute(
                    context,
                    Items.GOLDEN_HELMET,
                    AttributeModifierSlot.HEAD,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_helmet"),
                    0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.GOLDEN_CHESTPLATE,
                    AttributeModifierSlot.CHEST,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_chestplate"),
                    0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.GOLDEN_LEGGINGS,
                    AttributeModifierSlot.LEGS,
                    EntityAttributes.ARMOR,
                    Identifier.ofVanilla("armor.leggings"),
                    4,
                    EntityAttributeModifier.Operation.ADD_VALUE
            );
            addAttribute(
                    context,
                    Items.GOLDEN_LEGGINGS,
                    AttributeModifierSlot.LEGS,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_leggings"),
                    0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.GOLDEN_BOOTS,
                    AttributeModifierSlot.FEET,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_boots"),
                    0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );

            addAttribute(
                    context,
                    Items.IRON_HELMET,
                    AttributeModifierSlot.HEAD,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_helmet"),
                    -0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.IRON_CHESTPLATE,
                    AttributeModifierSlot.CHEST,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_chestplate"),
                    -0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.IRON_LEGGINGS,
                    AttributeModifierSlot.LEGS,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_leggings"),
                    -0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.IRON_BOOTS,
                    AttributeModifierSlot.FEET,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_boots"),
                    -0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );

            addAttribute(
                    context,
                    Items.COPPER_HELMET,
                    AttributeModifierSlot.HEAD,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_helmet"),
                    -0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.COPPER_CHESTPLATE,
                    AttributeModifierSlot.CHEST,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_chestplate"),
                    -0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.COPPER_LEGGINGS,
                    AttributeModifierSlot.LEGS,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_leggings"),
                    -0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.COPPER_BOOTS,
                    AttributeModifierSlot.FEET,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "armor_movement_speed_boots"),
                    -0.0125,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );

            addAttribute(
                    context,
                    Items.TURTLE_HELMET,
                    AttributeModifierSlot.HEAD,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "elytra_movement_speed_helmet"),
                    0.05,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );
            addAttribute(
                    context,
                    Items.ELYTRA,
                    AttributeModifierSlot.CHEST,
                    EntityAttributes.MOVEMENT_SPEED,
                    Identifier.of(MOD_ID, "elytra_movement_speed_chest"),
                    0.05,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            );



            context.modify(Items.GOLDEN_SWORD, builder ->
                    builder.add(
                            DataComponentTypes.ATTRIBUTE_MODIFIERS,
                            toolAttributes(6.0, 1.8)
                    )
            );
            context.modify(Items.GOLDEN_AXE, builder ->
                    builder.add(
                            DataComponentTypes.ATTRIBUTE_MODIFIERS,
                            toolAttributes(9.0, 1)
                    )
            );

            context.modify(Items.NETHERITE_SWORD, builder ->
                    builder.add(
                            DataComponentTypes.ATTRIBUTE_MODIFIERS,
                            toolAttributes(8.0, 1.4)
                    )
            );
            context.modify(Items.NETHERITE_AXE, builder ->
                    builder.add(
                            DataComponentTypes.ATTRIBUTE_MODIFIERS,
                            toolAttributes(10.0, 0.8)
                    )
            );
        });
    }
    private static AttributeModifiersComponent toolAttributes(
            double damage,
            double attackSpeed
    ) {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.ATTACK_DAMAGE,
                        new EntityAttributeModifier(
                                Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
                                damage - 1.0,
                                EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.ATTACK_SPEED,
                        new EntityAttributeModifier(
                                Item.BASE_ATTACK_SPEED_MODIFIER_ID,
                                attackSpeed - 4.0,
                                EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }
    private static void addAttribute(
            DefaultItemComponentEvents.ModifyContext context,
            Item item,
            AttributeModifierSlot slot,
            RegistryEntry<EntityAttribute> attribute,
            Identifier modifierId,
            double value,
            EntityAttributeModifier.Operation operation
    ) {
        context.modify(item, builder -> {

            AttributeModifiersComponent existing =
                    item.getComponents().getOrDefault(
                            DataComponentTypes.ATTRIBUTE_MODIFIERS,
                            AttributeModifiersComponent.DEFAULT
                    );

            AttributeModifiersComponent modified = existing.with(
                    attribute,
                    new EntityAttributeModifier(
                            modifierId,
                            value,
                            operation
                    ),
                    slot
            );

            builder.add(
                    DataComponentTypes.ATTRIBUTE_MODIFIERS,
                    modified
            );
        });
    }
}
