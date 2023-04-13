
package service;

import human.Human;
import tree.Sorts;
import tree.Tree;

public class TreeService implements Service {
    private Tree<Human> familytree;
    private Sorts<Human> sort;

    public TreeService(Tree<Human> familytree) {
        this.familytree = familytree;
        this.sort = new Sorts<Human>(this.familytree);
    }

    @Override
    public Human find(String st) {
        Human humanf = familytree.findHuman(st);
        return humanf;
    }

    @Override
    public Tree<Human> sortname() {
        sort.sortbyName();
        return familytree;
    }

    @Override
    public Tree<Human> sortbirthyear() {
        sort.sortbyBirthyear();
        return familytree;
    }

    @Override
    public Tree<Human> sortchild() {
        sort.sortbyChild();
        return familytree;
    }

    @Override
    public Tree<Human> sortid() {
        sort.sortbyId();
        return familytree;
    }

    @Override
    public Tree<Human> addhuman(String str) {
        familytree.addpeople(str);
        return familytree;
    }

    @Override
    public Tree<Human> showtr() {
        familytree.getPeople();
        return familytree;
    }
}
