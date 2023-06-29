package me.reklessmitch.mitchpets.entity;

import lombok.Setter;
import me.reklessmitch.mitchpets.colls.PPlayerColl;
import com.massivecraft.massivecore.store.SenderEntity;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Getter
public class PPlayer extends SenderEntity<PPlayer> {

    public static PPlayer get(Object oid) {
        return PPlayerColl.get().get(oid);
    }

    @Override
    public PPlayer load(@NotNull PPlayer that)
    {
        super.load(that);
        return this;
    }

    Set<Pet> pets = newPets();
    @Setter
    PetType activePet = PetType.FISHING;

    private Set<Pet> newPets() {
        return Set.of(new Pet(PetType.FISHING), new Pet(PetType.FARMING), new Pet(PetType.MINING), new Pet(PetType.COMBAT));
    }

    public Pet getPet(PetType type){
        return pets.stream().filter(pet -> pet.getType() == type).findFirst().orElse(null);
    }


}
