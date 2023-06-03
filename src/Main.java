import human.Gender;
import human.Human;
import serializer.Serializer;
import serializer.TreeSerializer;
import tree.FamilyTree;
import tree.FamilyTreeItem;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree1 = new FamilyTree();
        Human human1 = new Human("Василий", "Иванов", Gender.Male, LocalDate.of(1991, 12, 25),
                null,null,null);
        Human human2 = new Human("Кристина", "Иванова", Gender.Female, LocalDate.of(1988, 1, 2),
                null,null,null);

        Human human3 = new Human("Ольга", "Иванова",Gender.Female, LocalDate.of(1988, 1, 2),
                null,null,null);
        Human human4 = new Human("Иван", "Иванов",Gender.Male, LocalDate.of(1988, 5, 6),
                null, null,null);
        Human human5 = new Human("Сергей", "Иванов",Gender.Male, LocalDate.of(1989, 4, 9),
                null, null,null);

        human3.setMother(human2);
        human4.setMother(human2);
        human5.setMother(human2);
        human3.setFather(human1);
        human4.setFather(human1);
        human5.setFather(human1);

        List<Human> brothers1 = new ArrayList<>();
        List<Human> brothers2 = new ArrayList<>();
        List<Human> brothers3 = new ArrayList<>();
        brothers1.add(human4);
        brothers1.add(human5);
        brothers2.add(human4);
        brothers3.add(human5);
        human3.setBrothers(brothers1);
        human4.setBrothers(brothers3);
        human5.setBrothers(brothers2);

        List<Human> sisters = new ArrayList<>();
        sisters.add(human3);
        human4.setSisters(sisters);
        human5.setSisters(sisters);

        tree1.add(human1);
        tree1.add(human2);
        tree1.add(human3);
        tree1.add(human4);
        tree1.add(human5);

        System.out.println(tree1.getInfo());

        List<Human> human3Parents = tree1.getParents(human3);
        List<Human> human4Siblings = tree1.getSiblings(human4);
        System.out.println("Родители " + human3Parents.toString());
        System.out.println("Братья и сестры Ивана: " + human4Siblings.toString());

        List<FamilyTreeItem> human1Children = human2.getChildren();
        System.out.println("Дети Кристины: " + human1Children.toString());

        System.out.println("--------------------------");
        human2.childrenSortByName();
        System.out.println("Дети Кристины сортированные по имени: " + human1Children);

        System.out.println("--------------------------");
        human2.childrenSortByAge();
        System.out.println("Дети Кристины сортированные по возрасту: " + human1Children);
        System.out.println("\r");

        Serializer serializer = new TreeSerializer();
        String filePath1 = "tree1.dat";
        File f1 = new File(filePath1);
        FamilyTree loadedtree1;
        if(f1.exists() && !f1.isDirectory()) {
            loadedtree1 = (FamilyTree)serializer.load(filePath1);
            System.out.println("Загруженное дерево: " + loadedtree1.getInfo());
        } else {
            serializer.save(tree1, filePath1);
            System.out.println("Дерево сохранено");
        }
    }
}
