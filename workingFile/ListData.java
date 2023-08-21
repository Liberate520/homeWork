package workingFile;

import tree.Node;

import java.util.ArrayList;

public class ListData implements WorkingFile {

    private ArrayList<Node> base;

    public ListData() {
        this.base = new ArrayList<>();
    }


    public void add(Node n) {
        this.base.add(n);

    }

    @Override
    public void remove(Node ob) {
    }

    @Override
    public int getInd(Node ob) {
        return 0;
    }

    @Override
    public Node get(int index) {
        return null;
    }

    @Override
    public void change(Node obOld, Node obNew) {
    }

    @Override
    public int getSize() {
        return 0;
    }


}