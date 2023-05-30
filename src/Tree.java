import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Person> personList;

    public Tree() {
        personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
        if (person.getFather() != null) {
            person.getFather().addChild(person);
        }
        if (person.getMother() != null) {
            person.getMother().addChild(person);
        }
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person findPersonByName(String name) {
        for (Person item : personList) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public List<Person> findSiblings(Person person) {
        List<Person> siblingsList = new ArrayList<>();
        List<Person> tempList = new ArrayList<>();
        tempList.add(person);
        siblingsList = person.getMother().getChildren();
        siblingsList.removeAll(person.getFather().getChildren());
        siblingsList.addAll(person.getFather().getChildren());
        siblingsList.removeAll(tempList);
        return siblingsList;
    }
}