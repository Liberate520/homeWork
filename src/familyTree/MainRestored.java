package familyTree;

import familyTree.saving.SaveAndLoad;
import familyTree.saving.Serial;
import familyTree.tree.FamilyTree;

public class MainRestored {
    public static void main(String[] args) {
        SaveAndLoad saveLoad = new Serial();
        FamilyTree newTreeRestored = saveLoad.loadingTree("familyTree.ser");
        System.out.println(newTreeRestored.showAll());
    }
}
