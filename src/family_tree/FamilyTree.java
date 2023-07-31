package family_tree;

import family_tree.comparators.ComparatorByAge;
import family_tree.comparators.ComporatorByGender;
import family_tree.human.Human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FamilyTree<E extends Subject<Human>> implements Serializable {
    private List<E> familyTree;

    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addHuman(E human) {
        familyTree.add(human);
    }

    public List<String> getParentName(E human) {
        List<String> parents = new ArrayList<>();
        if (human.getMother() != null) {
            parents.add("mother: " + human.getMother().getName());
        }
        if (human.getFather() != null) {
            parents.add("father: " + human.getFather().getName());
        }
        return parents;
    }

    public List<String> getChildName(E humanParent) {
        List<String> children = new ArrayList<>();
        for (E human : familyTree) {
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

    public List<String> getSiblingName(E humanSibling) {
        List<String> siblings = new ArrayList<>();
        for (E human : familyTree) {
            if (human.getMother() != null) {
                if (humanSibling.getMother().getName().equalsIgnoreCase(human.getMother().getName())
                        && !human.getName().equalsIgnoreCase(humanSibling.getName()) &&
                        !siblings.contains(human.getName())) {
                    siblings.add(human.getName());
                }
            }
            if (human.getFather() != null) {
                if (humanSibling.getFather().getName().equalsIgnoreCase(human.getFather().getName())
                        && !human.getName().equalsIgnoreCase(humanSibling.getName()) &&
                        !siblings.contains(human.getName())) {
                    siblings.add(human.getName());
                }
            }
        }
        return siblings;
    }

    public List<E> findHumanByName() {
        List<E> reqHumans = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String requiredHuman = scanner.nextLine();
        for (E human : familyTree) {
            if (requiredHuman.equalsIgnoreCase(human.getName())) {
                reqHumans.add(human);
            } 
        }
        return reqHumans;
    }

    public void sortByAge() {
        familyTree.sort(new ComparatorByAge());
    }

    public void sortByGender() {
        familyTree.sort(new ComporatorByGender());
    }

    public String printFamilyTree() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Семейное древо:");
        strBuilder.append("\n");
        for (E human : familyTree) {
            strBuilder.append(human);
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }
}