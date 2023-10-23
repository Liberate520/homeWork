import home_work_class.FamilyTree;
import home_work_class.FileWriter;
import home_work_class.Gender;
import home_work_class.Human;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Первый мужской родитель древа", Gender.Male, LocalDate.of(1950, 1, 1));
        Human human2 = new Human("первый женский родитель древа", Gender.Female,
                LocalDate.of(1955, 1, 1),
                LocalDate.of(2020, 1,1));
        Human children1 = new Human("Первый ребёнок корневых родителей", Gender.Male,
                LocalDate.of(1970, 1, 1));
        Human children2 = new Human("Второй ребёнок корневых родителей", Gender.Female,
                LocalDate.of(1980, 1, 1));
        Human children3 = new Human("Третий ребёнок корневых родителей", Gender.Female,
                LocalDate.of(1990, 1, 1));
        List<Human> childrenList = new ArrayList<>();
        childrenList.add(children1);
        childrenList.add(children2);
        childrenList.add(children3);
        addChildren(human1, human2, childrenList);
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(children1);
        familyTree.addHuman(children2);
        familyTree.addHuman(children3);
        System.out.println(familyTree.showHumansList());

        System.out.println("Дети выбранного родителя (" + human1.getName() + "): ");
        System.out.println(human1.showChildren());

        FileWriter handler = new FileWriter();
        handler.write(familyTree);
        System.out.println("\nПроверка после записи и чтения\n");
        System.out.println(handler.read().showHumansList());
    }

    public static void addChildren(Human parens1, Human parens2, List<Human> childrenList){
        if (! parens1.getGender().equals(parens2.getGender())){
            for (Human children: childrenList) {
                parens1.addChildren(children);
                parens2.addChildren(children);
            }
        }
    }
}
