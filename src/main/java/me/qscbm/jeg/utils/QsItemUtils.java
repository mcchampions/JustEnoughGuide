package me.qscbm.jeg.utils;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.papermc.paper.persistence.PersistentDataContainerView;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class QsItemUtils {
    @Nullable
    public static SlimefunItem getByItem(@Nullable ItemStack item) {
        if (item != null && item.getType() != Material.AIR) {
            if (item instanceof SlimefunItemStack stack) {
                return getById(stack.getItemId());
            } else {
                PersistentDataContainerView c = item.getPersistentDataContainer();
                String itemID = c.get(Slimefun.getItemDataService().getKey(), PersistentDataType.STRING);
                if (itemID == null) {
                    return null;
                }
                return getById(itemID);
            }
        } else {
            return null;
        }
    }

    @Nullable
    public static SlimefunItem getById(@Nonnull String id) {
        return Slimefun.getRegistry().getSlimefunItemIds().get(id);
    }
}
