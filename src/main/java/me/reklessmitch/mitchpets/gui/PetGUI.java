package me.reklessmitch.mitchpets.gui;

import me.reklessmitch.mitchpets.colls.PPlayerColl;
import com.massivecraft.massivecore.chestgui.ChestGui;
import me.reklessmitch.mitchpets.entity.PPlayer;
import me.reklessmitch.mitchpets.entity.Pet;
import me.reklessmitch.mitchpets.MitchPets;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.massivecraft.massivecore.util.IdUtil.getPlayer;

public class PetGUI extends ChestGui implements Listener {

    PPlayer player;
    Map<Integer, Pet> pets = new HashMap<>();
    Inventory inventory;

    public PetGUI(UUID pID){
        this.player = PPlayerColl.get().get(pID);
        inventory = Bukkit.createInventory(null, 18, "Pets");
        player.getPets().forEach(pet -> pets.put(pets.size(), pet));
        setUpInventory();
        MitchPets.get().getServer().getPluginManager().registerEvents(this, MitchPets.get());
    }

    private void setUpInventory() {
        pets.forEach((slot, pet) -> inventory.setItem(slot, pet.getDisplayItem(player)));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getInventory() != inventory) return;
        event.setCancelled(true);
        Pet pet = pets.get(event.getSlot());
        if(pet == null) return;
        PPlayer.get(player).setActivePet(pet.getType());
        event.getWhoClicked().sendMessage("You have selected the " + pet.getType().name() + " pet.");
        setUpInventory();
    }

    public void open() {
        getPlayer(player).openInventory(inventory);
    }
}
