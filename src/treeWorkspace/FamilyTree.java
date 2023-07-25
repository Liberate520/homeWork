package treeWorkspace;


import treeComparators.ComparatorByAge;
import treeComparators.ComparatorByGender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person>{
    // Класс для хранения и обработки списка людей в семейном дереве
    private List<Person> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addPerson(Person person) {
        familyTree.add(person);
    }
    public Person getPerson(int id) {
        for (Person p:familyTree){
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }
    public void sortByName(){
        Collections.sort(familyTree);
    }
    public void sortByAge(){
        Collections.sort(familyTree,new ComparatorByAge());
    }
    public void sortByGender(){
        Collections.sort(familyTree,new ComparatorByGender());
    }

    @Override
    public Iterator<Person> iterator() {
        return familyTree.iterator();
    }

}
