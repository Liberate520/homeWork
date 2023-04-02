package HW_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private String name;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Gender sex;
    private LocalDate birthday;
    private LocalDate deathDate;

    public Human(String name, Human mother, Human father,
                 Gender sex, LocalDate birthday, LocalDate deathDate) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        this.sex = sex;
        this.birthday = birthday;
        this.deathDate = deathDate;
    }

    public Human(String name, Gender sex) {
        this.name = name;
        this.sex = sex;
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String toString() {
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

    public String getMotherInfo() {
        String res = "мать: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("дети: ");
        if (children != null) {
            if (children.isEmpty()) {
                sb.append("детей нет ");
                return sb.toString();
            }

            for (Human item : children) {
                sb.append(item.getName());
                sb.append(", ");
            }

        } else {
            sb.append("детей нет ");
        }

        return sb.toString();
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && sex == human.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }
}

enum Gender {
    male, female
}
