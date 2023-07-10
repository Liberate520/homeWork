package family_tree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.FileHandler;

import family_tree.file_handler.IFileHandler;
import family_tree.human_family.FamilyTree;
import family_tree.humans.Gender;
import family_tree.humans.Human;

public class Main {

    private static List<Human> allHumans;

    public static void main(String[] args) throws SecurityException, IOException {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        Human maksim = new Human("Maksim", LocalDate.of(1984, 8, 11), Gender.MALE);
        Human irina = new Human("Irina", LocalDate.of(1989, 4, 15), Gender.FEMALE);
        Human nataly = new Human("Nataly", LocalDate.of(1985, 7, 15), Gender.FEMALE);
        Human peter = new Human("Peter", LocalDate.of(2015, 12, 9), Gender.MALE);
        Human diana = new Human("Diana", LocalDate.of(2008, 4, 16), Gender.FEMALE);
        Human yuriy = new Human("Yuriy", LocalDate.of(1956, 12, 9), Gender.MALE);
        Human kate = new Human("Kate", LocalDate.of(1956, 3, 20), Gender.FEMALE);
        Human maria = new Human("Maria", LocalDate.of(1946, 8, 19), Gender.FEMALE);

        maria.addChild(yuriy);
        maksim.addParent(yuriy);
        maksim.addParent(kate);
        maksim.addChild(diana);
        maksim.addParent(kate);
        irina.addChild(diana);
        nataly.addParent(yuriy);
        nataly.addParent(kate);
        peter.addParent(nataly);
        diana.addParent(maksim);
        maria.setDeathDate(LocalDate.of(2008, 01, 30));

        familyTree.addHuman(maria);
        familyTree.addHuman(maksim);
        familyTree.addHuman(irina);
        familyTree.addHuman(nataly);
        familyTree.addHuman(peter);
        familyTree.addHuman(diana);
        familyTree.addHuman(kate);
        familyTree.addHuman(yuriy);

        

        IFileHandler fileHandler = (IFileHandler) new FileHandler();
        fileHandler.writeToFile(allHumans, "family_tree\\people.txt");

        List<Human> readPeople = fileHandler.readFromFile("family_tree\\people.txt");
        for (Human person : readPeople) {
            System.out.println(person.getName());
        }

        List<Human> allHumans = familyTree.getAllHumans();
        for (Human human : allHumans) {
            System.out.println(human);
        }

        System.out.println(familyTree.getHumanInfo());
        familyTree.sortByName();
        System.out.println(familyTree.getHumanInfo());
        familyTree.sortByYear();
        System.out.println(familyTree.getHumanInfo());
    }
}
