package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Person> personList;

    public FamilyTree(List<Person> personList) {
        this.personList = personList;
    }
    public FamilyTree() { this(new ArrayList<>()); }

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
        for(Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public String getFamilyTree() {
        StringBuilder sb = new StringBuilder();
        for (Person person : personList) {
            sb.append(person.getPersonInfo());
            sb.append("\n");
        }
        return sb.toString();
    }


}
