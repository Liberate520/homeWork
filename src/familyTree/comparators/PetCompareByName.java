package familyTree.comparators;

import familyTree.PetIterator;
import human.Human;
import pet.Pet;

import java.util.Comparator;

public class PetCompareByName implements Comparator<Pet> {
    @Override
    public int compare(Pet o1, Pet o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
