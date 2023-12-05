package service;



public class Service<T> {
    private static family_tree.Creature treeTop;

    public Service() {
    }

    public static void setTreeTop(family_tree.Creature treeTop) {
        Service.treeTop = treeTop;
    }

    public family_tree.Creature<T> getTreeTop() {
        return treeTop;


    }
}
