package me.reklessmitch.mitchpets.entity;

import com.massivecraft.massivecore.util.ItemBuilder;
import lombok.Getter;
import me.reklessmitch.mitchpets.util.DisplayItem;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Pet {

    PetType type;
    int level;
    int xp;

    public Pet(PetType type) {
        this.type = type;
        this.level = 1;
        this.xp = 0;
    }

    public void addLevel(int level) {
        this.level += level;
    }

    public void addXp(int xp) {
        this.xp += xp;
    }

    public void removeLevel(int level) {
        this.level -= level;
    }

    public void removeXp(int xp) {
        this.xp -= xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public ItemStack getDisplayItem(PPlayer player) {
        DisplayItem displayItem = MConf.get().getPetDisplayItems().get(type);
        ItemStack item = new ItemStack(displayItem.getMaterial());
        List<String> lore = new ArrayList<>(displayItem.getItemLore());
        lore.add("§7Level: " + level);
        lore.add("§7Xp: " + xp);
        if(player.activePet == this.getType()) {
            lore.add("§a");
            lore.add("§aActive");
        }
        item.setLore(lore);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(displayItem.getCustomModelData());
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(displayItem.getItemName());
        item.setItemMeta(meta);
        return item;
    }

    public double getPetBooster(){
        return MConf.get().getPetBoosts().get(type).getBoost(level);
    }

    public void spawn(){

    }
}
