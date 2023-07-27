import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FamilyTree {
    private List<Human> familyTree;

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addHuman(Human human) {
        familyTree.add(human);
    }

    public List<String> getParentName(Human human) {
        List<String> parents = new ArrayList<>();
        if (human.getMother() != null) {
            parents.add("mother: " + human.getMother().getName());
        }
        if (human.getFather() != null) {
            parents.add("father: " + human.getFather().getName());
        }
        return parents;
    }

    public List<String> getChildName(Human humanParent) {
        List<String> children = new ArrayList<>();
        for (Human human : familyTree) {
            if (human.getMother() != null) {
                if (humanParent.getName().equalsIgnoreCase(human.getMother().getName())) {
                    children.add(human.getName());
                }
            }
            if (human.getFather() != null) {
                if (humanParent.getName().equalsIgnoreCase(human.getFather().getName())) {
                    children.add(human.getName());
                }
            }
        }
        return children;
    }

    public List<String> getSiblingName(Human humanSibling) {
        List<String> siblings = new ArrayList<>();
        for (Human human : familyTree) {
            if (human.getMother() != null) {
                if (humanSibling.getMother().getName().equalsIgnoreCase(human.getMother().getName()) && !human.getName().equalsIgnoreCase(humanSibling.getName()) &&
                    !siblings.contains(human.getName())) {
                    siblings.add(human.getName());
                }
            }
            if (human.getFather() != null) {
                if (humanSibling.getFather().getName().equalsIgnoreCase(human.getFather().getName()) && !human.getName().equalsIgnoreCase(humanSibling.getName()) &&
                    !siblings.contains(human.getName())) {
                    siblings.add(human.getName());
                }
            }
        }
        return siblings;
    }

    public List<Human> findHumanByName() {
        List<Human> reqHumans = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Введите действие:\n" +
                    "1 - Найти человека\n" +
                    "2 - Завершить\n");
            String act = scanner.nextLine();
            if (act.equals("1")) {
                System.out.println("Введите имя");
                String requiredHuman = scanner.nextLine();
                for (Human human : familyTree) {
                    if (requiredHuman.equalsIgnoreCase(human.getName())) {
                        reqHumans.add(human);
                    }
                }
            } else if (act.equals("2")) {
                flag = false;
            }
        }
        return reqHumans;
    }

    public String printFamilyTree() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Семейное древо:");
        strBuilder.append("\n");
        for (Human human : familyTree) {
            strBuilder.append(human);
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }

}