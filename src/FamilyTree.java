import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public static void searchFamily(Human human) {
        System.out.println("Name: " + human.getFullName());
        if (human.getFather() != null) {
            System.out.println("Father: " + human.getFather().getFullName());
        }
        if (human.getMother() != null) {
            System.out.println("Mother: " + human.getMother().getFullName());
        }
        List<Human> siblings = new ArrayList<>();

        if (human.getMother() != null) {
            siblings.addAll(human.getMother().getChildren());
        }
        siblings.remove(human); // удаляем текущего объекта из списка братьев и сестер
        if (!siblings.isEmpty()) {
            System.out.println("Siblings:");
            for (Human sibling : siblings) {
                System.out.println("- " + sibling.getFullName());
            }
        }
    }
}
