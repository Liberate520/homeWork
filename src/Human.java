import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private String name;
    private String gender;
    private Human father;
    private Human mother;
    private Human brotherOrSister;
    private List<Human> brothersOrSisters = new ArrayList<>();

    private List<Human> children = new ArrayList<>();

    private recording recording;

    public Human() {
    }

    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Human(String name, String gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        addNewbornToParents(father, mother);
        addBrotherOrSister(this, mother, father);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getBrotherOrSister() {
        return brotherOrSister;
    }

    public void setBrotherOrSister(Human brotherOrSister) {
        this.brotherOrSister = brotherOrSister;
    }

    public List<Human> getBrothersOrSisters() {
        return brothersOrSisters;
    }

    public void setBrothersOrSisters(List<Human> brothersOrSisters) {
        this.brothersOrSisters = brothersOrSisters;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public recording getWritable() {
        return recording;
    }

    public void setWritable(recording recording) {
        this.recording = recording;
    }

    public void addBrotherOrSister(Human newborn, Human mother, Human father) {
        if (father.children.size() > 1) {
            for (Human human : father.children) {
                if (human != newborn) {
                    newborn.brothersOrSisters.add(human);
                    human.brothersOrSisters.add(newborn);
                }
            }
        }

    }

    public void addNewbornToParents(Human father, Human mother) {
        father.children.add(this);
        mother.children.add(this);

    }

    public void save(List<Human> list) throws IOException {

        if (recording != null) {
            recording.save(list);
        }
    }

    public List<Human> read() throws FileNotFoundException, ClassNotFoundException, IOException {
        return (List<Human>) recording.read();

    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Human o) {
        // TODO Auto-generated method stub
        return name.compareTo(o.getName());
    }
}