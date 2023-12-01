package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable {
    private List<T> familyTree;

    {
       familyTree = new ArrayList<>();
    }

    public Human getTop() {
        Service service = new Service();
        topOfTree(familyTree.getFirst());
        return service.getTreeTop();
    }

    //TODO: INTERFACE описать методы set, get
    public boolean setSpouse(T firstSpouce, T secondSpouce) {
        if (firstSpouce.getSpouse() == null && secondSpouce.getSpouse() == null) {
            firstSpouce.setSpouse(secondSpouce);
            secondSpouce.setSpouse(firstSpouce);
        } else {
            System.out.println(firstSpouce.getName() + " или " + secondSpouce.getName() + " уже имеют супруга, пожалуйста" +
                    "проставьте корректные статусы");
            return false;
        }
        if (!firstSpouce.inTree) {
            familyTree.add(firstSpouce);
            firstSpouce.inTree = true;
        }
        if (!secondSpouce.inTree) {
            familyTree.add(secondSpouce);
            secondSpouce.inTree = true;
        }
        System.out.println("Вы указали, что: " + firstSpouce.getName() + " и " + secondSpouce.getName() + " женаты");
        return true;
    }

    public boolean divorce(T firstSpouce, T secondSpouce) {
        if (firstSpouce.equals(secondSpouce.getSpouse())) {
            firstSpouce.setSpouse(null);
            secondSpouce.setSpouse(null);
            System.out.println(firstSpouce.getName() + " и " + secondSpouce.getName() + "более не женаты");
        } else {
            System.out.println(firstSpouce.getName() + " или " + secondSpouce.getName() + "не имеют супруга, пожалуйста" +
                    "проставьте корректные статусы");
        }
        return true;
    }

    public boolean setMother(T child, T mother) {
        child.setMother(mother);
        if (!child.inTree) {
            familyTree.add(child);
            child.inTree = true;
        }
        if (!mother.inTree) {
            familyTree.add(mother);
            mother.inTree = true;
        }
        if (mother.getChildren() != null && mother.getChildren().contains(child)) {
            System.out.println("Такой ребенок уже задан");
            return false;
        } else {
            mother.setChildren(child);
            System.out.println("Вы указали, что: " + mother.getName() + " мать " + child.getName());
        }
        return true;
    }

    public boolean setChildren(T parent, T children) {
        if (!children.inTree) {
            familyTree.add(children);
            children.inTree = true;
        }
        if (!parent.inTree) {
            familyTree.add(parent);
            parent.inTree = true;
        }
        if (parent.getChildren() != null && parent.getChildren().contains(children)) {
            System.out.println("Такой ребенок уже задан");
            return false;
        } else {
            parent.setChildren(children);
            System.out.println("Вы указали, что: " + children.getName() +
                    " является ребенком " + parent.getName());
        }
        return true;
    }

    public boolean setFather(T child, T father) {
        child.setFather(father);
        if (!child.isInTree()) {
            familyTree.add(child);
            child.inTree = true;
        }
        if (!father.inTree) {
            familyTree.add(father);
            father.inTree = true;
        }
        if (father.getChildren() != null && father.getChildren().contains(child)) {
            System.out.println("Такой ребенок уже задан");
            return false;
        } else {
            father.setChildren(child);
            System.out.println("Вы указали, что: " + father.getName() + " отец " + child.getName());
        }
        return true;
    }


    @Override
    public String toString() {


        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Члены данной семьи: \n");
        for (Human human : familyTree) {
            sb.append(human.getName()).append("\n");
        }
        return sb.toString();
    }

    //TODO: Дописать метод, который рекурсивно собирает дерево семьи
    public String showTree(){
        Service service = new Service();
        topOfTree(familyTree.getFirst());
        return showTreeService(service.getTreeTop());
    }

    private String showTreeService(Human top) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (top != null) {
            sb.append(String.format("1. Старший член семейства: %s, %s г. р.", top.getName(), top.getBirthDate()));
            if (top.getSpouse() != null) {
                sb.append(String.format("Супруг старшего члена семейства: %s", top.getSpouse().getName()));
            }
            sb.append("Дети старшего члена семейства: ");
            for (Human child : top.getChildren()) {
                if (flag) sb.append(", ");
                sb.append(child.getName());
                flag = true;
            }
        }
        return sb.toString();
    }

    private boolean topOfTree(Human topEnter) {
        Service service = new Service();
        if (topEnter != null && topEnter.getFather() == null && topEnter.getMother() == null) {
            if (topEnter.getSpouse() != null) {
                if (topEnter.getSpouse().getFather() != null || topEnter.getSpouse().getMother() != null) {
                    topOfTree(topEnter.getSpouse());
                }
            } else {
                service.setTreeTop(topEnter);
            }
        }
        if (topEnter != null) {
            topOfTree(topEnter.getFather());
            topOfTree(topEnter.getMother());
        }

        return true;
    }
}



