import model.*;
import ui.ConsoleUI;
import ui.View;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Presenter {
    ReadWritable fileHandler;
    FamilyTree<Human> familyTree;
    View view;
    void start() throws ParseException {
        fileHandler = new FileHandler(Config.pathDb);
        familyTree = (FamilyTree<Human>) fileHandler.read();
        view = new ConsoleUI();

        familyTree.add(new Human("Vasily", Gender.MALE,
                new SimpleDateFormat("yyyy").parse("1991")));
        familyTree.add(new Human("Mary", Gender.FEMALE,
                new SimpleDateFormat("yyyy").parse("1990")));
        familyTree.add(new Human("Christine", Gender.FEMALE,
                new SimpleDateFormat("yyyy").parse("2011"),
                familyTree.getByName("Vasily"), familyTree.getByName("Mary")));
        familyTree.add(new Human("Semen", Gender.MALE,
                new SimpleDateFormat("yyyy").parse("2010"),
                familyTree.getByName("Vasily"), familyTree.getByName("Mary")));
        fileHandler.write(familyTree);
        familyTree.sortByName();
        for (Human human : familyTree) {
            System.out.println(human.getInfo());
        }
        familyTree.sortByBirthDate();
        System.out.println(familyTree.getInfo());
    }
}
