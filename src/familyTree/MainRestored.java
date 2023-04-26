package familyTree;

import familyTree.saving.SaveAndLoad;
import familyTree.saving.Serial;

public class MainRestored {
    public static void main(String[] args) {
        SaveAndLoad saveLoad = new Serial();
        ServiceForTree workRestored = saveLoad.loadingWork("familyTree.ser");
        System.out.println(workRestored.getAllInfo());
    }
}
