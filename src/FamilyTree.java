import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<ObjectResearcheble> mainTree;

    public FamilyTree() {
        mainTree = new ArrayList<>();
    }

    public void addHuman(Human arg){
        mainTree.add(arg);
    }


    public List<ObjectResearcheble> getMainTree() {
        return mainTree;
    }
}
