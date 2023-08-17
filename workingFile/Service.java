package workingFile;

import tree.Compilation;
import tree.Node;

public class Service {

    private LoadFromFile writable;
    private Node activeTree;


    public Service(LoadFromFile writable, Node activeTree) {
        this.writable = writable;
        this.activeTree = activeTree;
    }

    String filePath = "tree.out";
    ;

    public Service() {
        activeTree = new Node();
    }


    public void save(Compilation gt) {
        if (writable == null) {
            return;
        }
        writable.save(activeTree, filePath);
    }

    public void load(Compilation com) {
        if (writable == null) {
            return;
        }

        activeTree = (Node) writable.read(filePath);
    }


    public void setWritable(SaveToFile writable) {
        this.writable = (LoadFromFile) writable;
    }


}
