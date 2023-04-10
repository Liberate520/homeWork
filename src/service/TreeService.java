
package service;

import java.io.IOException;

import file.OutInput;
import file.Slfamailytree;
import human.Human;
import tree.Sorts;
import tree.Tree;

public class TreeService<E extends Human> implements Service<E> {
    private Tree<E> familytree;
    private OutInput saveload;
    private Sorts<E> sort;
    
    public TreeService() throws ClassNotFoundException, IOException {
        this.saveload = new Slfamailytree();
        this.familytree = (Tree<E>) saveload.load();
        this.sort = new Sorts<>(this.familytree);
    }
    @Override
    public E find(String st) throws ClassNotFoundException, IOException {
        E humanf = familytree.findHuman(st);
        return humanf;
    }
    @Override
    public Tree<E> sortname() {
        sort.sortbyName();
        return familytree;
    }

    @Override
    public Tree<E> sortbirthyear() {
        sort.sortbyBirthyear();
        return familytree;
    }
    @Override
    public Tree<E> sortchild() {
        sort.sortbyChild();
        return familytree;
    }
    @Override
    public Tree<E> sortid() {
        sort.sortbyId();
        return familytree;
    }
    @Override
    public Tree<E> addhuman(E h, E mh, E fh) {
        familytree.addpeople(h, mh, fh);
        return familytree;
    }
}
