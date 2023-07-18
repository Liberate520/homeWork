import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создаем несколько объектов Human
        Human father = new Human("Oleg", "Ivanov", LocalDate.of(1970, 5, 10), Gender.MALE);
        Human mother = new Human("Olga", "Ivanova", LocalDate.of(1975, 8, 15), Gender.FEMALE);
        Human child1 = new Human("Elena", "Ivanova", LocalDate.of(1995, 3, 20), Gender.FEMALE);
        Human child2 = new Human("Artem", "Ivanov", LocalDate.of(1998, 7, 5), Gender.MALE);

        // Устанавливаем отцов и матерей
        child1.setFather(father);
        child1.setMother(mother);
        child2.setFather(father);
        child2.setMother(mother);

        // Создаем FamilyTree и добавляем людей
        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(father);
        familyTree.addHuman(mother);
        familyTree.addHuman(child1);
        familyTree.addHuman(child2);

        // Проверяем отношения
        System.out.println("Father: " + child1.getFather());
        System.out.println("Mother: " + child1.getMother());

        // Используем методы getChildrenOfFather и getChildrenOfMother
        List<Human> childrenOfFather = familyTree.getChildrenOfFather(father);
        List<Human> childrenOfMother = familyTree.getChildrenOfMother(mother);

        System.out.println("Children of Father:");
        for (Human child : childrenOfFather) {
            System.out.println(child);
        }

        System.out.println("Children of Mother:");
        for (Human child : childrenOfMother) {
            System.out.println(child);
        }
    }
}



