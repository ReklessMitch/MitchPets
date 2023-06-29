package me.reklessmitch.mitchpets.entity;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;
import lombok.Getter;
import me.reklessmitch.mitchpets.util.PetBoost;
import org.bukkit.Material;
import me.reklessmitch.mitchpets.util.DisplayItem;

import java.util.List;
import java.util.Map;

@Getter
@EditorName("config")
public class MConf extends Entity<MConf> {
    public static MConf i;
    public static MConf get() { return i; }

    Map<PetType, PetBoost> petBoosts = Map.of(
            PetType.FISHING, new PetBoost(1.1, 0.1),
            PetType.FARMING, new PetBoost(1.1, 0.1),
            PetType.COMBAT, new PetBoost(1.1, 0.1),
            PetType.MINING, new PetBoost(1.1, 0.1));


    Map<PetType, DisplayItem> petDisplayItems = Map.of(
            PetType.FISHING, new DisplayItem(Material.SKELETON_SKULL, "§bFishing Pet",
                    List.of("§7Increases fishing xp"), 0),
            PetType.FARMING, new DisplayItem(Material.CREEPER_HEAD, "§bFarming Pet",
                    List.of("§7Increases farming xp"), 0),
            PetType.COMBAT, new DisplayItem(Material.WITHER_SKELETON_SKULL, "§bCombat Pet",
                    List.of("§7Increases combat xp"), 0),
            PetType.MINING, new DisplayItem(Material.ZOMBIE_HEAD, "§bMining Pet",
                    List.of("§7Increases mining xp"), 0));
}
