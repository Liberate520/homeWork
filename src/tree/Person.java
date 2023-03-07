package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private Integer dateOfBirth;
    private Integer dateOfDeath;
    private List<Person> children;
    private Gender gender;
    private Person father;
    private Person mother;

    public Person(String name, Gender gender, Integer dateOfBirth) {
        this(name, gender, dateOfBirth, null, null);
    }

    public Person(String name, Gender gender, Integer dateOfBirth, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public boolean addChild(Person child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public List<Person> getChildren() { return children; }

    public String getName() { return name; }

    public Integer getDateOfBirth() { return dateOfBirth; }

    public Integer getDateOfDeath() { return dateOfDeath; }

    public Person getFather() { return father; }

    public Person getMother() { return mother; }

    public Gender getGender() { return gender; }

    public void setDateOfBirth(Integer dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public void setDateOfDeath(Integer dateOfDeath) { this.dateOfDeath = dateOfDeath; }

    public void setFather(Person father) { this.father = father; }

    public void setMother(Person mother) { this.mother = mother; }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getMotherInfo() {
        String res = "мать: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    private String getFatherInfo() {
        String res = "отец: ";
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return person.getName().equals(getName());
    }
}
