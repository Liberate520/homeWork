package homeWork_OOP_family_tree;

import java.time.LocalDate;
import java.util.List;

import homeWork_OOP_family_tree.infoHuman.FamilywTree;
import homeWork_OOP_family_tree.infoHuman.Human;
import homeWork_OOP_family_tree.infoHuman.Node;

public class Main {
    public static void main(String[] args) {
        Human anton = new Human("антон", LocalDate.of(1999, 10, 5), "male");
        Node antonN = new Node(anton);

        Human masha = new Human("маша", LocalDate.of(1990, 7, 3), "female");
        Node mashaN = new Node(masha);

        Human gosha = new Human("гоша", LocalDate.of(2020, 7, 3), "male");
        Node goshaN = new Node(gosha);

        mashaN.addChild(goshaN, antonN);

        FamilywTree fam1 = new FamilywTree();
        fam1.add(mashaN);
        fam1.add(goshaN);
        fam1.add(antonN);

        List<Node> z = fam1.searchName("антон");
        System.out.println(z.size());
        z.get(0).people.printHuman();
        System.out.println();
        z.get(0).printChildren();
        // SavingFile fil = new SavingFile("Saving.bin");
        // fil.toStore(fam1);

        // try {
        // FamilywTree f2 = fil.pullFromFile();
        // System.out.println(f2.getInfo());

        // Human toha = new Human("антон", LocalDate.of(2020, 7, 3)
        // ,"male");
        // Node tohaN = new Node(toha);

        // f2.add(tohaN);

        // System.out.println(f2.getInfo());
        // List<Node> t = f2.searchName("гоша");
        // System.out.println(t.size());
        // t.get(0).people.printHuman();
        // System.out.println();

        // } catch (Exception e) {
        // // TODO: handle exception
        // }

        fam1.sortByName();

        for (Node node : fam1) {
            node.people.printHuman();
            System.out.println();
        }

        fam1.sortByAge();

        for (Node node : fam1) {
            node.people.printHuman();
            System.out.println();
        }

    }

}