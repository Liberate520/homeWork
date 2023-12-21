import model.FamilyTreeService;
import model.human.Gender;
import model.human.Human;
import model.familyTree.FamilyTree;

import model.writer.FileHandlerForFamilyTree;
import view.Console;
import view.View;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5),
                vasya, masha);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25),
                vasya, masha);

        tree.add(vasya);
        tree.add(masha);
        tree.add(christina);
        tree.add(semyon);

        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(vasya);

        tree.add(grandMother);

        System.out.println(tree);

        FamilyTreeService service = new FamilyTreeService(tree);
        service.setWritable(new FileHandlerForFamilyTree());
        service.save();

        View view = new Console();
        view.start();
    }
}