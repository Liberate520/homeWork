package model.saveFile;

import java.io.Serializable;
import human.Human;
import model.tree.FamilyTree;

public class Save {
    private FamilyTree<Human> humanList;

    public Save(FamilyTree<Human> humanList) {
        this.humanList = humanList;
    }

    public void save(FamilyTree<Human> humanList) {

        Writable writable = new FileHandler();
        writable.save((Serializable) humanList, "Test/txt");
    }
}
