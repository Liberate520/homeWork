package FamilyTree;

import java.time.LocalDate;

import static FamilyTree.Sex.Female;
import static FamilyTree.Sex.Male;

public class main {
    public static void main(String[] args){
        Tree tree = new Tree ();

        tree.addPerson (new Person("Иван Федорович Крузенштерн", Male, LocalDate.of(1975,07,10 )));
        tree.addPerson (new Person("Вероника Степановна Кулебякина", Female, LocalDate.of(1977,06,10 )));
        tree.addPerson (new Person("Дядя Федор", Male, LocalDate.of(1995,06,01 )));
        tree.addPerson (new Person("Жучка", Female, LocalDate.of(1997,06,01 )));
        tree.getByName("Иван Федорович Крузенштерн").addChild (tree.getByName("Дядя Федор"));
        tree.getByName("Иван Федорович Крузенштерн").addChild (tree.getByName("Жучка"));

        //tree.getByName ("Иван Федорович Крузенщтерн").addDd (LocalDate.of(2022,07,10 ));
       // tree.coonectSpouse ("Иван Федорович Крузенщтерн","Вероника Степановна Кулебякина");

        System.out.println(tree.getInfo());
        System.out.println(tree.getByName("Иван Федорович Крузенштерн").getChildrenInfo());
        System.out.println(tree.getByName("Вероника Степановна Кулебякина").getChildrenInfo());
    }
}
