package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human sergei = new Human("Sergei", "Petrov", Genders.Мужской,
                LocalDate.of(1990, 1, 1), LocalDate.of(2005, 12, 31));
        Human vaselisa = new Human("Vaselisa", "Petrova", Genders.Женский,
                LocalDate.of(1990, 1, 1));
        FamilyTree familyPetrovi = new FamilyTree();
        familyPetrovi.setSpouse(sergei, vaselisa);


       System.out.println(familyPetrovi);
        System.out.println(sergei);


    }
}
