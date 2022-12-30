import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> children = new ArrayList<>();
    private List<Person> personList;

    private Writable writable;

    public FamilyTree(List<Person> personList) {
        this.personList = personList;
    }

    public FamilyTree() {
        this(new ArrayList());
        this.writable = new FileHandler();
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }



    public List<Person> getPersonByName(String name) {
        List<Person> res = new ArrayList();
        Iterator x = this.personList.iterator();
        while (x.hasNext()) {
            Person person = (Person) x.next();
            if (person.getName().equals(name)) {
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



    public void setWritable(Writable writable) {
        this.writable = writable;
    }


    public void saveFamilyTree() {
        writable.save(this);
    }


    public void setWriter(Writable writer) {
        this.writable = writable;
    }

    public void save() {
        if (writable != null)
            writable.save(this);
    }

    public void load() {
        if (writable != null) {
            FamilyTree loadTree = writable.read();
            if (loadTree != null)
                this.setPersonList(loadTree.getPersonList());
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(personList);
    }

    public void sortByName(){
        Collections.sort(getPersonList());
    }

    public void sortByAge(){
        Collections.sort(getPersonList(), new PersonComparatorByAge());
    }


}



