package Model;

import Model.tree.*;

import java.util.ArrayList;
import java.util.List;

public class TempStorage {
    Container<Cat> catContainer;
    Container<Human> humanContainer;
    Container<FamilyTree> treeContainer;

    public TempStorage() {
        this.catContainer = new Container<>();
        this.humanContainer = new Container<>();
        this.treeContainer = new Container<>();
    }

    public Container<Cat> getCatContainer() {
        return catContainer;
    }

    public Container<Human> getHumanContainer() {
        return humanContainer;
    }

    public Container<FamilyTree> getTreeContainer() {
        return treeContainer;
    }

    @Override
    public String toString() {
        StringBuilder storage = new StringBuilder();
        storage.append(getCatContainer()).append(getHumanContainer()).append(getHumanContainer());

        return "\nВо временном хранилище:\n" + storage;
    }
}
