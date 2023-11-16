package fam_tree;

public class Dogs<T>{
    private T tree;

    public Dogs(T tree) {
        this.tree = tree;
    }

    public T getTree() {
        return tree;
    }

    public void setTree(T tree) {
        this.tree = tree;
    }
}
