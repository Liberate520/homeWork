import human.Gender;
import human.Human;
import presenter.Presenter;
import serializer.TreeSerializer;
import tree.FamilyTree;
import tree.Service;
import ui.Console;
import ui.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree<Human> familyTree = new FamilyTree<>();
        View view = new Console();
        Service service = new Service(familyTree);
        service.addHuman("Василий", "Иванов", Gender.Male, LocalDate.of(1991, 12, 25));
        service.addHuman("Кристина", "Иванова", Gender.Female, LocalDate.of(1988, 1, 2));
        service.addHuman("Ольга", "Иванова",Gender.Female, LocalDate.of(1988, 1, 2));
        service.addHuman("Иван", "Иванов",Gender.Male, LocalDate.of(1988, 5, 6));
        service.addHuman("Сергей", "Иванов",Gender.Male, LocalDate.of(1989, 4, 9));

        service.sortByFirstName();
        //service.sortByAge();

        service.setWritable(new TreeSerializer());

        new Presenter(view, service);
        view.start();
    }
}
