package Model;

import java.io.*;
import java.util.*;

public class FamilyTreeModel implements Iterable<Human> {
    private List<Human> humanList;
    private DataIO dataIO;

    public FamilyTreeModel() {
        humanList = new ArrayList<>();
        dataIO = new FileDataIO();
    }

    public void addHuman(String name, int yearOfBirth, String gender) {
        Human human = new Human(name, yearOfBirth, gender);
        humanList.add(human);
    }

    public List<Human> getHumanByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public List<Human> getAllHuman() {
        return new ArrayList<>(humanList);
    }

    public void sortByBirthDate() {
        Collections.sort(humanList, Comparator.comparing(Human::getYearOfBirth));
    }

    public void sortByName() {
        Collections.sort(humanList, Comparator.comparing(Human::getName));
    }

    public void saveToFile(String fileName) throws IOException {
        dataIO.saveToFile(humanList, fileName);
    }

    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        humanList = dataIO.loadFromFile(fileName);
    }
    public Iterator<Human> iterator() {
        return humanList.iterator();
    }
}
