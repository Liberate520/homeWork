package FamilyTree;

import FamilyTree.person.Person;
import FamilyTree.person.comparators.PersonComparatorByName;
import FamilyTree.tree.FamilyTree;
import FamilyTree.tree.PersonIterator;

import java.util.Iterator;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree<Person> familyTree;

    public Service(FamilyTree tree) {
        this.familyTree = tree;
    }

    public Service() {
        this(new FamilyTree());
    }

    public void addPerson(Person person) {
        familyTree.add(person);
    }

    public Person getByName(String name) {
        for(Person person : familyTree) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public String getFamilyTreeInfo() {

//        StringBuilder stringBuilder = new StringBuilder();
//
////        Iterator<Person> iterator = new familyTree.iterator();
////        while (iterator.hasNext()) {
////            Person person = iterator.next();
////            stringBuilder.append(person).append("\n");
////        }
//
//        for (Person person : familyTree) {
//            stringBuilder.append(person).append("\n");
//        }
//        return stringBuilder.toString();

        return familyTree.getFamilyTree();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

}
