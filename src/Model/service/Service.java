package Model.service;

import Model.FamilyTree;
import Model.service.Filehandlers.Writable;
import Model.units.Gender;
import Model.units.Human;
import Model.units.Unit;

import java.io.IOException;

public class Service<T extends Unit>{
    private Writable fh;
    private FamilyTree<T> tree;

    public Service(FamilyTree<T> tree, Writable fh) {
        this.tree = tree;
        this.fh = fh;
    }

    public void save(String path, FamilyTree<T> tree) throws IOException {
        fh.save(tree, path);
    }

    public void addHuman(String firstName, String secondName, Gender gender,
                         int birthday, int birthmonth, int birthyear) {
        Human human = new Human(firstName, secondName, gender, birthday,
                                birthmonth, birthyear);
        tree.add((T) human);

    }


}
