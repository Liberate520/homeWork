
package service;

import java.io.FileNotFoundException;
import java.io.IOException;

import file.OutInput;
import file.Slfamailytree;
import human.Human;
import tree.Sorts;
import tree.Tree;

public class TreeService implements Service {
    private Tree<Human> familytree;
    private Sorts<Human> sort;
    private OutInput saveload;

    public TreeService(Tree<Human> familytree) {
        this.familytree = familytree;
        this.sort = new Sorts<Human>(this.familytree);
        this.saveload = new Slfamailytree();
    }

    @Override
    public Human find(String st) {
        return familytree.findHuman(st);
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
    public boolean addhuman(String str) {
       // familytree.addpeople(str);
        return familytree.addpeople(str);
    }

    @Override
    public Tree<Human> showtr() {
        return familytree;
    }

    @Override
    public void savetree() throws FileNotFoundException, IOException {
        saveload.save(this.familytree);
    }
}
