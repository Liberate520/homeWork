package tree;

import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Human father = new Human("Иван", "Иванов", new GregorianCalendar(1970, 3, 11));
        Human mother = new Human("Мария", "Иванова", new GregorianCalendar(1978, 6, 26));
        Human son = new Human("Петр", "Иванов", new GregorianCalendar(1999, 11, 8));
        Human daughter = new Human("Ольга", "Иванова", new GregorianCalendar(2003, 8, 31));

        father.addChild(son);
        father.addChild(daughter);
        mother.addChild(son);
        mother.addChild(daughter);

        tree.addHuman(father);
        tree.addHuman(mother);
        tree.addHuman(son);
        tree.addHuman(daughter);

        List<Human> children = tree.getChildren(mother);
        System.out.println("мать: " + mother);
        for (Human child : children) {
            System.out.println("\tдети: " + child.toString());
        }

        List<Human> childList = tree.getChildren(father);

        for (Human child : childList) {
            System.out.println(child.toString());
        }

        List<Human> descendants = tree.getDescendants(mother);

        for (Human descendant : descendants) {
            System.out.println();
            System.out.println(descendant.toString());
            
        }

        List<Human> relatives = tree.getRelatives(son);

        for (Human relative : relatives) {
            
            System.out.println(relative.toString());
            
        }

        List<Human> searchResult = tree.searchByName("Ольга");
        

        for (Human human : searchResult) {
            System.out.println();
            System.out.println(human.toString());
        }
    }
}
