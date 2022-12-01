import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<ObjectResearcheble> {
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

    @Override
    public Iterator<ObjectResearcheble> iterator() {
        return mainTree.iterator();
    }
}


