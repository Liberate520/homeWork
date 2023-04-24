package model.main;

import model.FamilyService;
import model.file.FileUtil;
import model.tree.FamilyTree;
import model.tree.Human;
import presenter.Presenter;
import ui.View;
import ui.Console;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Human human1 = new Human("Иван", Human.Gender.male,
                LocalDate.of(1865, 11, 25),
                LocalDate.of(2017, 7, 3), null, null, null);
        Human human2 = new Human("Галина", Human.Gender.female,
                LocalDate.of(1869, 10, 15), null, null, null, null);
        Human human3 = new Human("Павел", Human.Gender.male,
                LocalDate.of(1989, 9, 18), null, null, null, null);
        Human human4 = new Human("Алеся", Human.Gender.female,
                LocalDate.of(1995, 7, 5), null, null, null, null);
        Human human5 = new Human("Дарья", Human.Gender.female,
                LocalDate.of(1990, 6, 29), null, null, null, null);
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);

        FamilyService service = new FamilyService(familyTree);
        service.setWritable(new FileUtil());
        service.save();
        service.read();
        View view = new Console();
        new Presenter(service, view);
        view.run();
    }
}
