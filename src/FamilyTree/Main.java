package FamilyTree;

import FamilyTree.FamilyTree.CreatureItem;
import FamilyTree.FamilyTree.FamilyTree;
import FamilyTree.creature.Cat;
import FamilyTree.creature.Creature;
import FamilyTree.creature.Gender;
import FamilyTree.creature.Human;
import FamilyTree.writer.FileHandler;
import FamilyTree.Service.Service;

import java.io.IOException;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "E:\\GB\\2 четверть\\ООП\\Homework\\Project\\src\\FamilyTree\\writer\\Creature.out";
        FileHandler fileHandler = new FileHandler();

//        FamilyTree<Creature> tree = testTree();
        FamilyTree<Creature> tree = (FamilyTree) fileHandler.read(filePath);
        Service service = new Service(tree);

        System.out.println(tree);
        service.sortByAge();
        System.out.println(tree);
        service.sortByName();
        System.out.println(tree);


//        fileHandler.write(tree, filePath);
    }

//    static  FamilyTree<Creature> testTree(){
//        FamilyTree<Creature> tree = new FamilyTree<>();
//
//        Human andrey = new Human("andrey", Gender.Male, LocalDate.of(1983,10,1));
//        Human masha = new Human("masha", Gender.Female, LocalDate.of(1987,1,19));
//        tree.add(andrey);
//        tree.add(masha);
//        tree.setWedding(andrey, masha);
//
//        Human david = new Human("david", Gender.Male, LocalDate.of(2017,8,22),andrey, masha);
//        Human ilya = new Human("ilya", Gender.Male, LocalDate.of(2022,6,1),andrey, masha);
//        tree.add(david);
//        tree.add(ilya);
//
//        Human elena = new Human("elena", Gender.Female, LocalDate.of(1960, 1, 23));
//        elena.addChildren(andrey);
//        tree.add(elena);
//
//        Human makar = new Human("makar", Gender.Male, LocalDate.of(2015, 6, 6));
//        tree.add(makar);
//        andrey.addChildren(makar);
//
//        return tree;
//    }
}