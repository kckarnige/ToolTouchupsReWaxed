package com.kckarnige.tooltouchupsrewaxed;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tooltouchupsrewaxed implements ModInitializer {

    public static final String MOD_ID = "tooltouchupsrewaxed";
    public static final Logger LOGGER = LoggerFactory.getLogger("Tool Touch-Ups: ReWaxed");

    @Override
    public void onInitialize() {
        ItemRegister.registerModItems();
    }
}
