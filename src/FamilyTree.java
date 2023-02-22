import java.util.*;
import java.io.Serializable;


public class FamilyTree implements Serializable, Iterable {
    private List<Person> personList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Person> personList) {
        this.personList = personList;
    }

    public boolean add(Person person) {
        if (person == null) {
            return false;
        }
        if (!personList.contains(person)) {
            personList.add(person);
            if (person.getFather() != null) {
                person.getFather().addChild(person);
            }
            if (person.getMother() != null) {
                person.getMother().addChild(person);
            }
            return true;
        }
        return false;
    }

    public Person getByName(String name) {
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }



    public String getInfo(){
        StringBuilder res = new StringBuilder();
        res.append(personList.size());
        res.append(" objects in the tree: \n");
        for (Person person : personList){
            res.append(person.getInfo());
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(personList);
    }

    public void sortByName() {
        Collections.sort(personList, new PersonComparatorByName());
    }

    public void sortByBirthDate() {
        Collections.sort(personList, new PersonComparatorByBirth());
    }
}


