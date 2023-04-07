package tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import person.Person;
import person.PersonComparatorByBirthDate;
import person.PersonComparatorById;
import person.PersonIterator;

public class FamilyTree implements Serializable, Iterable<Person> {
    private final List<Person> familyTree;

    public FamilyTree(List<Person> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void add(Person human) {
        this.familyTree.add(human);
    }

    @Override
    public String toString() {
        for (Person item : familyTree) {
            System.out.println(item);
        }
        return " ";
    }

    public void parentsHuman(Person human) {
        Person mather = null;
        Person father = null;
        for (Person item : familyTree) {
            if (item.getId() == human.getIdMather()) mather = item;
            if (item.getId() == human.getIdFather()) father = item;
        }
        System.out.printf("Исследуемый объект:\n%s\nМать - %s\nОтец - %s", human, mather, father);
    }

    public void childrensHuman(Person human) {
        List<Person> childrens = new ArrayList<>();
        for (Person item : familyTree) {
            if (item.getIdFather() == human.getId() || item.getIdMather() == human.getId()) {
                childrens.add(item);
            }
        }
        if (childrens.size() > 0) {
            System.out.printf("\nИсследуемый объект:\n%s\nДети объекта:\n", human);
            for (Person item : childrens) System.out.print(item);
        } else System.out.printf("\nИсследуемый объект:\n%s\nДетей нет", human);
    }
    @Override
    public Iterator<Person> iterator() {

        return new PersonIterator(familyTree);
    }

    public void sortByID() {
        familyTree.sort( new PersonComparatorById());
    }

    public void sortByBirthDate() {
        familyTree.sort( new PersonComparatorByBirthDate());
    }

}