import java.util.ArrayList;
import java.sql.SQLOutput;


public class Main {
    public static void main(String[] args) {

        Tree myTree = new Tree();
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
        myTree.createTreeHuman("Olga", h1, h2);
        myTree.createTreeHuman("Oleg", h3, h4);
        myTree.createTreeHuman("Anna", h5, h6);
        myTree.createTreeHuman("Luba", h5, h6);
        myTree.createTreeHuman("Gleb", h8, h9);
        myTree.createTreeHuman("Yla", h8, h9);


        Tree dogTree = new Tree();
        Dog d1 = new Dog("Бесси", 1);
        Dog d2 = new Dog("Давид", 1);
        Dog d3 = new Dog("Анфи", 1);
        Dog d4 = new Dog("Грем", 1);
        Dog d5 = new Dog("Виста", 1);
        Dog d6 = new Dog("Джек", 1);
        dogTree.createTreeDog("Анфи", 1, d1, d2);
        dogTree.createTreeDog("Виста",1, d3,d4);
        dogTree.createTreeDog("Джек",1, d3, d4);





        // public void printTree(ArrayList<Human> myTree){
        //     for(int i = 0; i< myTree.size(); i++){
        //         System.out.printf( "%s", i);
        //     }
        // }
        Tree.myTree.forEach(p->{
            System.out.println(p);
        });

        System.out.println("----------");
        ArrayList<Printable> children = myTree.addChildren(h5, h6);
        ArrayList<Printable> children1 = myTree.addChildren(h8, h9);
        Tree.children.forEach(p->{
            System.out.println(p);
        });


        Tree.dogTree.forEach(p->{
            System.out.println(p);
        });

    }

}



}
