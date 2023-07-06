package familyTree.Human;

import java.io.Serializable;
import java.time.*;
//import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private Integer id;
    private String surname;
    private String name;
    private Gender gender;
    private Integer Age;
    private LocalDate dateOfBirthday;
    private LocalDate dateOfDeath;
    private List<Human> parents;
    private List<Human> children;

    public Human(String surname, String name, Gender gender, LocalDate dateOfBirthday, LocalDate dateOfDeath, Human father, Human mother) {
        this.surname = surname;
        this.name = name;
        this.gender = gender;
        this.dateOfBirthday = dateOfBirthday;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String surname, String name, Gender gender, LocalDate dateOfBirthday) {
        this(surname, name, gender, dateOfBirthday, null, null, null);
    }

    public Human(String surname, String name, Gender gender, LocalDate dateOfBirthday, Human father, Human mother) {
        this(surname, name, gender, dateOfBirthday, null, father, mother);
    }

    public boolean addChild(Human child){
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }
    public void getAge(Integer Age) {
        this.Age = Age;
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }
    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }
    public List<Human> getParents() {
        return parents;
    }
    public List<Human> getChildren() {
        return children;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }
    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Human getFather() {
        for (Human parent: parents) {
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }
    public Human getMother() {
        for (Human parent: parents) {
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append(" Фамилия: ");
        sb.append(surname);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getFatherInfo() {
        String result = "отец: ";
        Human father = getFather();
        if (father != null) {
            result += father.getName();
        } else {
            result += "неизвестен";
        }
        return result;
    }

    public String getMotherInfo() {
        String result = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            result += mother.getName();
        } else {
            result += "неизвестна";
        }
        return result;
    }

    public String getChildrenInfo() {
        StringBuilder result = new StringBuilder();
        result.append("дети: ");
        if (children.size() != 0){
            result.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                result.append(", ");
                result.append(children.get(i).getName());
            }
        } else {
            result.append("отсутствуют");
        }
        return result.toString();
    }

    public int getAge () {
        if (dateOfDeath == null){
            return getPeriod(dateOfBirthday, LocalDate.now());
        } else {
            return getPeriod(dateOfBirthday, dateOfDeath);
        }
    }

    public int getPeriod(LocalDate dateOfBirthday, LocalDate dateOfDeath) {
        Period period = Period.between(dateOfBirthday, dateOfDeath);
        period = Period.between(dateOfBirthday, dateOfDeath);
        return period.getYears();
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
        return human.getName().equals(getName());
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    public void sortBySurname() {
        Human.sortByName();
    }
    public static void sortByName() {
        Human.sortByName();
    }
    public static void sortByAge() {
        Human.sortByAge();
    }
}
