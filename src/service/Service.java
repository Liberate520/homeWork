package service;

import family_tree.Human;

public class Service {
    private static Human treeTop;

    public Service() {
    }

    public static void setTreeTop(Human treeTop) {
        Service.treeTop = treeTop;
    }

    public Human getTreeTop() {
        return treeTop;


    }
}
