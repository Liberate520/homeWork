package model.tree.classes;

import java.util.List;

import model.filesystem.classes.SaveRestore;

public class Service {
    private Tree tree;
    private SearchPerson search;
    private SetHuman setHuman;

    public void save(String path) {
        SaveRestore<Human> saving = new SaveRestore<Human>();
        saving.save(tree.getTree(), path);
    }

    public void load(String path) {
        SaveRestore<Human> loading = new SaveRestore<Human>();
        tree.setTree(loading.load(path));
    }

    public Service() {
        tree = new Tree<Human>();
    }

    public List<Human> getTree() {
        return tree.getTree();
    }

    public void setHuman() {
        setHuman = new SetHuman(tree);
        setHuman.settingHuman();
    }

    public void addPerson(Human person) {
        tree.addPerson(person);
    }

    public void serachPerson() {
        search = new SearchPerson(tree);
        search.printSearched();
    }

    public String treeToString() {
        return tree.treeToString();
    }
}
