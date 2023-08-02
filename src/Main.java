import java.time.LocalDate;

import FamilyTree.FamilyTree;
import Human.Human;

public class Main {
public static void main(String[] args) {
    FamilyTree tree = NewTree();
    System.out.println(tree.getInfo());
}  
public static FamilyTree NewTree(){
    FamilyTree tree = new FamilyTree();
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