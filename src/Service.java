import HumanComparators.HumanComparatorById;
import HumanComparators.HumanComporatorByName;
import HumanComparators.HumanComporatorBySurname;
import familyTree.FamilyTree;
import fileWorker.FileWorker;

public class Service {

    private FamilyTree tree;
    private FileWorker fileWorker;
    public Service(FamilyTree tree) {
        this.tree = tree;
    }

    public void save(FileWorker fileWorker, String filename) {
        this.fileWorker = fileWorker;
        fileWorker.save(tree, filename);
    }
    
    public void readFromfile(String filename){
        this.fileWorker.readFromfile(filename);
    }
    

    public void sortById() {
        tree.getFamilyTreeList().sort(new HumanComparatorById());
    }

    public void sortByName() {
        tree.getFamilyTreeList().sort(new HumanComporatorByName());
    }

    public void sortBySurName() {
        tree.getFamilyTreeList().sort(new HumanComporatorBySurname());
    }
    

}
