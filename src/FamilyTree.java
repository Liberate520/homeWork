
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamilyTree {
    private List<Human> familyTree = new ArrayList<>();

    public void addFamily(Human human) {
        familyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChildren(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChildren(human);
        }
    }

    public void findHuman() {
        System.out.printf("Введите имя для поиска: ");
        Scanner scn = new Scanner(System.in, "cp866");
        String findName = scn.nextLine();
        scn.close();

        boolean find = false;
        for (int i = 0; i < familyTree.size(); i++) {
            if (familyTree.get(i).getName().contains(findName)) {
                System.out.println(familyTree.get(i));
                find = true;
            }
        }
        if (!find)
            System.out.println("Такой человек не найден.");
    }

    @Override
    public String toString() {
        return familyTree.toString();
    }
}
