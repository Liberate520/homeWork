package tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Write write = new Write();
        tree.add(new Human("Anton", LocalDate.of(1988, 03, 29), Gender.Male));
        tree.add(new Human("Nataliya", LocalDate.of(1994, 06, 20), Gender.Female));
        tree.add(new Human("Artem", LocalDate.of(2020, 02, 16), Gender.Male, tree.getByName("Anton"), tree.getByName("Nataliya")));
        tree.add(new Human("Alexander", LocalDate.of(2021, 03, 01), Gender.Male, tree.getByName("Anton"), tree.getByName("Nataliya")));

        write.save(tree,"tree.txt");
//        tree = (Tree) write.load("tree.txt");
        System.out.println(tree.getInfo());
    }
}



