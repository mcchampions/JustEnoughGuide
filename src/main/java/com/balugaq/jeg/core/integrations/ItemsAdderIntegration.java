package com.balugaq.jeg.core.integrations;

import com.balugaq.jeg.core.integrations.slimehud.JEGPlayerWAILA;
import dev.lone.itemsadder.api.CustomBlock;
import org.bukkit.block.Block;

public class ItemsAdderIntegration implements Integration {
    @Override
    public String getHookPlugin() {
        return "ItemsAdder";
    }

    @Override
    public void onEnable() {
        JEGPlayerWAILA.enableItemsAdder = true;
    }
    @Override
    public void onDisable() {
        JEGPlayerWAILA.enableItemsAdder = false;
    }

    public static boolean isItemsAdder(Block block) {
        return CustomBlock.byAlreadyPlaced(block) != null;
    }

    public static String getDisplayName(Block block) {
        return CustomBlock.byAlreadyPlaced(block).getDisplayName();
    }
}
