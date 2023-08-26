package workingFile;

import tree.Node;

import java.util.ArrayList;

public abstract class ListData {

    private ArrayList<Node> base;

    public ListData() {
        this.base = new ArrayList<>();
    }


    public void add(Node n) {
        this.base.add(n);

    }


    public abstract String load(String file);

    public abstract void remove(Node ob);

    public abstract int get(int index);

    public abstract int getInd(Node ob);

    public abstract void change(Node obOld, Node obNew);

    public abstract int getSize();
}