package model.tree.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.filesystem.classes.SaveRestore;
import model.sorting.classes.TreeIterator;
import model.tree.interfaces.iTree;


public class Tree<E> implements Iterable<E>, iTree<E> {
    private List<E> persons = new ArrayList<>();

    @Override
    public List<E> getTree(){
        return persons;
    }


    @Override
    public void addPerson(E person) {
        
        if(person instanceof Human){
            Human personHuman = (Human)person;
            if (personHuman.getFather() != null){
                personHuman.getFather().addChildren(personHuman);
            }
            if (personHuman.getMother() != null){
                personHuman.getMother().addChildren(personHuman);
            }
        }
        persons.add(person);
    }

    @Override
    public List<E> searchPerson(String str) {
        List<E> personsMatched = new ArrayList<>();
        for (E e : persons) {
            if (e.toString().toLowerCase().contains(str.toLowerCase())){
                personsMatched.add(e);
            }
        }
        return personsMatched;
    }


   
    public void save(String path) {
        SaveRestore<E> saving = new SaveRestore<E>();
        saving.save(persons, path);
    }

    
    public void load(String path) {
        SaveRestore<E> loading = new SaveRestore<E>();
        persons = loading.load(path);       
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<E>(persons);
    }

    @Override
    public String treeToString() {
        StringBuilder sb = new StringBuilder();
        for (E person : persons) {
            sb.append(person.toString() + "\n");           
        }
        return sb.toString();
    }



}
