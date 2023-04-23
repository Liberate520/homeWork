package model.Tree;

import model.People.Person;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends TreeInterface> implements Serializable, Iterable<E> {
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
                person.getFather().addDescendants((Person) person);
            }
            if (person.getMother() != null) {
                person.getMother().addDescendants((Person) person);
            }
            return true;
        }
        return false;
    }

    public List<String> searchPerson(String name){

        List<String> searched = new ArrayList<>();
        for (E item:targariens) {
            if (item.getFirstName().equals(name)){
                searched.add(item.getInfo());
            }
        }
        return Collections.singletonList(searched.toString());
    }

    public List<String> searchPersonDescendance(String nameOfAsc){

        List<String> searched = new ArrayList<>();
        for (E item: targariens) {
            if (item.getFirstName().equals(nameOfAsc)){
                searched.add(item.getDescendantInfo().toString());
            }
        }
        return Collections.singletonList(searched.toString());
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
    public Iterator<E> iterator() {
        return new TreeIterator(targariens);
    }
}
