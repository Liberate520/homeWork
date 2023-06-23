import familytree.Tree;
import familytree.TreeService;
import human.Human;
import presenter.Presenter;
import save.FileOperations;
import save.Save;
import ui.Console;
import ui.View;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {



        familytree.Tree<Human> tree = new familytree.Tree<>();
        View view = new Console();
        TreeService treeService = new TreeService(tree);




//        System.out.println(tree.getInfo());

//        TreeService treeSort = new TreeService(tree);
        treeService.sortByAge();
        System.out.println(tree.getInfo());
        treeService.sortByName();
        System.out.println(tree.getInfo());
        treeService.sortById();
        System.out.println(tree.getInfo());

        treeService.setWrite(new Save());

        new Presenter(view,treeService);
        view.start();




    }
    }
