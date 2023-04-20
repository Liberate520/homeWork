package homeWork.src;

import java.util.List;


public class Research {
    public static void main(String[] args) {
        Human john = new Human("John", 35, "Мужской");
        Human sarah = new Human("Sarah", 32, "Женский");
        Human mark = new Human("Mark", 12, "Мужской");
        Human jane = new Human("Jane", 9, "Женский");
        Human lucas = new Human("Lucas", 7, "Мужской");

        FamilyTree familyTree = new FamilyTree();
        familyTree.addParent(john, mark);
        familyTree.addParent(john, jane);
        familyTree.addParent(john, lucas);
        familyTree.addParent(sarah, mark);
        familyTree.addParent(sarah, jane);
        familyTree.addParent(sarah, lucas);

        // Add a sibling relationship between Jane and Lucas
        familyTree.addSibling(jane, lucas);

        List<Human> johnChildren = familyTree.getChildren(john);
        if (johnChildren != null) {
            System.out.println("Дети Джона:");
            for (Human child : johnChildren) {
            System.out.println(child.toString());
            }
        }
            // Get all siblings of Jane
        List<Human> janeSiblings = familyTree.getChildren(jane.getParent());
        if (janeSiblings != null) {
            System.out.println("\nРодные братья и сестры Джейн:");
            for (Human sibling : janeSiblings) {
                if (!sibling.equals(jane)) {
                    System.out.println(sibling.toString());
                }
            }
        }
    }
}