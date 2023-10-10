package ru.gb.family_tree;

import ru.gb.family_tree.Model.Family.Service.Service;
import ru.gb.family_tree.Model.Family.Tree.FamilyTree;
import ru.gb.family_tree.View.ConsoleUI;
import ru.gb.family_tree.View.View;
import ru.gb.family_tree.writer.FileHandler;

public class Main1{
    public static void main(String[] args){

        View view = new ConsoleUI();
        view.start();

        //String fileName = "/Users/egor/Documents/Учеба/ООП/NewProgect/src/ru/gb/family_tree/writer/test.txt";
       // FileHandler fileHandler = new FileHandler();
        //Service servise = new Service<>();
        //FamilyTree tree =  servise.addTree();
        //FamilyTree tree = (FamilyTree) fileHandler.read(fileName);
        //System.out.println(tree.getHumanInfo());



        //fileHandler.save(tree, fileName);
        //tree.sortByAge();
        //tree.sortByGender();
        //tree.sortByName();
        //tree.sortByDateOfBirth();
        //System.out.println(tree);

    }

}

