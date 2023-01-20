import java.io.Serializable;
import java.util.List;

public class InputOutputList<T extends LiveBeing<T>> {

    public InputOutputList() {

    }

    public void saveToBin(FamilyTree<T> familyTree, String filePath) {
        InputOutputBin saveInBin = new InputOutputBin();
        saveInBin.saveAs(familyTree, filePath);
    }

    public List<T> loadFromBin(String filePath) {
        InputOutputBin loadFromBin = new InputOutputBin();
        Serializable restore = loadFromBin.readFrom(filePath);
        FamilyTree<T> restoreFamilyTree = (FamilyTree) restore;
        List<T> list = restoreFamilyTree.getLiveBeings();
        System.out.println(list);
        return list;
    }
}
