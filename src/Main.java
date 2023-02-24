import model.*;
import view.ConsoleUI;
import view.View;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args)  {
        View view = new ConsoleUI();
        Presenter presenter = new Presenter();
        presenter.loadFromFile("familydata");

        tree.add(new Human("Vasily", Gender.MALE, new SimpleDateFormat("yyyy").parse("1991")));
        tree.add(new Human("Mary", Gender.FEMALE, new SimpleDateFormat("yyyy").parse("1990")));
        tree.add(new Human("Christine", Gender.FEMALE, new SimpleDateFormat("yyyy").parse("2011"), tree.getByName("Vasily"), tree.getByName("Mary")));
        tree.add(new Human("Semen", Gender.MALE, new SimpleDateFormat("yyyy").parse("2010"), tree.getByName("Vasily"), tree.getByName("Mary")));
        fileHandler.write(tree);
        tree.sortByName();
        for (Human human : tree) {
            System.out.println(human.getInfo());
        }
        tree.sortByBirthDate();
        System.out.println(tree.getInfo());

    }
}
