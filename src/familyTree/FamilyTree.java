package familyTree;

import human.Gender;
import human.Human;
import human.comparators.HumanComparatorByFirstName;
import human.comparators.HumanComparatorById;
import human.comparators.HumanComparatorByLastName;
import human.comparators.HumanComparatorByNumberOfChildren;
import readWrite.ReadWriteData;
import readWrite.ReadWriteObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> people = new ArrayList<>();

    public void addHuman(Human human){
        people.add(human);
        Optional <Human> mother = Optional.ofNullable(human.getMother());
        Optional <Human> father = Optional.ofNullable(human.getFather());
        mother.ifPresent(this::IdentifyChildren);
        father.ifPresent(this::IdentifyChildren);
    }

    public Human getHuman(String firstName, String lastName, String birthday){
        for (Human human: people
        ) {
            if (human.getFirstName().equals(firstName) &&
                    human.getLastName().equals(lastName) &&
                    human.getBirthday().equals(birthday)){
                return human;
            }
        }
        return null;
    }

    public Human getHumanById(int id){
        for (Human human: people) {
            if (human.getId() == (id)){
                return human;
            }
        }
        return null;
    }

    public Human getMother(Human human){
        return human.getMother();
    }

    public Human getFather(Human human){
        return human.getFather();
    }

    public List<Human> getBrothers(Human human){
        List<Human> brothers = new ArrayList<>();
        Human mother = human.getMother();
        Human father = human.getFather();
        for (Human item: people
             ) {
            if (item != human && item.getMother() == mother &&
                    item.getFather() == father &&
                    item.getGender() == Gender.Male){
                brothers.add(item);
            }
        }
        return brothers;
    }

    public List<Human> getSisters(Human human){
        List<Human> sisters = new ArrayList<>();
        Human mother = human.getMother();
        Human father = human.getFather();
        for (Human item: people
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
        for (Human human: people) {
            sb.append(human.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void saveToFile(String fileName){
        ReadWriteData rw = new ReadWriteObject();
        try {
            rw.writeData(people,fileName);
            System.out.println("Данные записаны в файл " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile(String fileName){
        ReadWriteData rw = new ReadWriteObject();
        try {
            people = rw.readData(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Iterator<Human> iterator() {
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

    public void IdentifyChildren(Human human){
        for (Human item: people
        ) {
            if (item != human && item.getMother() == human ||
                    item.getFather() == human){
                human.setChildren(item);
            }
        }
    }
}
