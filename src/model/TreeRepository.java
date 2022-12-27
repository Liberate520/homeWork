package model;


public class TreeRepository implements Repository{
    private GenealogicalTree<TreeElement> tree;


    public void newTree(){
        tree = new Tree<>();
    }
    public void printElement(String name) {
        System.out.println(tree.findElement(name));
    }
    public void printTree(){
        System.out.println(tree);
    }
}
