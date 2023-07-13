package homeWork;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private Gender gender;
    private int age;
    private LocalDate birthdate;
    private LocalDate deathdate;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthdate, LocalDate deathdate, Human father, Human mother,
            List<Human> children) {
        this.name = name;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.gender = gender;
        if (mother != null) {
            parents.add(mother);
            if (father != null) {
                parents.add(father);
            }
            children = new ArrayList<>();
        }
    }

    // public Human(String name, Gender gender, LocalDate birthdate) {
    // this.name = name;
    // this.birthdate = birthdate;
    // this.deathdate = deathdate;
    // this.gender = gender;
    // this.parents = new ArrayList<>();
    // this.children = new ArrayList<>();
    // }
    // public Human( String name, Gender gender, LocalDate birthDate) {
    // this( name, gender, birthDate, null, null, null, null);
    // }
    public Human(String name, Gender gender, LocalDate birthdate, int age) {
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.age = getAge();
    }

    public Human(String name, Gender gender, LocalDate birthdate, int age, List<Human> parents, List<Human> children) {
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.age = getAge();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public LocalDate getBirthDate() {
        return birthdate;
    }

    public LocalDate getDeathDate() {
        return deathdate;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male)
                return parent;
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female)
                return parent;
        }
        return null;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        // sb.append(getMotherInfo());
        // sb.append(", ");
        // sb.append(getFatherInfo());
        // sb.append(", ");
        // sb.append(getChildrenInfo());
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
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
        boolean result;
        if (this == obj) {
            result = true;
        } else if (!(obj instanceof Human)) {
            result = false;
        } else {
            Human human = (Human) obj;
            result = human.getName().equals(getName());
        }
        return result;
    }

    public int getAge() {
        int age = 0;
        if (deathdate != null) {
            age = Period.between(birthdate, deathdate).getYears();
        } else {
            age = Period.between(birthdate, LocalDate.now()).getYears();
        }
        return age;
    }

    public List<Human> getParents() {
        return parents;
    }
}