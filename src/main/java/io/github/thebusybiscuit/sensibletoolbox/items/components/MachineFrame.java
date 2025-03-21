package io.github.thebusybiscuit.sensibletoolbox.items.components;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

import io.github.thebusybiscuit.sensibletoolbox.api.items.BaseSTBItem;

public class MachineFrame extends BaseSTBItem {

    public MachineFrame() {}

    public MachineFrame(ConfigurationSection conf) {}

    @Override
    public Material getMaterial() {
        return Material.IRON_BLOCK;
    }

    @Override
    public String getItemName() {
        return "机器框架";
    }

    @Override
    public String[] getLore() {
        return new String[] { "各种机器的框架" };
    }

    @Override
    public Recipe getMainRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(getKey(), toItemStack());
        recipe.shape("IBI", "B B", "IBI");
        recipe.setIngredient('B', Material.IRON_BARS);
        recipe.setIngredient('I', Material.IRON_INGOT);
        return recipe;
    }

}
