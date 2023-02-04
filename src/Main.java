import java.util.ArrayList;
import java.sql.SQLOutput;


public class Main {
    public static void main(String[] args) {

        Tree ourTree = new Tree();
        Human h1 = new Human("Vala");
        Human h2 = new Human("Ivan");
        Human h3 = new Human("Valentina");
        Human h4 = new Human("Alexei");
        Human h5 = new Human("Olga", h1, h2);
        Human h6 = new Human("Oleg", h3, h4);
        Human h7 = new Human("Anna", h5, h6);
        Human h8 = new Human("Luba", h5, h6);
        Human h9 = new Human("Kosta");
        Human h10 = new Human("Gleb", h8, h9);
        Human h11 = new Human("Yla", h8, h9);
        ourTree.createTreeT(h5);
        ourTree.createTreeT(h6);
        ourTree.createTreeT(h7);
        ourTree.createTreeT(h8);
        ourTree.createTreeT(h10);
        ourTree.createTreeT(h11);


        Tree dogTree = new Tree();
        Dog d1 = new Dog("Бесси", 1);
        Dog d2 = new Dog("Давид", 1);
        Dog d3 = new Dog("Анфи", 1, d1, d2);
        Dog d4 = new Dog("Грем", 1);
        Dog d5 = new Dog("Виста", 1, d3, d4);
        Dog d6 = new Dog("Джек", 1, d3, d4);
        dogTree.createTreeT(d3);
        dogTree.createTreeT(d5);
        dogTree.createTreeT(d6);





        ourTree.forEach(p->{
            System.out.println(p);
        });

        System.out.println("----------");
        ArrayList<Printable> children = ourTree.findChildren(h5, h6);
        ArrayList<Printable> children1 = ourTree.findChildren(h8, h9);
        children.forEach(p->{
            System.out.println(p);
        });


        dogTree.forEach(p->{
            System.out.println(p);
        });

    }

}




