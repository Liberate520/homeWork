import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human extends Individual implements Serializable, Comparable<Human> {
    private String name;
    private Gender gender;
    private Integer yearofbirth;
    private Human father;
    private Human mother;
    private List<Human> children;

    
    public Human(String name, Gender gender, Integer yearofbirth, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.yearofbirth = yearofbirth;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, Integer yearofbirth) {
        this(name, gender, yearofbirth, null, null);
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public String getName() {
        return name;
    }

    public Integer getYearofbirth() {
        return yearofbirth;
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

    public String getInfo() {
        return String.format("Имя: %s; Пол: %s; Год рождения: %d; Отец: %s; Мать: %s.", name, gender, yearofbirth,
                getFatherInfo(), getMotherInfo());
    }

    public String getMotherInfo() {
        String rez = "";
        if (mother != null) {
            rez += mother.name;
        } else {
            rez = "неизвестна";
        }
        return rez;
    }

    public String getFatherInfo() {
        String rez = "";
        if (father != null) {
            rez += father.name;
        } else {
            rez = "неизвестен";
        }
        return rez;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

}
