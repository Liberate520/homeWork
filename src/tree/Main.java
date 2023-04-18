package tree;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
 
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        Human father = new Human("Иван", "Иванов", new GregorianCalendar(1970, 3, 11));
        Human mother = new Human("Мария", "Иванова", new GregorianCalendar(1978, 6, 26));
        Human son = new Human("Петр", "Иванов", new GregorianCalendar(1999, 11, 8));
        Human daughter = new Human("Ольга", "Иванова", new GregorianCalendar(2003, 8, 31));

        FileHanddler file = new FileHanddler();
        file.load();

        father.addChild(son);
        father.addChild(daughter);
        mother.addChild(son);
        mother.addChild(daughter);
        son.addParent(father);
        son.addParent(mother);
        daughter.addParent(father);
        daughter.addParent(mother);

        tree.addHuman(father);
        tree.addHuman(mother);
        tree.addHuman(son);
        tree.addHuman(daughter);

        file.save(tree.getPeopleList());

        List<Human> children = tree.getChildren(mother);
        System.out.println("Мать: " + mother);
        System.out.println("\tдети: ");
        for (Human child : children) {
            System.out.println("\t" + child.toString());
        }

        List<Human> childList = tree.getChildren(father);
        System.out.println("Отец: " + father);
        System.out.println("\tдети: ");
        for (Human child : childList) {
            System.out.println("\t" + child.toString());
        }

        List<Human> ancestors = tree.getAncestors(daughter);
        System.out.println("Персона: " + daughter);
        System.out.println("\tРодители: ");
        for (Human ancestor : ancestors) {
            
            System.out.println("\t" + ancestor.toString());
            
        }

        file.read();


       
        // List<Human> relatives = tree.getRelatives(son);
        // for (Human relative : relatives) {            
        //     System.out.println(relative.toString());            
        // }

        // List<Human> searchResult = tree.searchByName("Ольга");
        // for (Human human : searchResult) {
        //     System.out.println();
        //     System.out.println(human.toString());
        //}
    }
}
