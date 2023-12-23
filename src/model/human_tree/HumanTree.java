package model.human_tree;


import model.creatures.Creature;
import model.family_tree.FamilyTree;

import java.util.ArrayList;
import java.util.List;


public class HumanTree<T extends Creature> {
    private T treeTop;


    public T getTop(FamilyTree familyTree) {
        topOfTree(this.treeTop, familyTree);
        return this.treeTop;
    }

    public String showTree(FamilyTree familyTree) {
        topOfTree(this.treeTop, familyTree);
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
                for (T child : (List<T>) top.getChildren()) {
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

    private boolean topOfTree(T topEnter, FamilyTree familyTree) {
        if (!familyTree.emptyCheck()) {
            return false;
        } else {
            this.treeTop = (T) familyTree.getFirstMember();
            if (topEnter != null && topEnter.getFather() == null && topEnter.getMother() == null) {
                if (topEnter.getSpouse() != null) {
                    if (topEnter.getSpouse().getFather() != null || topEnter.getSpouse().getMother() != null) {
                        topOfTree((T) topEnter.getSpouse(), familyTree);
                    }
                } else {
                    this.treeTop = topEnter;
                }
            }
            if (topEnter != null) {
                topOfTree((T) topEnter.getFather(), familyTree);
                topOfTree((T) topEnter.getMother(), familyTree);
            }

            return true;
        }
    }
}
