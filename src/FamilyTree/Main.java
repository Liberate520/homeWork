package FamilyTree;


import FamilyTree.fileHandler.FileHandler;
import FamilyTree.fileHandler.SaveLoader;
import FamilyTree.tree.FamilyTree;
import FamilyTree.person.Person;
import FamilyTree.person.Gender;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        SaveLoader saveLoader = new FileHandler();

        FamilyTree<Person> tree = new FamilyTree<>();

        tree.add(new Person("Петрова Ольга Владимировна", Gender.male, LocalDate.of(1941, 6, 24)));
        tree.add(new Person("Иванов Иван Иванович", Gender.male, LocalDate.of(1935, 12, 14)));
        tree.add(new Person("Иванова Кристина Ивановна", Gender.male, LocalDate.of(1961, 5, 15),
                tree.getByName("Петрова Ольга Владимировна"),
                tree.getByName("Иванов Иван Иванович")));
        tree.add(new Person("Митрофанов Дмитрий Васильевич", Gender.male, LocalDate.of(1963, 9, 1)));
        tree.add(new Person("Митрофанов Константин Дмитриевич", Gender.male, LocalDate.of(1981, 8, 25),
                tree.getByName("Иванова Кристина Ивановна"),
                tree.getByName("Митрофанов Дмитрий Васильевич")));

        System.out.println(tree.getFamilyTree());

        String path = "src/FamilyTree/file.txt";
        saveLoader.save(tree, path);
        FamilyTree treeLoad = (FamilyTree) saveLoader.load(path);
        System.out.println(treeLoad.getFamilyTree());

        FamilyTree<Pet> pets = new FamilyTree<>();
        pets.add(new Pet("Барбос"));
        pets.add(new Pet("Бобик"));
        System.out.println(pets.getFamilyTree());

        String path1 = "src/FamilyTree/pets.txt";
        saveLoader.save(pets, path1);
        FamilyTree<Pet> petsLoad = (FamilyTree) saveLoader.load(path1);
        System.out.println(petsLoad.getFamilyTree());


    }
}
