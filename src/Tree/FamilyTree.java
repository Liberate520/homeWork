package Tree;

import Data.DataRepository;
import People.Person;
import People.Repository;
import People.TreeElements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Person> extends DataRepository implements
        Serializable, Repository, Iterable<Person>, TreeElements {
    public List<E> targariens;

    public FamilyTree(List<E> targariens) {
        this.targariens = targariens;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }
//    Не удалось сделать метод VOID.
    public boolean addPerson(E person){
        if (person == null){
            return false;
        }
        if (!targariens.contains(person)){
            targariens.add(person);
            if (person.getFather() != null){
                person.getFather().addDescendants(person);
            }
            if (person.getMother() != null) {
                person.getMother().addDescendants(person);
            }
            return true;
        }
        return false;
    }

    public List<E> searchPerson(String firstName){
        List<E> searched = new ArrayList<>();
        for (E item:targariens) {
            if (item.getFirstName().equals(firstName)){
                searched.add(item);
            }
        }
        return searched;
    }

    public List<String> searchPersonDescendance(String firstName){
        List<String> searched = new ArrayList<>();
        for (E item: targariens) {
            if (item.getFirstName().equals(firstName)){
                searched.add(item.getDescendantInfo());
            }
        }
        return searched;
    }

    public String getTreeInfo(){
        StringBuilder tree = new StringBuilder();
        for (E ppl:targariens) {
            tree.append(ppl.getInfo());
            tree.append("\n");
        }
        return tree.toString();
    }

    public List<E> getFamilyTree(){
        return targariens;
    }
    @Override
    public Iterator<Person> iterator() {
        return new TreeIterator(targariens);
    }
}
