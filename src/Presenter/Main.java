package Seminars_OOP.HW_6.src.Presenter;

import java.io.Serializable;
import Seminars_OOP.HW_6.src.Model.FamilyTree;
import Seminars_OOP.HW_6.src.Model.FileHandler;
import Seminars_OOP.HW_6.src.Model.Human;
import Seminars_OOP.HW_6.src.View.View;

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
