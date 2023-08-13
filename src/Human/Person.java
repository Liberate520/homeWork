package Human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birth;
    private LocalDate death;
    private List<Person> parents;
    private List<Person> children;
    private Person spouse;

    public Person(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Person father, Person mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birth = birthDate;
        this.death = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Person(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public Person(String name, Gender gender, LocalDate birthDate, Person father, Person mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public boolean addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Person parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Person getFather() {
        for (Person parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Person getMother() {
        for (Person parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (death == null) {
            return getPeriod(birth, LocalDate.now());
        } else {
            return getPeriod(birth, death);
        }
    }

    private int getPeriod(LocalDate birth, LocalDate death) {
        Period difference = Period.between(birth, death);
        return difference.getYears();
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    public LocalDate getDeath() {
        return death;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getSpouseInfo() {
        String res = "spouse: ";
        if (spouse == null) {
            res += "none";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "mother: ";
        Person mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += " N/A";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "father: ";
        Person father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += " N/A";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else{
            res.append("none");
        }
        return  res.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return person.getId() == getId();
    }
}
