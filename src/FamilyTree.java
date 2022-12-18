import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree {
    private List<Person> children = new ArrayList<>();
    private List<Person> personList;

    public FamilyTree(List<Person> personList) {
        this.personList = personList;
    }

    public FamilyTree() {
        this(new ArrayList());
    }


    public void addPerson(Person person) {
        this.personList.add(person);
    }



    public List<Person> getPersonByName(String name) {
        List<Person> res = new ArrayList();
        Iterator x = this.personList.iterator();
        while (x.hasNext()) {
            Person person = (Person) x.next();
            if (person.getName() == (String) name) {
                res.add(person);
            }
        }
        return res;
    }

    public List<Person> getAllPersons() {
        List<Person> res = new ArrayList();
        Iterator x = this.personList.iterator();
        while (x.hasNext()) {
            Person person = (Person) x.next();
            res.add(person);

        }
        return res;
    }



}
