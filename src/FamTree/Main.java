package FamTree;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String path = "/home/aleksandr/IdeaProjects/homeWork/tree.txt";
        Load load = new FileHandler();
        //FamilyTree tree = (FamilyTree)load.load(path);
        FamilyTree tree = new FamilyTree();

        Human Mary = new Human("Mary", 35);
        Human Jack = new Human("Jack", 34);
        Human Jane = new Human("Jane", 36);
        Human Alex = new Human("Alex", 45);
        Human Ted = new Human("Ted", 10);
        Human Bred = new Human("Bred", 5);

        load.save(tree, path);

        ArrayList<Human> persons = null;
        FamilyTree ft = new FamilyTree(persons);


        ft.ChildrenParent(Ted, Jack);
        ft.ChildrenParent(Bred, Jane);
        ft.ChildrenParent(Bred, Alex);
        ft.ChildrenParent(Ted, Mary);
        ft.AddManWoman(Mary, Jack);
        ft.AddManWoman(Alex, Jane);

        System.out.println("Mary child's: ");
        System.out.println(new Searching(ft).spend(Mary, Family.parent));
        System.out.println(new Searching(ft).spend(Jack, Family.parent));

        System.out.println("Jane child's: ");
        System.out.println(new Searching(ft).spend(Jane, Family.parent));

        System.out.println("Alex child's: ");
        System.out.println(new Searching(ft).spend(Alex, Family.parent));

        System.out.println("Mary husbent: ");
        System.out.println(new Searching(ft).spend(Mary, Family.wife));

        System.out.println("Alex vife: ");
        System.out.println(new Searching(ft).spend(Alex, Family.wife));


        System.out.println(new Searching(ft).searchAge());
    }

}
