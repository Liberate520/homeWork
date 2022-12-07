import java.util.*;

public class FamilyTree<T extends ObjectResearcheble> implements Iterable<T> {
    private List<T> mainTree;

    public FamilyTree() {
        mainTree = new ArrayList<>();
    }

    public void addHuman(T arg){
        mainTree.add(arg);
    }


    public List<T> getMainTree() {
        return mainTree;
    }

    @Override
    public Iterator<T> iterator() {
        return mainTree.iterator();
    }

//    public void sort(){
//        Collections.sort(mainTree);
//    }
//
    public void sortByCountDegree(){
        Collections.sort(mainTree, new PersonComparatorByCountDegree());
    }
}


