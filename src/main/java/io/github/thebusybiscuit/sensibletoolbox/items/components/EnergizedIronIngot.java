package io.github.thebusybiscuit.sensibletoolbox.items.components;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Recipe;

import io.github.thebusybiscuit.sensibletoolbox.api.items.BaseSTBItem;

public class EnergizedIronIngot extends BaseSTBItem {

    public EnergizedIronIngot() {}

    public EnergizedIronIngot(ConfigurationSection conf) {

    }

    @Override
    public Material getMaterial() {
        return Material.IRON_INGOT;
    }

    @Override
    public String getItemName() {
        return "充能铁锭";
    }

    @Override
    public String[] getLore() {
        return new String[] { "闪耀着奇异的光芒..." };
    }

    @Override
    public Recipe getMainRecipe() {
        return null;
    }

}
