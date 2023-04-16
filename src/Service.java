import HumanComparators.HumanComparatorById;
import HumanComparators.HumanComporatorByName;
import HumanComparators.HumanComporatorBySurname;
import familyTree.Tree;
import fileWorker.FileWorker;

public class Service {

    private Tree tree;
    private FileWorker fileWorker;
    public Service(Tree tree) {
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
        tree.getTreeList().sort(new HumanComparatorById());
    }

    public void sortByName() {
        tree.getTreeList().sort(new HumanComporatorByName());
    }

    public void sortBySurName() {
        tree.getTreeList().sort(new HumanComporatorBySurname());
    }
    

}
