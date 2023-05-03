package familyTree;

import human.Gender;
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
        Optional <FamilyTreeItem> mother = Optional.ofNullable(human.getMother());
        Optional <FamilyTreeItem> father = Optional.ofNullable(human.getFather());
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

    public FamilyTreeItem getMother(E human){
        return human.getMother();
    }

    public FamilyTreeItem getFather(E human){
        return human.getFather();
    }

    public List<E> getBrothers(E human){
        List<E> brothers = new ArrayList<>();
        FamilyTreeItem mother = human.getMother();
        FamilyTreeItem father = human.getFather();
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

    public void IdentifyChildren(FamilyTreeItem human){
        for (FamilyTreeItem item: people
        ) {
            if (!human.equals(item) && human.equals(item.getMother()) ||
                    human.equals(item.getFather())){
                human.setChildren(item);
            }
        }
    }

    public int getLastId() {
        int currentId;
        int maxId = 0;
        for (E person: people) {
            currentId = person.getId();
            if (currentId > maxId){
                maxId = currentId;
            }
        }
        return maxId;
    }
}
