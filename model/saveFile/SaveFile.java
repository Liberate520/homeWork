package model.saveFile;

import java.io.Serializable;

import model.tree.FamilyTree;

public class SaveFile {
    private FamilyTree humanList;

    public SaveFile() {
        this.humanList = humanList;
    }

    public void saveFile(FamilyTree humanList) {
        Writable writable = new FileHandler();
        writable.save((Serializable) humanList, "Test.txt");
    }

}
