import java.time.LocalDate;
import java.util.Iterator;

import FamilyTree.FamilyTree;
import FileHandler.FileHandler;
import Human.Human;

public class Main {
public static void main(String[] args) {
    String path = "homeWork/src/data/familyData.out";
    // FileHandler fh = new FileHandler();
    FamilyTree<Human> tree = NewTree();
    System.out.println(tree.getInfo());
    tree.sortByAge();
    System.out.println(tree.getInfo());
    tree.sortByName();
    System.out.println(tree.getInfo());
    // fh.save(tree, path);
    // FileHandler fh = new FileHandler();
    // FamilyTree tree = (FamilyTree)fh.load(path);
    // System.out.println(tree.getInfo());
    Iterator<Human> hIterator = tree.iterator();
    while(hIterator.hasNext()){
        Human human = hIterator.next();
        System.out.println(human.getName());
    }
}  
public static FamilyTree<Human> NewTree(){
    FamilyTree<Human> tree = new FamilyTree<>();
    Human ivan = new Human("Ivan","male",LocalDate.of(1990, 12, 9));
    Human ekaterina = new Human("Ekaterina","female",LocalDate.of(1991, 5, 21));
    Human viktoria = new Human("Viktoria","female",LocalDate.of(2015, 3, 12),ekaterina,ivan);
    Human olga = new Human("Olga","female",LocalDate.of(1955, 1, 11));
    Human victor = new Human("Victor","male",LocalDate.of(1955, 12, 18));
    Human maria = new Human("Maria","female",LocalDate.of(1949, 8, 21));
    Human alexey = new Human("Alexey","male",LocalDate.of(1948, 9, 19));
    ivan.addFather(victor);
    ivan.addMother(olga);
    ekaterina.addFather(alexey);
    ekaterina.addMother(maria);
    
    tree.addHuman(ivan);
    tree.addHuman(ekaterina);
    tree.addHuman(viktoria);
    tree.addHuman(olga);
    tree.addHuman(victor);
    tree.addHuman(maria);
    tree.addHuman(alexey);
    tree.setWedding(ekaterina, ivan);
    tree.setWedding(maria, alexey);
    tree.setWedding(olga, victor);
    return tree;
}

}