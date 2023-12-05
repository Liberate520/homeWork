package service;

import family_tree.Human;

public class Service<Creature> {
    private static family_tree.Creature treeTop;

    public Service() {
    }

    public static void setTreeTop(family_tree.Creature treeTop) {
        Service.treeTop = treeTop;
    }

    public Human getTreeTop() {
        return (Human) treeTop;


    }
}
