package homeWork.src;

import java.util.List;

public class Research {
    public static void main(String[] args) {
        Person john = new Human("John", 35, "Мужской");
        Person sarah = new Human("Sarah", 32, "Женский");
        Person mark = new Human("Mark", 12, "Мужской");
        Person jane = new Human("Jane", 9, "Женский");
        Person lucas = new Human("Lucas", 7, "Мужской");
    
        GenealogicalTree familyTree = new FamilyTree();
        familyTree.addParent((Human) john, (Human) mark);
        familyTree.addParent((Human) john, (Human) jane);
        familyTree.addParent((Human) john, (Human) lucas);
        familyTree.addParent((Human) sarah, (Human) mark);
        familyTree.addParent((Human) sarah, (Human) jane);
        familyTree.addParent((Human) sarah, (Human) lucas);
    
        // Add a sibling relationship between Jane and Lucas
        familyTree.addSibling((Human) jane, (Human) lucas);
    
        List<Human> johnChildren = familyTree.getChildren((Human) john);
        if (johnChildren != null) {
            System.out.println("Дети Джона:");
            for (Person child : johnChildren) {
                System.out.println(child.toString());
            }
        }
    
        // Get all siblings of Jane
        List<Human> janeSiblings = familyTree.getChildren(jane.getParent());
        if (janeSiblings != null) {
            System.out.println("\nРодные братья и сестры Джейн:");
            for (Person sibling : janeSiblings) {
                if (!sibling.equals(jane)) {
                    System.out.println(sibling.toString());
                }
            }
        }
    }
}
    