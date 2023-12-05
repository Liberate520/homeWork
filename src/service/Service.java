package service;


import creatures.Creature;

public class Service<T> {
    private static Creature treeTop;

    public Service() {
    }

    public static void setTreeTop(Creature treeTop) {
        Service.treeTop = treeTop;
    }

    public Creature getTreeTop() {
        return treeTop;


    }
}
