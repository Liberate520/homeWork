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
    private Presenter presenter;
    private Console console;

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

    public Human(String name2, String gender2, Integer yearofbirth2, String father2, String mother2) {
    }

    public boolean addChild(Human human) {
        if (!children.contains(human)) {
            children.add(human);
            return true;
        }
        return false;
    }
    
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
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
