package FamilyTree;

import FamilyTree.Model.File.FileHandler;
import FamilyTree.Model.tree.Person;
import FamilyTree.Model.tree.Tree;
import FamilyTree.Model.tree.TreeAble;
import FamilyTree.View.ConsoleUI;
import FamilyTree.View.View;

import java.io.IOException;
import java.time.LocalDate;

import static FamilyTree.Model.tree.Sex.Female;
import static FamilyTree.Model.tree.Sex.Male;

public class main {
    public static void main (String[] args) throws IOException, ClassNotFoundException {


      View view = new ConsoleUI(new Tree(),new FileHandler());
//
      view.start();
//        Tree tree = new Tree ();
//
//        tree.addPerson (new Person("Иван Федорович Крузенштерн", Male, LocalDate.of(1975,07,10 )));
//        tree.addPerson (new Person("Вероника Степановна Кулебякина", Female, LocalDate.of(1977,06,10 )));
//        tree.addPerson (new Person("Дядя Федор", Male, LocalDate.of(1995,06,01 )));
//        tree.addPerson (new Person("Жучка", Female, LocalDate.of(1997,06,01 )));
//
//
////        tree.getById(1).addChild (tree.getById(3));
////        tree.getById(1).addChild (tree.getById(4));
//
//       // tree.getByName ("Иван Федорович Крузенщтерн").addDd (LocalDate.of(2022,07,10 ));
//
//
////        System.out.println(tree.getInfo());
////        System.out.println(tree.getById(1).getChildrenInfo());
////        System.out.println(tree.getByName("Вероника Степановна Кулебякина").getChildrenInfo());
//
//        FileHandler fh= new FileHandler();
//        fh.save(tree);
////        System.out.println("tecn 4");
//        TreeAble RessoredTree = fh.load ();
//////
//        System.out.println(RessoredTree.getInfo());
//        System.out.println(RessoredTree.getById("1").getChildrenInfo());
//        System.out.println(RessoredTree.getBy("Вероника Степановна Кулебякина").getChildrenInfo());

//        tree.sortAge();
//        System.out.println(tree.getInfo());
//        tree.sortName();
//        System.out.println(tree.getInfo());

     //   for (Object person: tree) System.out.println(((Person)(person)).getName());









    }


}
