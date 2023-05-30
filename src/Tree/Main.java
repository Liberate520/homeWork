package Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human anton = new Human("Anton", LocalDate.of(1988, 03, 29), Gender.Male);
        Human nataliya = new Human("Nataliya", LocalDate.of(1994, 06, 20), Gender.Female);
        Human artem = new Human("Artem", LocalDate.of(2020, 02, 16), Gender.Male);
        Human alexander = new Human("Alexander", LocalDate.of(2021, 03, 01), Gender.Male);
        anton.addChildren(artem);
        anton.addChildren(alexander);
        Tree tree = new Tree();
        tree.add(anton);
        tree.add(nataliya);
        tree.add(artem);
        tree.add(alexander);
        System.out.println(tree.toString());
        System.out.println(tree.getByName("Anton"));
    }
}



