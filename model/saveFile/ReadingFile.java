package model.saveFile;

import human.Human;
import model.tree.FamilyTree;

public class ReadingFile {
    private FamilyTree humanList;

    public ReadingFile() {
        this.humanList = humanList;
    }

    public void readFile() {
        Writable writable = new FileHandler();
        writable.read("Test.txt");
        humanList = (FamilyTree<Human>) writable.read("Test.txt");
    }

}
