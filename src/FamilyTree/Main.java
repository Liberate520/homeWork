package FamilyTree;


import FamilyTree.person.Person;
import FamilyTree.person.Gender;
import FamilyTree.pet.Pet;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Service<Person> familyTree = new Service<Person>();
        familyTree.add(new Person("Петрова Ольга Владимировна", Gender.male, LocalDate.of(1941, 6, 24)));
        familyTree.add(new Person("Иванов Иван Иванович", Gender.male, LocalDate.of(1935, 12, 14)));
        familyTree.add(new Person("Иванова Кристина Ивановна", Gender.male, LocalDate.of(1961, 5, 15),
                familyTree.getByName("Петрова Ольга Владимировна"),
                familyTree.getByName("Иванов Иван Иванович")));
        familyTree.add(new Person("Митрофанов Дмитрий Васильевич", Gender.male, LocalDate.of(1963, 9, 1)));
        familyTree.add(new Person("Митрофанов Константин Дмитриевич", Gender.male, LocalDate.of(1981, 8, 25),
                familyTree.getByName("Иванова Кристина Ивановна"),
                familyTree.getByName("Митрофанов Дмитрий Васильевич")));

        String path = "src/FamilyTree/file.txt";
        familyTree.saveTree(path);
        familyTree.loadTree(path);
        System.out.println(familyTree.getFamilyTreeInfo());

        familyTree.sortByName();
        System.out.println(familyTree.getFamilyTreeInfo());

        familyTree.sortByAge();
        System.out.println(familyTree.getFamilyTreeInfo());

        Service<Pet> petTree = new Service<Pet>();
        petTree.add(new Pet("Маря"));
        petTree.add(new Pet("Джей"));

        String path2 = "src/FamilyTree/pets.txt";
        petTree.saveTree(path2);
        petTree.loadTree(path2);
        System.out.println(petTree.getFamilyTreeInfo());













    }
}
