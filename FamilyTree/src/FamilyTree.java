import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable, Iterable<Person> {
//    private List<T> children = new ArrayList<>();
    private List<T> personList;

    private Writable writable;

    public FamilyTree(List<T> personList) {
        this.personList = personList;
    }

    public FamilyTree() {
        this(new ArrayList());
        this.writable = new FileHandler();
    }

    public void setPersonList(List<T> personList) {
        this.personList = personList;
    }

    public List<T> getPersonList() {
        return personList;
    }

    public void addPerson(T person) {
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





    public void setWriter(Writable writer) {
        this.writable = writable;
    }

    public void save() {
        if (writable != null)
            writable.save(this);
    }

    public FamilyTree load() {
        if (writable != null) {
            FamilyTree loadTree = writable.read();
            if (loadTree != null)
                this.setPersonList(loadTree.getPersonList());
            return (FamilyTree) writable.read();
        }
        return null;
    }


    @Override
    public Iterator<Person> iterator() {
    return new PersonIterator<T>(personList);
}


    public void sortByName(){
        Collections.sort(getPersonList());
    }

    public void sortByAge(){
        Collections.sort(getPersonList(), new PersonComparatorByAge());
    }



}



