package lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class homeTask01 {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();
        familyTree.add("Олег", "муж", null, null);
        familyTree.add("Маша", "жен", null, null);
        familyTree.add("Никита", "муж", null, null);
        familyTree.add("Оля", "жен", null, null);
        familyTree.add("Петя", "муж", null, null);
        familyTree.add("Света", "жен", null, null);
        familyTree.add("Леша", "муж", null, null);
        familyTree.add("Алла", "жен", null, null);

        List<Human> humans = familyTree.getHumans();

        /**
         * вывод всех людей из дерева
         */
        familyTree.printHumans(humans);
        System.out.println("--------------------------");
        /**
         * создание связей родители - ребенок
         */
        familyTree.setRelative(humans.get(0), humans.get(1), humans.get(2));
        familyTree.setRelative(humans.get(0), humans.get(1), humans.get(7));
        System.out.println("--------------------------");
        /**
         * вывод связей ребенок - родители
         */
        familyTree.getRelative(humans);
        System.out.println("--------------------------");
        /**
         * поиск по имени
         */
        System.out.println("Введите имя человека, которого хотите найти: ");
        Scanner iname = new Scanner(System.in, "Cp866");
        String Iname = iname.nextLine();
        String name = Iname.substring(0, 1).toUpperCase() + Iname.substring(1);
        System.out.println(familyTree.searchName(humans, name));
        System.out.println("--------------------------");

        /**
         * Вывод списка детей по имени
         */
        System.out.println("Введите имя человека, что бы увидеть список его детей: ");
        Scanner yname = new Scanner(System.in, "Cp866");
        String Yname = yname.nextLine();
        String parentName = Yname.substring(0, 1).toUpperCase() + Yname.substring(1);
        Human parent = (familyTree.searchName(humans, parentName));
        System.out.printf("Дети человека по имени %s:\n", parent.getName());
        ArrayList<Human> children = parent.getChildren();
        parent.printChildren(children);

    }

}
