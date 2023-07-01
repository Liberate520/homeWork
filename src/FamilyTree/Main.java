package FamilyTree;


import FamilyTree.model.Service;
import FamilyTree.model.fileHandler.FileHandler;
import FamilyTree.model.fileHandler.SaveLoader;
import FamilyTree.model.person.Gender;
import FamilyTree.model.person.Person;
import FamilyTree.model.pet.Pet;
import FamilyTree.model.tree.FamilyTree;
import FamilyTree.presenter.Presenter;
import FamilyTree.view.ConsoleUI;
import FamilyTree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Service familyTree = new Service();
        familyTree.addPerson(new Person("Петрова Ольга Владимировна", Gender.female, LocalDate.of(1941, 6, 24), null, null));
        familyTree.addPerson(new Person("Иванов Иван Иванович", Gender.male, LocalDate.of(1935, 12, 14), null, null));
        familyTree.addPerson(new Person("Иванова Кристина Ивановна", Gender.female, LocalDate.of(1961, 5, 15),
                familyTree.getByName("Петрова Ольга Владимировна"),
                familyTree.getByName("Иванов Иван Иванович")));
        familyTree.addPerson(new Person("Митрофанов Дмитрий Васильевич", Gender.male, LocalDate.of(1963, 9, 1), null, null));
        familyTree.addPerson(new Person("Митрофанов Константин Дмитриевич", Gender.male, LocalDate.of(1981, 8, 25),
                familyTree.getByName("Иванова Кристина Ивановна"),
                familyTree.getByName("Митрофанов Дмитрий Васильевич")));

//        String path = "src/FamilyTree/model/file.txt";
//        familyTree.saveTree(path);
//        familyTree.loadTree(path);
//        System.out.println(familyTree.getFamilyTreeInfo());
//
//        familyTree.sortByName();
//        System.out.println(familyTree.getFamilyTreeInfo());
//
//        familyTree.sortByAge();
//        System.out.println(familyTree.getFamilyTreeInfo());

        FamilyTree<Pet> petTree = new FamilyTree<>();
        petTree.addPerson(new Pet("Маря", LocalDate.of(2018, 5, 20)));
        petTree.addPerson(new Pet("Джей", LocalDate.of(2016, 8, 15)));
        String path2 = "src/FamilyTree/model/pets.txt";
        SaveLoader fileHandler = new FileHandler();
        fileHandler.save(petTree, path2);
        fileHandler.load(path2);
        System.out.println(petTree.getFamilyTreeInfo());


        View familyTreeUI = new ConsoleUI();
        Presenter presenter = new Presenter(familyTreeUI, familyTree);
        familyTreeUI.start();
    }
}
