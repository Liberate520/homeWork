package tree.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import filesystem.classes.SaveRestore;
import filesystem.interfaces.SaveLoad;
import sorting.classes.TreeIterator;
import tree.interfaces.iTree;


public class Tree implements SaveLoad, Iterable<Human>, iTree {
    private List<Human> persons = new ArrayList<>();

    @Override
    public List<Human> getTree(){
        return persons;
    }

    @Override
    public void addPerson(Human person) {
        persons.add(person);
    }

    //@Override
    @Override
    public void save(iTree treeToSave, String path) {
        SaveRestore saving = new SaveRestore();
        saving.save(treeToSave, path);
        //throw new UnsupportedOperationException("Unimplemented method 'Save'");
    }

    //@Override
    @Override
    public iTree load(String path) {
        SaveRestore loading = new SaveRestore();
        return loading.load(path);
        //throw new UnsupportedOperationException("Unimplemented method 'Load'");
    }

    @Override
    public Iterator<Human> iterator() {
        return new TreeIterator(persons);
    }
}
