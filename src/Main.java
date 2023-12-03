import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.Write.FileWriter;
import Model.home_work_class.Human.Gender;
import Model.home_work_class.Human.Human;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Human human1 = new Human("Юрий", Gender.Male,
                LocalDate.of(1950, 1, 1),
                LocalDate.of(2020, 1,1));
        Human human2 = new Human("Елена", Gender.Female, LocalDate.of(1955, 1, 1));
        Human children1 = new Human("Алексей", Gender.Male, LocalDate.of(1980, 1, 1));
        Human children2 = new Human("Михаил", Gender.Male, LocalDate.of(1985, 1, 1));
        Human children3 = new Human("Мария", Gender.Female, LocalDate.of(1990, 1, 1));
        List<Human> childrenList = new ArrayList<>();
        childrenList.add(children1);
        childrenList.add(children2);
        childrenList.add(children3);
        human1.addChildren(childrenList);
        human2.addChildren(childrenList);
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(children1);
        familyTree.addHuman(children2);
        familyTree.addHuman(children3);
        System.out.println(familyTree.showHumansList());

        System.out.println("Дети выбранного родителя (" + human1.getName() + "): ");
        System.out.println(human1.showChildren());

        System.out.println("\nПоиск в дереве по имени Алексей: ");
        System.out.println(familyTree.findHumanByName("Алексей").toString());

        FileWriter handler = new FileWriter();
        handler.write(familyTree);
        System.out.println("\nПроверка после записи и чтения\n");
        System.out.println(handler.read().showHumansList());

        System.out.println("дерево после сортировки по имени \n");
        familyTree.sortByName();
        System.out.println(familyTree.showHumansList());
        System.out.println("сортировка по возрасту \n");
        familyTree.sortByAge();
        System.out.println(familyTree.showHumansList());

    }
}
