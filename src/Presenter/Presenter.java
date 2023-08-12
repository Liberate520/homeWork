package Presenter;
import Model.FileHandler;
import Model.HouseHold;
import Model.Human;
import View.Viewable;
import Model.FamilyTree;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;

public class Presenter {
    private Viewable view;
    private FamilyTree<HouseHold> tree;

    private FileHandler fileHandler;

    public Presenter(Viewable view) {
        fileHandler = new FileHandler();
        this.view = view;
        this.tree = tree;
    }
    public void addHouseHold(HouseHold houseHold){
        tree.add(houseHold);
    }

    public FamilyTree<HouseHold> getTree(){
        return tree;
    }

    public void getListInfo(){
        tree.print();
        System.out.println("Дерево распечатано");
    }

    public void sortByName(){
        tree.sortByName();
        System.out.println("Дерево отсортировано по имени");
    }

    public void sortByAge(){
        tree.sortByAge();
        System.out.println("Дерево отсортировано по возрасту");
    }

    public void saveToFile(){
        fileHandler.save(tree, "src/Data/text.out");
    }
}
