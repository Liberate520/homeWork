package family_tree;

import person.Gender;
import person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {
    private int personsId;
    private List<Person> familyTree = new ArrayList<>();

    public boolean add(Person person) {
        if (person == null) return false;
        if (!familyTree.contains(person)) {
            familyTree.add(person);
            person.setId(personsId++);

            addToParents(person);
            addToChildren(person);

            return true;
        }
        return false;
    }

    private void addToParents(Person person) {
        Person father = person.getFather();
        if (father != null) father.addChildren(person);
        Person mother = person.getMother();
        if (mother != null) mother.addChildren(person);
    }

    private void addToChildren(Person person) {
        for (Person child : person.getChildren()) {
            if (person.getGender() == Gender.Male)
                child.addFather(person);
            else child.addMother(person);
        }
    }

    public void sortByName(){
        familyTree.sort(new PersonComparatorByName());
    }

    public void sortByAge(){
        familyTree.sort(new PersonComparatorByAge());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person person : familyTree) {
            result.append(person).append("\n");
        }
        return result.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(familyTree);
    }

}
