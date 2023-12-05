package model.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String firstName;
    private String secondName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human couple;

    public Human(String firstName, String secondName, Gender gender, LocalDate birthDate,
                 LocalDate deathDate, Human father, Human mother){
        id = -1;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null ){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String firstName, String secondName, Gender gender, LocalDate birthDate){
        this(firstName, secondName, gender, birthDate, null, null, null);
    }

    public Human(String firstName, String secondName, Gender gender, LocalDate birthDate,
                 Human father, Human mother){
        this(firstName, secondName, gender, birthDate, null, father, mother);
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if(!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }


    public Human getFather() {
        for (Human parent: parents){
            if (parent.getGender() == Gender.MALE){
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent: parents){
            if (parent.getGender() == Gender.FEMALE){
                return parent;
            }
        }
        return null;
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setCouple(Human couple) {
        this.couple = couple;
    }

    public Human getCouple() {
        return couple;
    }

    public String getName() {
        return firstName + " " + secondName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(firstName);
        sb.append(", surname: ");
        sb.append(secondName);
        sb.append(", sex: ");
        sb.append(getGender());
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getCoupleInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getCoupleInfo(){
        String res = "spouse: ";
        if (couple == null){
            res += "no";
        } else {
            res += couple.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "mother: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "father: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("not exist");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
