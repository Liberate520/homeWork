import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<Person> people = new ArrayList();

    public void addPerson(Person person) {
        people.add(person);
    }

    public void addSpouse(Person spouse1, Person spouse2) {
        for (Person person : this.people) {
            if (person == spouse1) {person.addSpouse(spouse2);};
            if (person == spouse2) {person.addSpouse(spouse1);};
        }
    }

    public void addChildrens(Person spouse1, Person spouse2, Person child) {
        for (Person person : this.people) {
            if (person == spouse1 || person == spouse2) {
                person.addChildren(child);
            }
        }
    }

    public void printFamilyTree() {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public void manageParents() {
        for (Person person : this.people) {
            if (person.getChildrens() != null) {
                for (Person child : person.getChildrens()) {
                    child.addParent(person);
                }
            }
        }
    }

}