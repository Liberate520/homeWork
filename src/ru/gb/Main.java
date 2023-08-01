package ru.gb;

import ru.gb.data.Gender;
import ru.gb.family_tree.FamilyTree;
import ru.gb.human.Human;
import ru.gb.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        LocalDate birthday1 = LocalDate.of(1970, 5, 20);
        Human Sergey = new Human("Sergey", birthday1, Gender.Male);
        LocalDate birthday4 = LocalDate.of(1972, 3, 18);
        Human Yulia = new Human("Yulia", birthday4, Gender.Female);

        LocalDate birthday2 = LocalDate.of(2015, 2, 15);
        Human Sasha = new Human("Sasha", birthday2, Gender.Female);
        LocalDate birthday3 = LocalDate.of(2012, 2, 15);
        Human Ivan = new Human("Ivan", birthday3, Gender.Male);
        LocalDate birthday5 = LocalDate.of(1996, 2, 12);
        Human Daniil = new Human("Daniil", birthday5, Gender.Male);

        familyTree.addHuman(Daniil);

        familyTree.setConnection(Sasha, Sergey);
        familyTree.setConnection(Sasha, Yulia);
        familyTree.setConnection(Ivan, Sergey);
        familyTree.setConnection(Ivan, Yulia);

        System.out.println(familyTree);

        /*
        FileHandler handler = new FileHandler();
        handler.save(familyTree);
        handler.load();
         */
    }
}
