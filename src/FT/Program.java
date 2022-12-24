package FT;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Human> family = new ArrayList<>();
        family.add(new Human("Alexandr", "Kukin")); //0
        family.add(new Human("Nikita", "Kukin"));  //1
        family.add(new Human("Eva", "Kukina"));  //2
        family.add(new Human("Ksenia", "Kukina")); //3
        family.add(new Human("Evgenia", "Melnichuk")); //4
        family.add(new Human("Oleg", "Melnichuk"));  //5
        family.add(new Human("Anzhela", "Kukina"));  //6
        family.add(new Human("Andrey", "Kukin")); //7

        printFamily(family);

        Tree tree = new Tree();
        tree.addLink(family.get(0), family.get(1), Relation.FATHER, Relation.SON);
        tree.addLink(family.get(0), family.get(2), Relation.FATHER, Relation.DAUGHTER);
        tree.addLink(family.get(3), family.get(1), Relation.MOTHER, Relation.SON);
        tree.addLink(family.get(3), family.get(2), Relation.MOTHER, Relation.DAUGHTER);
        tree.addLink(family.get(3), family.get(0), Relation.WIFE, Relation.HUSBANT);
        tree.addLink(family.get(1), family.get(2), Relation.BROTHER, Relation.SYSTER);
        tree.addLink(family.get(4), family.get(5), Relation.WIFE, Relation.HUSBANT);
        tree.addLink(family.get(6), family.get(7), Relation.WIFE, Relation.HUSBANT);
        tree.addLink(family.get(7), family.get(0), Relation.FATHER, Relation.SON);
        tree.addLink(family.get(6), family.get(0), Relation.MOTHER, Relation.SON);
        tree.addLink(family.get(4), family.get(3), Relation.MOTHER, Relation.DAUGHTER);
        tree.addLink(family.get(5), family.get(3), Relation.FATHER, Relation.DAUGHTER);

        tree.addLink(family.get(7), family.get(1), Relation.GRANDFATHER, Relation.GRANDSON);
        tree.addLink(family.get(7), family.get(2), Relation.GRANDFATHER, Relation.GRANGDAUGHTER);
        tree.addLink(family.get(6), family.get(2), Relation.GRANDMOTHER, Relation.GRANGDAUGHTER);
        tree.addLink(family.get(6), family.get(1), Relation.GRANDMOTHER, Relation.GRANDSON);

        tree.addLink(family.get(5), family.get(1), Relation.GRANDFATHER, Relation.GRANDSON);
        tree.addLink(family.get(5), family.get(2), Relation.GRANDFATHER, Relation.GRANGDAUGHTER);
        tree.addLink(family.get(4), family.get(2), Relation.GRANDMOTHER, Relation.GRANGDAUGHTER);
        tree.addLink(family.get(4), family.get(1), Relation.GRANDMOTHER, Relation.GRANDSON);



        UI.call(tree);

    }

    private static void printFamily(List<Human> family) {
        System.out.println("\n\nСписок членов семьи:");
        for (Human item : family) {
            System.out.println(item.getName() + " " + item.getSurname());
        }
    }
}