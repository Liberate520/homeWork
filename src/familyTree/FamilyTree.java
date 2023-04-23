package familyTree;

import human.Gender;
import human.Human;
import human.comparators.HumanComparatorByFirstName;
import human.comparators.HumanComparatorById;
import human.comparators.HumanComparatorByLastName;
import human.comparators.HumanComparatorByNumberOfChildren;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> people = new ArrayList<>();

    public void addHuman(E human){
        people.add(human);
        Optional <E> mother = Optional.ofNullable((E) human.getMother());
        Optional <E> father = Optional.ofNullable((E) human.getFather());
        mother.ifPresent(this::IdentifyChildren);
        father.ifPresent(this::IdentifyChildren);
    }

    public E getHuman(String firstName, String lastName, String birthday){
        for (E human: people
        ) {
            if (human.getFirstName().equals(firstName) &&
                    human.getLastName().equals(lastName) &&
                    human.getBirthday().equals(birthday)){
                return human;
            }
        }
        return null;
    }

    public E getHumanById(int id){
        for (E human: people) {
            if (human.getId() == (id)){
                return human;
            }
        }
        return null;
    }

    public E getMother(E human){
        return (E) human.getMother();
    }

    public E getFather(E human){
        return (E) human.getFather();
    }

    public List<E> getBrothers(E human){
        List<E> brothers = new ArrayList<>();
        E mother = (E) human.getMother();
        E father = (E) human.getFather();
        for (E item: people
             ) {
            if (item != human && item.getMother() == mother &&
                    item.getFather() == father &&
                    item.getGender() == Gender.Male){
                brothers.add(item);
            }
        }
        return brothers;
    }

    public List<E> getSisters(E human){
        List<E> sisters = new ArrayList<>();
        E mother = (E) human.getMother();
        E father = (E) human.getFather();
        for (E item: people
        ) {
            if (item != human && item.getMother() == mother &&
                    item.getFather() == father &&
                    item.getGender() == Gender.Female){
                sisters.add(item);
            }
        }
        return sisters;
    }
    public String getPeople(){
        StringBuilder sb = new StringBuilder();
        for (E human: people) {
            sb.append(human.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    public List<E> getTree(){
        return people;
    }
    public void setTree(List<E> readData){
        people = readData;
    }

    @Override
    public Iterator<E> iterator() {
        return people.iterator();
    }
    public void sortByFirstName(){
        people.sort(new HumanComparatorByFirstName());
    }
    public void sortByLastName(){
        people.sort(new HumanComparatorByLastName());
    }
    public void sortById(){
        people.sort(new HumanComparatorById());
    }
    public void sortByNumberOfChildren(){
        people.sort(new HumanComparatorByNumberOfChildren());
    }

    public void IdentifyChildren(E human){
        for (E item: people
        ) {
            if (!human.equals(item) && human.equals(item.getMother()) ||
                    human.equals(item.getFather())){
                human.setChildren((E) item);
            }
        }
    }
}
