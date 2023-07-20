package family_tree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import family_tree.model.file_handler.FileHandler;
import family_tree.model.human_family.FamilyTree;
import family_tree.model.human_family.HumanItem;
import family_tree.model.humans.Gender;
import family_tree.model.humans.Human;

public class Main {

    private static List<?> allHumans;
    private FamilyTree familyTree;

    public static  void main(String[] args) throws SecurityException, IOException {
        FamilyTree familyTree = new FamilyTree<>();
        var allHumans = familyTree.getAllHumans();

        
        var maksim = new Human("Maksim", LocalDate.of(1984, 8, 11), Gender.MALE);
        var irina = new Human("Irina", LocalDate.of(1989, 4, 15), Gender.FEMALE);
        var nataly = new Human("Nataly", LocalDate.of(1985, 7, 15), Gender.FEMALE);
        var peter = new Human("Peter", LocalDate.of(2015, 12, 9), Gender.MALE);
        var diana = new Human("Diana", LocalDate.of(2008, 4, 16), Gender.FEMALE);
        var yuriy = new Human("Yuriy", LocalDate.of(1956, 12, 9), Gender.MALE);
        var kate = new Human("Kate", LocalDate.of(1956, 3, 20), Gender.FEMALE);
        var maria = new Human("Maria", LocalDate.of(1946, 8, 19), Gender.FEMALE);

        maria.addChild((HumanItem) yuriy);
        maksim.addParent((HumanItem)yuriy);
        maksim.addParent((HumanItem)kate);
        maksim.addChild((HumanItem)diana);
        maksim.addParent((HumanItem)kate);
        irina.addChild((HumanItem)diana);
        nataly.addParent((HumanItem)yuriy);
        nataly.addParent((HumanItem)kate);
        peter.addParent((HumanItem)nataly);
        diana.addParent((HumanItem)maksim);
        maria.setDeathDate(LocalDate.of(2008, 01, 30));

        familyTree.addHuman((HumanItem) maria);
        familyTree.addHuman((HumanItem)maksim);
        familyTree.addHuman((HumanItem)irina);
        familyTree.addHuman((HumanItem)nataly);
        familyTree.addHuman((HumanItem)peter);
        familyTree.addHuman((HumanItem)diana);
        familyTree.addHuman((HumanItem)kate);
        familyTree.addHuman((HumanItem)yuriy);

        FileHandler.saveToFile(familyTree, "family_tree\\people.txt");
        FamilyTree<?> loadedTree = FileHandler.loadFromFile("family_tree\\people.txt");
        
        
        List<?> humans = familyTree.getAllHumans();
        for (Object human : humans) {
            System.out.println(human);
        }

        System.out.println(familyTree.getHumansInfo());
        familyTree.sortByName();
        System.out.println(familyTree.getHumansInfo());
        familyTree.sortByYear();
        System.out.println(familyTree.getHumansInfo());
    }
}
