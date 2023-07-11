package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> allPersons;
    private Person peakMother;
    private Person peakFather;

    // constructors
    public FamilyTree() {
        allPersons = new ArrayList<>();
    }

    public FamilyTree(Person person) {
        allPersons = new ArrayList<>();
        allPersons.add(person);
    }

    public void addPerson(Person person) {
        if (allPersons == null) {
            allPersons = new ArrayList<>();
        }
        allPersons.add(person);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person:allPersons) {
            sb.append(String.format("%s \n", person));
        }
        return sb.toString();
    }

    public void setPeak(String name) {
        for (Person person : allPersons) {
            if (person.getName().equalsIgnoreCase(name))
                if (person.getGender()== Gender.Female) {
                    this.peakMother = person;
                } else {
                    this.peakFather = person;
                }
        }
    }

    public Person getPeakMother() {
        return peakMother;
    }

    public Person getPeakFather() {
        return peakFather;
    }

    public Person getPersonByName(String name) {
        for (Person personAtList:this.allPersons) {
            if (personAtList.getName().equalsIgnoreCase(name)){
                return personAtList;
            }
        }
        return null;
    }
}
