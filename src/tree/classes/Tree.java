package tree.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import filesystem.classes.SaveRestore;
import filesystem.interfaces.SaveLoad;
import sorting.classes.TreeIterator;
import tree.interfaces.iTree;


public class Tree<E> implements SaveLoad<E>, Iterable<E>, iTree<E> {
    private List<E> persons = new ArrayList<>();

    @Override
    public List<E> getTree(){
        return persons;
    }

    @Override
    public void addPerson(E person) {
        persons.add(person);
    }

    @Override
    public void save(iTree<E> treeToSave, String path) {
        SaveRestore<E> saving = new SaveRestore<E>();
        saving.save(treeToSave, path);
    }

    @Override
    public iTree<E> load(String path) {
        SaveRestore<E> loading = new SaveRestore<E>();
        return loading.load(path);
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<E>(persons);
    }
}
