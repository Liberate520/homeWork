package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human sergei = new Human("Sergei", "Petrov", Genders.Мужской,
                LocalDate.of(1989, 1, 1), LocalDate.of(2015, 12, 31));
        Human vaselisa = new Human("Vaselisa", "Petrova", Genders.Женский,
                LocalDate.of(1990, 1, 1));
        Human anna = new Human("Anna", "Petrova", Genders.Женский,
                LocalDate.of(1965, 1, 1));
        Human sofia = new Human("Sofia", "Legneva", Genders.Женский,
                LocalDate.of(2008, 2, 3));
        Human ivan = new Human("Ivan", "Petrov", Genders.Мужской,
                LocalDate.of(2013, 12, 3));
        FamilyTree familyPetrovi = new FamilyTree();
        familyPetrovi.setSpouse(sergei, vaselisa);
        familyPetrovi.setMother(sergei, anna);
        familyPetrovi.setMother(sofia, vaselisa);
        //TODO: Дописать метод setChildren;
        familyPetrovi.setFather(sofia, sergei);


        System.out.println(familyPetrovi);
        System.out.println(sergei);


    }
}
