package tree;

import human.Gender;
import human.Human;

import java.time.LocalDate;

public class FamilyTrees {

    private final FamilyTree<Human> familyTree = new FamilyTree<>();

    public void addHuman(String firstName, String lastname, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        familyTree.add(new Human(firstName, lastname, gender, birthDate, deathDate, father, mother));
    }

    public void addHuman(String firstName, String lastname, Gender gender, LocalDate birthDate) {
        familyTree.add(new Human(firstName, lastname, gender, birthDate));
    }

    public FamilyTree<Human> tree1 () {
            addHuman("Василий", "Иванов", Gender.Male, LocalDate.of(1991, 12, 25));
            addHuman("Кристина", "Иванова", Gender.Female, LocalDate.of(1988, 1, 2));
            addHuman("Ольга", "Иванова",Gender.Female, LocalDate.of(1988, 1, 2),null, familyTree.getByFirstName("Василий"),familyTree.getByFirstName("Кристина"));
            addHuman("Иван", "Иванов",Gender.Male, LocalDate.of(1988, 5, 6),null, familyTree.getByFirstName("Василий"),familyTree.getByFirstName("Кристина"));
            addHuman("Сергей", "Иванов",Gender.Male, LocalDate.of(1989, 4, 9),null, familyTree.getByFirstName("Василий"),familyTree.getByFirstName("Кристина"));
            addHuman("Игорь", "Сергеев", Gender.Male, LocalDate.of(1978, 5, 20));
            addHuman("Ирина", "Сергеева", Gender.Female, LocalDate.of(1977, 9, 7));
            return familyTree;
        }
}
