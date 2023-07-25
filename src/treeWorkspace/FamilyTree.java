package treeWorkspace;


import java.io.Serializable;
import java.util.ArrayList;
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
    @Override
    public Iterator<Person> iterator() {
        return familyTree.iterator();
    }
}
