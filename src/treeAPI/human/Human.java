package treeAPI.human;

import treeAPI.sample.Sample;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Human implements Sample, Comparable<Human>, Serializable {

    private List<String> fio;
    private boolean isMale;
    private Calendar birthDay;
    private Calendar deathDay;
    private Map<Human, Boolean> married;
    private List<Human> children;
    private List<Human> parents;

    public Human(String fio, Human human){
        this(fio, human.isMale, human.birthDay, human.deathDay, human.married, human.children, human.parents);
    }

    public Human(String fio, boolean isMale, Calendar birthDay){
        this(fio, isMale, birthDay, null, new HashMap<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Human(String fio, boolean isMale, Calendar birthDay, Calendar deathDay) {
        this(fio, isMale, birthDay, deathDay, new HashMap<>(), new ArrayList<>(), new ArrayList<>());
    }

    private Human(String fio, boolean isMale, Calendar birthDay, Calendar deathDay, Map<Human, Boolean> married, List<Human> children, List<Human> parents) {
        this.setFio(fio);
        this.isMale = isMale;
        this.birthDay = birthDay;
        this.deathDay = deathDay;
        this.married = married;
        this.children = children;
        this.parents = parents;
    }

    public int countChildren() {
        return this.children.size();
    }
    private int countParents() {
        return this.parents.size();
    }
    public boolean hasMarried(Human married) {
        return this.married.containsKey(married);
    }
    public boolean hasChild(Human child) {
        return this.children.contains(child);
    }
    private boolean hasParent(Human parent) {
        return this.parents.contains(parent);
    }

    public void setFio(String fio){
        setFio(new ArrayList<>(Arrays.asList(fio.split(","))));
    }
    private void setFio(List<String> fio){
        this.fio = fio;
    }

    public List<String> getFio() {return this.fio;}
    public Boolean getGender() {return this.isMale;}
    public Calendar getBirthDay() {return this.birthDay;}
    public Calendar getDeathDay() {return this.deathDay;}
    public Map<Human, Boolean> getMarrieds() {return this.married;}
    public List<Human> getChildren() {return this.children;}
    public List<Human> getParents() {return this.parents;}
    public String getNameString() {
        return this.fio.stream().map(Object::toString).collect(Collectors.joining(" "));
    }


    public boolean addParent(Sample parent) {
        if (!this.hasParent((Human) parent)){//Каст до типа Human
            ((List<Human>) this.getParents()).add((Human) parent);
        }
        return false;
    }

    public boolean addChildren(Sample child) {
        if (!this.hasChild((Human) child)) {
            ((List<Human>) this.getChildren()).add((Human) child);
            child.addParent(this);
            return true;
        }
        return false;
    }

    public boolean addMarried(Sample married, boolean isMarried) {
        if (!this.hasMarried((Human) married)) {
            this.getMarrieds().put((Human) married, isMarried);
            married.addMarried(this, isMarried);
            return true;
        }
        return false;
    }

    // Получить личность супруга.
    public Human getMarried(){
        if (getMarrieds().containsValue(true)){
            for (Map.Entry<Human, Boolean> entry : this.getMarrieds().entrySet())
                if (entry.getValue())
                    return entry.getKey();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Human person = (Human) o;
        return isMale == person.isMale && Objects.equals(fio, person.fio) && Objects.equals(birthDay, person.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, isMale, birthDay);
    }

    public int compareTo(Human p) {
        int result = this.getFio().get(0).compareTo(p.getFio().get(0));
        if (result == 0) result = this.getFio().get(1).compareTo(p.getFio().get(1));
        if (result == 0) {
            result = this.getBirthDay().compareTo(p.getBirthDay());
        }
        return result;
    }

    public void updateLinks() {
        this.updateChildren();
        this.updateParents();
    }

    private void updateChildren() {
        if (this.countChildren() > 0) {
            for (Human person : this.children) {
                person.addParent(this);
            }
        }
    }

    private void updateParents() {
        if (this.countParents() > 0) {
            for (Human person : this.parents) {
                person.addChildren(this);
            }
        }
    }

}
