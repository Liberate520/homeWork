package FamilyTree.tree;

import FamilyTree.person.Person;
import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends TreeItem> implements Serializable{
    private List<T> personList;

    public FamilyTree(List<T> personList) {
        this.personList = personList;
    }
    public FamilyTree() { this(new ArrayList<>()); }

    public boolean add(T person) {
        if (person == null) {
            System.out.println("null");
            return false;
        }
        if (!personList.contains(person)) {
            personList.add(person);
            System.out.println("add");
            System.out.println(person);
            System.out.println(personList);
            if (person.getFather() != null) {
                person.getFather().addChild((Person) person);
            }
            if (person.getMother() != null) {
                person.getMother().addChild((Person) person);
            }
            return true;
        }
        return false;
    }

    public T getByName(String name) {
        for(T person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public String getFamilyTree() {
        StringBuilder sb = new StringBuilder();
        for (T person : personList) {
            sb.append(person.getPersonInfo());
            sb.append("\n");
        }
        return sb.toString();
    }


}
