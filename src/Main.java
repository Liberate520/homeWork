import model.FamilyTree.FamilyTree;
import model.creature.Creature;
import model.creature.Gender;
import model.creature.Human;
import model.writer.FileHandler;
import model.Service.Service;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.IOException;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        String filePath = "E:\\GB\\2 четверть\\ООП\\Homework\\Project\\src\\model\\writer\\Creature.out";

        FileHandler fileHandler = new FileHandler();

//        FamilyTree<Creature> tree = testTree();
        FamilyTree<Creature> tree = (FamilyTree) fileHandler.read(filePath);
        View view = new ConsoleUI(tree);
        view.start();
//        Service service = new Service();
//
//        System.out.println(tree);
//        service.sortByAge();
//        System.out.println(tree);
//        service.sortByName();
//        System.out.println(tree);


//        fileHandler.write(tree, filePath);
    }

//    static  FamilyTree<Creature> testTree(){
//        FamilyTree<Creature> tree = new FamilyTree<>();
//
//        Human andrey = new Human("andrey", Gender.MALE, LocalDate.of(1983,10,1));
//        Human masha = new Human("masha", Gender.FEMALE, LocalDate.of(1987,1,19));
//        tree.add(andrey);
//        tree.add(masha);
//        tree.setWedding(andrey, masha);
//
//        Human david = new Human("david", Gender.MALE, LocalDate.of(2017,8,22),andrey, masha);
//        Human ilya = new Human("ilya", Gender.FEMALE, LocalDate.of(2022,6,1),andrey, masha);
//        tree.add(david);
//        tree.add(ilya);
//
//        Human elena = new Human("elena", Gender.FEMALE, LocalDate.of(1960, 1, 23));
//        elena.addChildren(andrey);
//        tree.add(elena);
//
//        Human makar = new Human("makar", Gender.MALE, LocalDate.of(2015, 6, 6));
//        tree.add(makar);
//        andrey.addChildren(makar);
//
//        return tree;
//    }
}