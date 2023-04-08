package familyTree.comparators;

import human.Human;
import pet.Pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class PetCompareByBirthday implements Comparator<Pet> {
    @Override
    public int compare(Pet o1, Pet o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        return LocalDate.parse(o1.getDateBirth(), formatter).compareTo(LocalDate.parse(o2.getDateBirth(), formatter));
    }

}
