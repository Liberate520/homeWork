package tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private static int global_id;
    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, Gender gender, Human father, Human mother) { //общий конструктор
        this.id = ++global_id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, LocalDate yearOfBirth, Gender gender) { // конструктор без родителей/детей
        this(name, yearOfBirth, gender, null, null);
    }

    public void addChildren(Human child) {
        children.add(child);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(", ");
        stringBuilder.append(getChildrenInfo());
        return stringBuilder.toString();
    }

    private String getMotherInfo() {
        String motherName = "мать: ";
        if (mother != null) {
            motherName += mother.getName();
        } else {
            motherName += "неизвестна";
        }
        return motherName;
    }

    private String getFatherInfo() {
        String fatherName = "отец: ";
        if (mother != null) {
            fatherName += father.getName();
        } else {
            fatherName += "неизвестен";
        }
        return fatherName;
    }

    private String getChildrenInfo() {
        StringBuilder strbld = new StringBuilder();
        strbld.append("дети: ");
        if (children.size() != 0) {
            strbld.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                strbld.append(", ");
                strbld.append(children.get(i).getName());
            }
        } else {
            strbld.append("отсутсвуют");
        }
        return strbld.toString();
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Human)) {
//            return false;
//        }
//        Human human = (Human) obj;
//        return human.getName().equals(getName());
//    }
}



