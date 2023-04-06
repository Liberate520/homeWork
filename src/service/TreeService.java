
package service;

import java.io.IOException;

import file.OutInput;
import file.Slfamailytree;
import human.Human;
import tree.FamilyTree;
import tree.Sorts;
import tree.Tree;

public class TreeService<E extends Human> implements Service<E> {

    @Override
    public Tree<E> get(int n, String st) throws ClassNotFoundException, IOException {

        Tree<E> famailytree = new FamilyTree<>();
        OutInput<E> saveload = new Slfamailytree<>();
        famailytree = (Tree<E>) saveload.load();
        Sorts<E> sorts = new Sorts<>(famailytree);
        switch (n) {
            case 1:
                E humanf = famailytree.findHuman(st);
                if (humanf == null) {
                    System.out.printf("Человека с именем %s в этом фамильном дереве нет.\n", st);
                } else {
                    System.out.println(humanf);
                }
                return famailytree;
            case 2:
                sorts.SortbyName();
                return famailytree;
            case 3:
                sorts.SortbyBirthyear();
                return famailytree;
            case 4:
                sorts.SortbyChild();
                return famailytree;
            case 5:
                sorts.SortbyId();
                return famailytree;
            default:
                return famailytree;
        }
    }
}
