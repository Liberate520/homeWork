import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Human extends Individual implements Serializable, Comparable<Human> {
    private String name;
    private Gender gender;
    private Date birthDate;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Presenter presenter;
    private Console console;

    public Human(String name, Gender gender, Date birthDate) {
        this(name, gender, birthDate, null, null);
    }

    public Human(String name, Gender gender, Date birthDate, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }


    public List<Human> getChildren() {
        return children;
    }


    public Human(String name2, String gender2, Integer yearofbirth2, String father2, String mother2) {
    }

       public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    
    // public void setPresenter(Presenter presenter){
    //     this.presenter = presenter;
    // }

    public String getName() {
        return name;
    }

    public Date getBirthDate() { return birthDate; }

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
        return String.format("Имя: %s; Пол: %s; Год рождения: %d; Отец: %s; Мать: %s.", name, gender, birthDate,
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
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }

    public  void removeChild(Human human) {
        children.remove(human);
    }
    
    public void removeMother() {
        mother = null;
    }

    public void removeFather() {
        father = null;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

}
