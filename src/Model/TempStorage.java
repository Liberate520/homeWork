package Model;

import Model.tree.*;

public class TempStorage {
    private Container<Cat> catContainer;
    private Container<Human> humanContainer;
    private Container<FamilyTree<Cat>> catTreeContainer;
    private Container<FamilyTree<Human>> humanTreeContainer;

    public TempStorage() {
        this.catContainer = new Container<>();
        this.humanContainer = new Container<>();
        this.catTreeContainer = new Container<>();
        this.humanTreeContainer = new Container<>();
    }

    public Container<Cat> getCatContainer() {
        return catContainer;
    }

    public Container<Human> getHumanContainer() {
        return humanContainer;
    }

    public Container<FamilyTree<Cat>> getCatTreeContainer() {
        return catTreeContainer;
    }

    @Override
    public String toString() {
        StringBuilder storage = new StringBuilder();
        storage.append(getCatContainer()).append(getHumanContainer()).
                append(getHumanTreeContainer()).append(getCatTreeContainer());

        return storage.toString();
    }

    public Container<FamilyTree<Human>> getHumanTreeContainer() {
        return humanTreeContainer;
    }
}
