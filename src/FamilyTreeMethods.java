import java.util.List;

public class FamilyTreeMethods<T extends LiveBeing<T>> {
    private FamilyTree<T> familyTree;

    public FamilyTreeMethods(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public List<T> getLiveBeingsList() {
        return this.familyTree.getLiveBeings();
    }

    public void setLiveBeingsList(List<T> familyTreeList) {
        this.familyTree.setLiveBeings(familyTreeList);
    }

    public void clearLiveBeingsList() {
        this.familyTree.getLiveBeings().clear();
    }

    public T getLiveBeing(int index) {
        return this.familyTree.getLiveBeings().get(index);
    }

    public void addLiveBeing(T liveBeing, T father, T mother) {
        this.familyTree.addLiveBeing(liveBeing, father, mother);
    }

    public void showAllInConsole() {
        this.familyTree.showAllInConsole();
    }

    public T findByName(String name) {
        return this.familyTree.findByName(name);
    }

    public List<T> findAllByName(String name) {
        return this.familyTree.findAllByName(name);
    }

    public void sortByName() {
        this.familyTree.sortByName();
    }

    public void sortByDate() {
        this.familyTree.sortByDate();
    }
}
