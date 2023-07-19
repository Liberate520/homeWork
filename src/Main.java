import model.FamilyTreeService;
import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.save.FileHandlerForFamilyTree;
import model.save.base.FileHandler;
import view.Console;
import view.View;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human zhenya = new Human("Евгений", Gender.Male, LocalDate.of(1985, 9, 1));
        Human anya = new Human("Анна", Gender.Female, LocalDate.of(1987, 7, 26));
        Human artem = new Human("Артем", Gender.Male, LocalDate.of(2013, 10, 11), zhenya, anya);
        Human styapa = new Human("Степан", Gender.Male, LocalDate.of(2015, 10, 19), zhenya, anya);

        tree.add(zhenya);
        tree.add(anya);
        tree.add(artem);
        tree.add(styapa);

        Human grandMother1 = new Human("Любовь", Gender.Female, LocalDate.of(1962, 6, 13));
        Human grandMother2 = new Human("Галина", Gender.Female, LocalDate.of(1968, 8, 29));

        grandMother1.addChild(zhenya);
        grandMother2.addChild(anya);

        tree.add(grandMother1);
        tree.add(grandMother2);

        Human grandFather1 = new Human("Юрий", Gender.Male, LocalDate.of(1962, 4, 24));
        Human grandFather2 = new Human("Руслан", Gender.Male, LocalDate.of(1968, 11, 25));

        grandFather1.addChild(zhenya);
        grandFather2.addChild(anya);

        tree.add(grandFather1);
        tree.add(grandFather2);

        System.out.println(tree);

        FamilyTreeService service = new FamilyTreeService(tree);
        service.setWritable(new FileHandlerForFamilyTree());
        service.save();

        View view = new Console();
        view.start();
    }
}
