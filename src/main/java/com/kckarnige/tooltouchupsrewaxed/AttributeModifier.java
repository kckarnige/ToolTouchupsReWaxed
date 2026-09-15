package com.kckarnige.tooltouchupsrewaxed;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class AttributeModifier {
    public static void initialize() {
        DefaultItemComponentEvents.MODIFY.register(context -> {
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
}
