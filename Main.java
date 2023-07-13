package homeWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();

        Human andrey = new Human("Андрей", Gender.Male, LocalDate.of(1980, 12, 30), 43);
        tree.add(andrey);
        Human maria = new Human("Мария", Gender.Female, LocalDate.of(1985, 9, 15), 38);
        tree.add(maria);
        Human kristina = new Human("Кристина", Gender.Female, LocalDate.of(2008, 7, 5), 15);
        tree.add(kristina);
        Human nikita = new Human("Никита", Gender.Male, LocalDate.of(2011, 1, 25), 12);
        tree.add(nikita);

        System.out.println(tree);

        fileHandler.save(tree, "src/FamilyTree/tree.out");

    }

}
