import home_work_class.FamilyTree;
import home_work_class.Gender;
import home_work_class.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Первый мужской родитель древа", Gender.Male, null);
        Human human2 = new Human("первый женский родитель древа", Gender.Female, null);
        Human children1 = new Human("Первый ребёнок корневых родителей", Gender.Male, null);
        Human children2 = new Human("Второй ребёнок корневых родителей", Gender.Female, null);
        Human children3 = new Human("Третий ребёнок корневых родителей", Gender.Female, null);
        List<Human> childrenList = new ArrayList<>();
        childrenList.add(children1);
        childrenList.add(children2);
        childrenList.add(children3);
        addChildren(human1, human2, childrenList);
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(children1);
        familyTree.addHuman(children2);
        System.out.println(familyTree.showHumansList());

        System.out.println("Дети выбранного родителя: ");
        System.out.println(human1.showChildren());
    }

    public static void addChildren(Human parens1, Human parens2, List<Human> childrenList){
        for (Human children: childrenList) {
            parens1.addChildren(children);
            parens2.addChildren(children);
        }

    }
}
