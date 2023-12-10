package model.family_tree;


import model.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public class TreeAppNaturally<T extends Creature> {
    FamilyTree familyTree;
    T treeTop;

    public TreeAppNaturally(FamilyTree familyTree) {
        this.familyTree = familyTree;
        this.treeTop = (T) familyTree.getFamilyTree().getFirst();
    }


    public T getTop() {
        topOfTree(this.treeTop);
        return this.treeTop;
    }

    public String showTree() {
        topOfTree(this.treeTop);
        return showTreeService(this.treeTop, 1);
    }

    private String showTreeService(T top, int count) {
        StringBuilder sb = new StringBuilder();
        List<T> tempChildren = new ArrayList<>();
        boolean flag = false;
        if (top != null) {
            sb.append(String.format("\n%d уровень семьи: %s, %s г. р.\n", count, top.getName(), top.getBirthDate()));
            if (top.getSpouse() != null) {
                sb.append(String.format("Супруг : %s\n", top.getSpouse().getName()));
            }
            if (!top.getChildren().isEmpty()) {
                sb.append(String.format("Дети: "));
                for (T child :(List<T>) top.getChildren()){
                    tempChildren.add(child);
                    if (flag) sb.append(", ");
                    sb.append(child.getName());
                    flag = true;
                }
            }
        }
        for (T child : tempChildren) {
            sb.append(showTreeService(child, count + 1));
        }
        return sb.toString();
    }

    private boolean topOfTree(T topEnter) {
        if (topEnter != null && topEnter.getFather() == null && topEnter.getMother() == null) {
            if (topEnter.getSpouse() != null) {
                if (topEnter.getSpouse().getFather() != null || topEnter.getSpouse().getMother() != null) {
                    topOfTree((T) topEnter.getSpouse());
                }
            } else {
                this.treeTop = topEnter;
            }
        }
        if (topEnter != null) {
            topOfTree((T) topEnter.getFather());
            topOfTree((T) topEnter.getMother());
        }

        return true;
    }
}
