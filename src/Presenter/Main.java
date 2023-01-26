package Seminars_OOP.HW_7.src.Presenter;

import Seminars_OOP.HW_7.src.Model.FamilyTree;
import Seminars_OOP.HW_7.src.Model.FileHandler;
import Seminars_OOP.HW_7.src.Model.Human;
import Seminars_OOP.HW_7.src.View.View;

import java.io.Serializable;

public class Main implements Serializable{
    public static void main(String[] args){
        View view = new View();
        FamilyTree familyTree = new FamilyTree();
        Presenter presenter = new Presenter(view, familyTree);

        FileHandler fileHandler = new FileHandler();
        familyTree.setWritable(fileHandler);
        familyTree = familyTree.readFamilyTree();

        familyTree.addHuman(new Human("Мария", 1939, "f", null, null));
        familyTree.addHuman(new Human("Владимир", 1938, "m", null, null));
        familyTree.addHuman(new Human("Людмила", 1961, "f", null, null));
        familyTree.addHuman(new Human("Виктория", 1973, "f"));
        familyTree.addHuman(new Human("Станислав", 1987, "m", null, null));
        familyTree.addHuman(new Human("Вероника", 2013, "f"));
        familyTree.addHuman(new Human("Даниил", 2012, "m", null, null));


        view.setPresenter(presenter);
        view.view();

    }
}
