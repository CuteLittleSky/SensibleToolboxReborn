package io.github.thebusybiscuit.sensibletoolbox.blocks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Preconditions;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.material.Colorable;

import io.github.thebusybiscuit.sensibletoolbox.api.SensibleToolbox;
import io.github.thebusybiscuit.sensibletoolbox.api.items.BaseSTBBlock;
import io.github.thebusybiscuit.sensibletoolbox.utils.ColoredMaterial;

public class Elevator extends BaseSTBBlock implements Colorable {

    private DyeColor color;

    public Elevator() {
        color = DyeColor.WHITE;
    }

    public Elevator(ConfigurationSection conf) {
        super(conf);
        color = DyeColor.valueOf(conf.getString("color"));
    }

    @Override
    public YamlConfiguration freeze() {
        YamlConfiguration conf = super.freeze();
        conf.set("color", color.toString());
        return conf;
    }

    public DyeColor getColor() {
        return color;
    }

    public void setColor(DyeColor color) {
        this.color = color;
        update(true);
    }

    @Override
    public Material getMaterial() {
        return ColoredMaterial.TERRACOTTA.get(color.ordinal());
    }

    @Override
    public String getItemName() {
        return "电梯";
    }

    @Override
    public String[] getLore() {
        return new String[] { "在上方或下方放置电梯", "跳跃上楼", "潜行下楼" };
    }

    @Override
    public Recipe getMainRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(getKey(), toItemStack());
        recipe.shape("WWW", "WPW", "WWW");
        recipe.setIngredient('W', Material.WHITE_WOOL);
        recipe.setIngredient('P', Material.ENDER_PEARL);
        return recipe;
    }

    @Nullable
    public Elevator findOtherElevator(@Nonnull BlockFace direction) {
        Preconditions.checkArgument(direction == BlockFace.UP || direction == BlockFace.DOWN, "direction must be UP or DOWN");

        Block b = getLocation().getBlock();
        Elevator res = null;

        while (b.getY() > b.getWorld().getMinHeight() && b.getY() < b.getWorld().getMaxHeight()) {
            b = b.getRelative(direction);

            if (b.getType().isSolid()) {
                res = SensibleToolbox.getBlockAt(b.getLocation(), Elevator.class, false);
                break;
            }
        }

        return (res != null && res.getColor() == getColor()) ? res : null;
    }
}
